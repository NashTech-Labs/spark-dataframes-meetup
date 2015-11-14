package com.knoldus.meetup.samples

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

class WordCountAverager(wordCount: WordCount) {

  def average(url: String): DataFrame = {
    val wordCountDF = wordCount.get(url)

    wordCountDF.agg(avg("count"))
  }

  def averageRDD(url: String): Double = {
    val wordCountRDD = wordCount.getRDD(url)

    val (_, (sum, n)) = wordCountRDD.map{case (word, count) => (word, (count, 1))}
      .reduce{case ((word1,(count1, n1)),(word2,(count2, n2))) => ("", (count1 + count2, n1 + n2))}

    sum.toDouble/n
  }

}
