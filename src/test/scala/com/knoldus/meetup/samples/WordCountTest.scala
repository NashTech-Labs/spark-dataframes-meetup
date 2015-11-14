package com.knoldus.meetup.samples

import com.knoldus.meetup.core.TestData.{TAKE, URL}
import com.knoldus.meetup.core.TestSystem
import org.scalatest.FunSuite

class WordCountTest extends FunSuite {

  private val sample = new WordCount(TestSystem)

  test("get word count") {
    val result = sample.get(URL)

    assert(result.columns.length === 2)
  }

  test("get word count rdd") {
    val result = sample.getRDD(URL)

    assert(result.take(TAKE).length === 20)
  }

}
