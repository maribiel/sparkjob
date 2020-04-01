package maribiel.sparkjob.spark

import java.util.logging.Logger

import org.apache.spark.SparkConf

object SparkConfig {

  val logger = Logger.getLogger(getClass.getName)

  val sparkConf = new SparkConf

  var transactionDatasource:String = _
  var customerDatasource:String = _
  var ihsDatasource: String = _
  var ihsNewDatasource: String = _
  var uberDatasource: String = _
  var modelPath:String = _
  var kmeansModelPath:String = _
  var preprocessingModelPath:String = _
  var shutdownMarker:String = _
  var batchInterval:Int = _

  def load() {
    logger.info("Loading Spark Settings")

  }

  def defaultSetting(): Unit = {
    sparkConf.setMaster("local[*]")
    //  .set("spark.cassandra.connection.host", CassandraConfig.cassandrHost)
    //  .set("spark.sql.streaming.checkpointLocation", "/tmp/checkpoint")
    shutdownMarker = "/tmp/shutdownmarker"
    ihsDatasource = "src/main/resources/data/Import_IHS.csv"
    ihsNewDatasource = "src/main/resources/data/Import_IHS_new.csv"
    uberDatasource = "src/main/resources/data/src_main_resources_uber.csv"
    transactionDatasource = "src/main/resources/data/transactions.csv"
    customerDatasource = "src/main/resources/data/customer.csv"
    kmeansModelPath = "src/main/resources/spark/training/KmeansModel"
    modelPath = "src/main/resources/spark/training/RandomForestModel"
    preprocessingModelPath = "src/main/resources/spark/training/PreprocessingModel"
    batchInterval = 5000
  }


}
