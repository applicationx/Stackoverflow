package com.stackoverflow.future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by jonasd on 2016-11-02.
  */
class SomeFuture {

}
object SomeFuture {
  implicit val ec = ExecutionContext.global

  def doFutureWork(word: String): Future[String] = Future (
      word
    )

}
