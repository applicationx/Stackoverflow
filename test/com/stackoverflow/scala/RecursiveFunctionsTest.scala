package com.stackoverflow.scala

import org.junit.Test

/**
  * Created by jonasd on 2016-11-08.
  */
class RecursiveFunctionsTest {


  @Test
  def recursiveTest(): Unit = {
    val strings: List[String] = List("ett", "tva", "tre")
    RecursiveFunctions.executeOnEveryElement(strings) {
      x => println(x)
    }
  }
}
