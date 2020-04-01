package maribiel.sparkjob.spark.jobs

import maribiel.sparkjob.config.Config
import maribiel.sparkjob.creditcard.Schema
import maribiel.sparkjob.spark.{DataReader, SparkConfig}

object InitialLoadToCassandra extends SparkJob("Initial Import to Cassandra") {
  def main(args: Array[String]): Unit = {

    Config.parseArgs(args)

    import sparkSession.implicits._

    val ishDF    = DataReader.read(SparkConfig.ihsDatasource, Schema.IHSSourceSchema)
    val ihsNewDF = DataReader.read(SparkConfig.ihsNewDatasource, Schema.IHSSourceSchema)

    val distDF     = ishDF.select("IHS_MEASURE","IHS_COUNTRY","IHS_YEAR")
                          .distinct.orderBy("IHS_MEASURE","IHS_COUNTRY","IHS_YEAR")

    val distsNewDF = ihsNewDF.select("IHS_MEASURE","IHS_COUNTRY","IHS_YEAR")
                             .distinct.orderBy("IHS_MEASURE","IHS_COUNTRY","IHS_YEAR")

    val difDF = distDF.except(distsNewDF)

  //  ishDF.write
  //    .format("com.databricks.spark.csv")
  //    .save("myFile.csv")

    difDF
      .repartition(1)
      .write
      .mode ("overwrite")
      .format("com.databricks.spark.csv")
      .option("header", "true")
      .save("src/main/resources/data/targetfile.csv")





  }

}
