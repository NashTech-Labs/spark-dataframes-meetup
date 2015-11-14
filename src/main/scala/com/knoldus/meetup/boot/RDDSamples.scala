package com.knoldus.meetup.boot

import com.knoldus.meetup.core.CoreSystem
import com.knoldus.meetup.samples.WordCount
import org.apache.log4j.{Logger, Level}

object RDDSamples extends App {

  // Turn off spark's default logger
  Logger.getLogger("org").setLevel(Level.OFF)

  private val URL = "src/main/resources/file.txt"
  private val TAKE = 20

  val wordCount = new WordCount(CoreSystem)

  wordCount.getRDD(URL).take(TAKE).map{case (word, count) => println(s"Word: $word, Count: $count")}

}
