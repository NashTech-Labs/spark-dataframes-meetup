package com.knoldus.meetup.samples

import com.knoldus.meetup.core.TestSystem
import org.scalatest.FunSuite
import com.knoldus.meetup.core.TestData.URL

class WordCountTest extends FunSuite {

  private val sample = new WordCount(TestSystem)

  test("get word count") {
    val result = sample.get(URL)

    assert(result.columns.length === 2)
  }

}
