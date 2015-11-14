package com.knoldus.meetup.samples

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

}
