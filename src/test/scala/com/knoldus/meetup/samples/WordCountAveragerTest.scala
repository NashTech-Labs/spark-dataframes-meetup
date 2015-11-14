package com.knoldus.meetup.samples

import com.knoldus.meetup.core.TestData.{DATA_FRAME, URL}
import org.mockito.Mockito.when
import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar

class WordCountAveragerTest extends FunSuite with MockitoSugar {

  private val wordCount = mock[WordCount]
  private val averager = new WordCountAverager(wordCount)

  test("average count of words") {
    when(wordCount.get(URL)).thenReturn(DATA_FRAME)

    val result = averager.average(URL)

    assert(result !== 0)
  }

}
