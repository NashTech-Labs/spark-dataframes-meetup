package com.knoldus.meetup.samples

import com.knoldus.meetup.core.TestData
import com.knoldus.meetup.core.TestData.{TAKE, RDD, DATA_FRAME, URL}
import org.mockito.Mockito.when
import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar

class WordCountSorterTest extends FunSuite with MockitoSugar {

  private val wordCount = mock[WordCount]
  private val sorter = new WordCountSorter(wordCount)

  test("sort in ascending order") {
    when(wordCount.get(URL)).thenReturn(DATA_FRAME)

    val result = sorter.sort(URL)

    assert(result.columns.length === DATA_FRAME.columns.length)
  }

  test("sort in descending order") {
    when(wordCount.get(URL)).thenReturn(DATA_FRAME)

    val result = sorter.sort(URL, false)

    assert(result.columns.length === DATA_FRAME.columns.length)
  }

  test("sort in ascending order using rdd") {
    when(wordCount.getRDD(URL)).thenReturn(RDD)

    val result = sorter.sortRDD(URL)

    assert(result.take(TAKE).length === RDD.take(TAKE).length)
  }

  test("sort in descending order using rdd") {
    when(wordCount.getRDD(URL)).thenReturn(RDD)

    val result = sorter.sortRDD(URL, false)

    assert(result.take(TAKE).length === RDD.take(TAKE).length)
  }

}
