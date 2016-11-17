package com.stackoverflow.scala

/**
  * Created by jonasd on 2016-11-08.
  */
class RecursiveFunctions {

}
object RecursiveFunctions {

  def executeOnEveryElement[A](collection: TraversableOnce[A])(work: (A) => Unit): Unit =  {
    collection match {
      case head::tail =>
        work(head)
        executeOnEveryElement(tail)(work)
      case Nil =>
    }
  }
}