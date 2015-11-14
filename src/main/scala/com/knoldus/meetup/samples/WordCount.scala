package com.knoldus.meetup.samples

import com.knoldus.meetup.core.CoreSystemApi
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.DataFrame

class WordCount(coreSystemApi: CoreSystemApi) {

  def get(url: String): DataFrame = {
    import coreSystemApi.sqlContext.implicits._

    val linesDF = coreSystemApi.sqlContext.sparkContext.textFile(url).toDF("line")
    val wordsDF = linesDF.explode("line", "word")((line: String) => line.split(" "))

    wordsDF.groupBy("word").count()
  }

  def getRDD(url: String): RDD[(String, Int)] = {
    val linesRDD = coreSystemApi.sc.textFile(url)

    linesRDD.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)
  }

}
