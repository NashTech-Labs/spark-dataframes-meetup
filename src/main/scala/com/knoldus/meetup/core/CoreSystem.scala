package com.knoldus.meetup.core

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

trait CoreSystemApi {

  val sc: SparkContext
  val sqlContext: SQLContext

}

object CoreSystem extends CoreSystemApi {

  override val sc = new SparkContext(new SparkConf().setAppName("meetup").setMaster("local[*]"))
  override val sqlContext = new SQLContext(sc)

}
