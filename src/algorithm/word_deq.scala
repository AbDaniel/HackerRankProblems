package algorithm

import java.util.Scanner

import scala.collection.immutable.IndexedSeq

/**
  * Created by abdaniel on 9/21/16.
  */
object word_deq {

  def getStr(tuples: List[(Char, Char)]) = {
    tuples.map {
      case (x, y) => x
    }.mkString("")
  }

  def replace(tuples: List[(Char, Char)]): List[(Char, Char)] = {
    def go(tuples: List[(Char, Char)], acc: List[(Char, Char)]): List[(Char, Char)] = tuples match {
      case Nil => acc
      case x :: xs if x._1 != x._2 => xs.reverse ::: List((x._1, x._2)) ::: acc
      case x :: xs => go(xs, x :: acc)
    }

    go(tuples, List()).reverse
  }

  def distance(tuples: List[(Char, Char)], acc: Int, dict: Set[String]): Int = {
    val sameString = tuples.forall {
      case (x, y) => x == y
    }
    if (sameString) acc
    else if (!dict.contains(getStr(tuples))) -1
    else {
      distance(replace(tuples), acc + 1, dict)
    }
  }

  def main(args: Array[String]): Unit = {
    val scanner: Scanner = new Scanner(System.in)
    val dictCount = scanner.nextInt
    val n = scanner.nextInt

    val set: IndexedSeq[String] = for (j <- 0 until dictCount) yield scanner.next()

    val dict = set.toSet

    val tuples: IndexedSeq[IndexedSeq[(Char, Char)]] = for (j <- 0 until n) yield scanner.next().zip(scanner.next())

    println(tuples.map(_.toList).map(distance(_, 0, dict)))
  }

}
