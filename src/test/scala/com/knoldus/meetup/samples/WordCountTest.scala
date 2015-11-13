package com.knoldus.meetup.samples

import com.knoldus.meetup.core.TestSystem
import org.scalatest.FunSuite

class WordCountTest extends FunSuite {

  private val sample = new WordCount(TestSystem)

  test("get word count") {
    val result = sample.get("src/test/resources/file.txt")
    assert(result.columns.length === 2)
  }

}
