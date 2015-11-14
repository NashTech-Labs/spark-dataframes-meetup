package com.knoldus.meetup.boot

import com.knoldus.meetup.core.CoreSystem
import com.knoldus.meetup.samples.{WordCountAverager, WordCountSorter, WordCount}
import org.apache.log4j.{Level, Logger}

object DataFrameSamples extends App {

  // Turn off spark's default logger
  Logger.getLogger("org").setLevel(Level.OFF)

  private val URL = "src/main/resources/file.txt"

  val wordCount = new WordCount(CoreSystem)

  wordCount.get(URL).show()

  val wordCountSorter = new WordCountSorter(wordCount)

  wordCountSorter.sort(URL).show()

  wordCountSorter.sort(URL, false).show()

  val averager = new WordCountAverager(wordCount)

  averager.average(URL).show()

}
