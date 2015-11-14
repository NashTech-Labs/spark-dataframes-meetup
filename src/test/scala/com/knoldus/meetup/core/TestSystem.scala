package com.knoldus.meetup.core

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext

object TestSystem extends CoreSystemApi {

  override val sc = new SparkContext(new SparkConf().setAppName("test").setMaster("local"))

  override val sqlContext = new SQLContext(sc)

}

object TestData {

  import TestSystem._
  import sqlContext.implicits._

  val URL = "src/test/resources/file.txt"
  val TAKE = 20
  val DATA_FRAME = sqlContext.sparkContext.textFile(URL).toDF("line").explode("line", "word")((line: String) => line.split(" ")).groupBy("word").count()
  val RDD = sc.textFile(URL).flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)

}
