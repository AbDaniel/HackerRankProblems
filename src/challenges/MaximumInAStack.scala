package challenges

import java.util

/**
  * Created by abdaniel on 10/9/16.
  */
object MaximumInAStack {

  case class Node(value: Int, max: Int)

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    var cmd = 0

    val stack: util.Stack[Node] = new util.Stack[Node]

    var max = Int.MinValue
    var curr = 0
    for (i <- 0 until n) {
      cmd = sc.nextInt
      if (cmd == 1) {
        curr = sc.nextInt
        if (curr > max) max = curr
        stack.push(Node(curr, max))
      } else if (cmd == 2) {
        stack.pop()
        if (stack.empty()) max = Int.MinValue
        else max = stack.peek().max
      } else {
        println(stack.peek().max)
      }
    }
  }
}
