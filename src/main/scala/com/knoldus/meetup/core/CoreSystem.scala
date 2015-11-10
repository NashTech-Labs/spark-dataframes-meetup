package com.knoldus.meetup.core

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

trait CoreSystemApi {
  val sqlContext: SQLContext
}

object CoreSystem extends CoreSystemApi {
  private val sc = new SparkContext(new SparkConf().setAppName("meetup").setMaster("local[*]"))
  override val sqlContext = new SQLContext(sc)
}
