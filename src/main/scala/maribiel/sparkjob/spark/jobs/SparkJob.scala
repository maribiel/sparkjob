package maribiel.sparkjob.spark.jobs

import maribiel.sparkjob.spark.SparkConfig
import org.apache.spark.sql.SparkSession

abstract class SparkJob(appName:String) {

  lazy implicit val sparkSession = SparkSession.builder
    .config(SparkConfig.sparkConf)
    .getOrCreate()

}
