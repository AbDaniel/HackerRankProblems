package algorithm

import java.util

import scala.collection.immutable.IndexedSeq

object BalancedBrackets {

  def balance(str: String): Boolean = {
    val openBrackets = Set('{', '(', '[')
    val closedBrackets = Set('}', ')', ']')
    val matches = Set(('{', '}'), ('(', ')'), ('[', ']'))

    def go(chars: List[Char], stack: List[Char]): Boolean = {
      if (chars.isEmpty && stack.isEmpty) return true
      else if (chars.isEmpty && stack.nonEmpty) return false
      if (openBrackets.contains(chars.head)) go(chars.tail, chars.head :: stack)
      else {
        if (stack.isEmpty) false
        else if (matches.contains((stack.head, chars.head))) go(chars.tail, stack.tail)
        else false
      }
    }

    go(str.toCharArray.toList, List())
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val t = sc.nextInt()
    val openBrackets = Set('{', '(', '[')
    val closedBrackets = Set('}', ')', ']')

    val stack: util.Stack[Char] = new util.Stack[Char]()
    val booleans: IndexedSeq[Boolean] = for (i <- 0 until t) yield balance(sc.next())
    booleans.foreach(x => if (x) println("YES") else println("NO"))

  }
}
