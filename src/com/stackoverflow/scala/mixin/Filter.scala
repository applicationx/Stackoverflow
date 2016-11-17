package com.stackoverflow.scala.mixin

/**
  * Created by jonasd on 2016-11-11.
  */
trait ResetCallback {
  def reset: Unit
}
trait Filter[T] {
//  type T
  def isAccepted(obj: T): Option[Boolean] = {
    None
  }
  def reset: Unit = {}
}

trait BlackWhiteCacheFilter[T] extends Filter[T] with ResetCallback {
  var whiteList:List[T] = List[T]()
  var blackList:List[T] = List[T]()
//  type T = String

  override def isAccepted(obj: T): Option[Boolean] = {
    println("FilterCache.isAccepted is called")
    if (blackList exists (o => o equals obj))
      return Some(false)
    if (whiteList exists (o => o equals obj))
      return Some(true)
    val accepted = super.isAccepted(obj)
    accepted match {
      case Some(true) => whiteList = obj :: whiteList
      case Some(false) => blackList = obj :: blackList
      case None => println("Should not get here...")
    }
    println(s"whiteList: ${whiteList.size}")
    println(s"blackList: ${blackList.size}")
    accepted
  }
}

class SourceFilter[T](theList: List[T]) extends Filter[T] with ResetCallback {

  override def isAccepted(obj: T): Option[Boolean] = {
    println("SourceFilter.isAccepted is called")
    Some(theList.exists(o => o.equals(obj)))
  }
}