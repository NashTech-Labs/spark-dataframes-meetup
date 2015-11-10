package com.knoldus.meetup.boot

import com.knoldus.meetup.core.CoreSystem
import com.knoldus.meetup.samples.WordCount
import org.apache.log4j.{Level, Logger}

object BootApplication extends App {
  // Turn off spark's default logger
  Logger.getLogger("org").setLevel(Level.OFF)

  val wordCount = new WordCount(CoreSystem).get()
  println("Word Count is ::: ")
  wordCount.show()
}
