package maribiel.sparkjob.spark.jobs

import maribiel.sparkjob.config.Config
import maribiel.sparkjob.creditcard.Schema
import maribiel.sparkjob.spark.{DataReader, SparkConfig}

object FraudDetectionTraining extends SparkJob("Build Data Model") {

  def main(args: Array[String]): Unit = {
    Config.parseArgs(args)

    import sparkSession.implicits._

    val uberDF = DataReader.read(SparkConfig.ihsDatasource, Schema.uberSchema)
// add feature column



  }

}
