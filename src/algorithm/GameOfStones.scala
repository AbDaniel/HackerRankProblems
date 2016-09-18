package algorithm

import java.util.Scanner

import scala.collection.immutable.IndexedSeq

import Math._

/**
  * Created by abdaniel on 9/17/16.
  */
object GameOfStones {

  def powerOfTwo(x: Int): Int = {
    (log(x) / log(2)).toInt + 1
  }

  def main(args: Array[String]): Unit = {
    val scanner: Scanner = new Scanner(System.in)
    val setCount = scanner.nextInt
    val days = scanner.nextInt
    val setOfStones = for (i <- 0 until setCount) yield scanner.nextInt
    val leftRight = for (i <- 0 until days) yield (scanner.nextInt, scanner.nextInt)

    val sumOfPowers = setOfStones.map(powerOfTwo)

    leftRight.map {
      case (l, r) => sumOfPowers.slice(l - 1, r)
    }.map(_.sum).foreach { sum =>
      if (sum % 2 == 0) println("Hacker") else println("Mishki")
    }
  }

}
