package com.knoldus.meetup.boot

import com.knoldus.meetup.core.CoreSystem
import com.knoldus.meetup.samples.{WordCountSorter, WordCount}
import org.apache.log4j.{Logger, Level}

object RDDSamples extends App {

  // Turn off spark's default logger
  Logger.getLogger("org").setLevel(Level.OFF)

  private val URL = "src/main/resources/file.txt"
  private val TAKE = 20

  val wordCount = new WordCount(CoreSystem)

  println("Word Count :")
  wordCount.getRDD(URL).take(TAKE).map{case (word, count) => println(s"Word: $word, Count: $count")}
  println()

  val wordCountSorter = new WordCountSorter(wordCount)

  println("Word Count in Ascending order : ")
  wordCountSorter.sortRDD(URL).take(TAKE).map{case (word, count) => println(s"Word: $word, Count: $count")}
  println()
  println()
  println("Word Count in Descending order :")
  wordCountSorter.sortRDD(URL, false).take(TAKE).map{case (word, count) => println(s"Word: $word, Count: $count")}
  println()

}
