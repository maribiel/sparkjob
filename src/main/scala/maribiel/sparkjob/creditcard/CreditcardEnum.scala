package maribiel.sparkjob.creditcard

object  Enums {

  object UberSource extends Enumeration {
    val time = "time"
    val lat  = "lat"
    val lon  = "lon"
    val base = "base"

  }

  object IHSSource extends Enumeration {
    val IHS_MEASURE = "IHS_MEASURE"
    val IHS_COUNTRY = "IHS_COUNTRY"
    val IHS_YEAR = "IHS_YEAR"
    val IHS_VALUE = "IHS_VALUE"

  }

  object TransactionKafka extends Enumeration {

    val cc_num = "cc_num"
    val first = "first"
    val last = "last"
    val trans_num = "trans_num"
    val trans_date = "trans_date"
    val trans_time = "trans_time"
    val unix_time = "unix_time"
    val category = "category"
    val merchant = "merchant"
    val amt = "amt"
    val merch_lat = "merch_lat"
    val merch_long = "merch_long"
    val distance = "distance"
    val age = "age"
    val is_fraud = "is_fraud"
    val kafka_partition = "partition"
    val kafka_offset = "offset"

  }

  object Customer extends Enumeration {

    val cc_num = "cc_num"
    val first = "first"
    val last = "last"
    val gender = "gender"
    val street = "street"
    val city = "city"
    val state = "state"
    val zip = "zip"
    val lat = "lat"
    val long = "long"
    val job = "job"
    val dob = "dob"
  }

  val TransactionCassandra = TransactionKafka
  val UberSourceCasandra   = UberSource
}