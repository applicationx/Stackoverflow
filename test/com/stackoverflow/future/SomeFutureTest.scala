package com.stackoverflow.future

import org.junit.Test
import org.junit.Assert._

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by jonasd on 2016-11-03.
  */
class SomeFutureTest {

  implicit val ec = ExecutionContext.global

  @Test
  def testingFuture(): Unit = {
    val futureWork: Future[String] = SomeFuture.doFutureWork("a Word")
    futureWork.onComplete {
      case t => println(t)
      case default => println("default")
    }
    assertEquals(true, true)
  }
}
