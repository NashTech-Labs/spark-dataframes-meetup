package com.knoldus.meetup.samples

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

class WordCountSorter(wordCount: WordCount) {

  def sort(url: String, flag: Boolean = true): DataFrame = {
    val wordCountDF = wordCount.get(url)

    if(flag) {
      wordCountDF.sort("count")
    } else {
      wordCountDF.sort(desc("count"))
    }
  }

  def sortRDD(url: String, flag: Boolean = true): RDD[(String, Int)] = {
    val wordCountRDD = wordCount.getRDD(url)

    wordCountRDD.map(_.swap).sortByKey(flag).map(_.swap)
  }

}
