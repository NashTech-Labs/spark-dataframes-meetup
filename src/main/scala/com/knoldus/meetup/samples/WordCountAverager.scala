package com.knoldus.meetup.samples

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

class WordCountAverager(wordCount: WordCount) {

  def average(url: String): DataFrame = {
    val wordCountDF = wordCount.get(url)

    wordCountDF.agg(avg("count"))
  }

}
