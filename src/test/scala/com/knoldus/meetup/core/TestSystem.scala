package com.knoldus.meetup.core

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext

object TestSystem extends CoreSystemApi {

  private val sc = new SparkContext(new SparkConf().setAppName("test").setMaster("local"))

  override val sqlContext = new SQLContext(sc)

}
