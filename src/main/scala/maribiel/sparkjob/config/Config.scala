package maribiel.sparkjob.config

import java.io.File

import com.typesafe.config.Config
import maribiel.sparkjob.spark.SparkConfig
import com.typesafe.config.{Config, ConfigFactory}
import maribiel.sparkjob.casandra.CassandraConfig
import org.apache.log4j.Logger


object Config {
  val logger = Logger.getLogger(getClass.getName)

  var applicationConf: Config = _

  var runMode = "local"
  var localProjectDir = ""

  /**
   * Parse a config object from application.conf file in src/main/resources
   * @param args
   * @return
   */
  def parseArgs(args: Array[String]): Unit = {
    if(args.size == 0) {
      defaultSetting()
    } else {
      applicationConf = ConfigFactory.parseFile(new File(args(0)))
      if(runMode == "local"){
        localProjectDir = s"file:///${System.getProperty("user.home")}/frauddetection/"
      }
      loadConfig()
    }
  }
  def loadConfig() {
    SparkConfig.load
    CassandraConfig.load()
  }

  def defaultSetting(): Unit = {
    SparkConfig.defaultSetting()
    CassandraConfig.defaultSettng()
  }


}
