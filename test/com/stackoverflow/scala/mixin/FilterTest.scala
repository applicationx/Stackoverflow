package com.stackoverflow.scala.mixin

import org.junit.Assert._
import org.junit.Test

/**
  * Created by jonasd on 2016-11-11.
  */
class FilterTest {

  @Test
  def testFilter(): Unit = {
    val filter: SourceFilter[String] = new SourceFilter[String](List("one", "two", "three")) with BlackWhiteCacheFilter[String]
    assertEquals("Should not find \"test\"", false, filter.isAccepted("test").getOrElse(true))
    assertEquals("Should find \"one\"",true, filter.isAccepted("one").getOrElse(false))
    assertEquals("Should find \"one\"",true, filter.isAccepted("one").getOrElse(false))
  }
}
