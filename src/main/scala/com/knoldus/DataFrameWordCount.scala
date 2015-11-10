package com.knoldus

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object DataFrameWordCount extends App {
  // Turn off spark's default logger
  Logger.getLogger("org").setLevel(Level.OFF)

  // Create Spark and SQL Context
  val sc = new SparkContext(new SparkConf().setAppName("word-count").setMaster("local"))
  val sqlContext = new SQLContext(sc)

  // Import implicits required to convert RDD to DataFrame
  import sqlContext.implicits._

  // Code snippet to get word count
  val linesDF = sc.textFile("src/main/resources/file.txt").toDF("line")
  val wordsDF = linesDF.explode("line","word")((line: String) => line.split(" "))
  val wordCountDF = wordsDF.groupBy("word").count()
  wordCountDF.show()
}
