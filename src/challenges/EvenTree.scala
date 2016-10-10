package challenges

import java.util.Scanner

import scala.collection.immutable.IndexedSeq

case class Node[A](name: A, var children: Set[Node[A]])

class Tree[A](val root: Node[A]) {

  def find(name: A): Option[Node[A]] = {
    def go(node: Node[A], stack: List[Node[A]]): Option[Node[A]] = node match {
      case Node(`name`, _) => Some(node)
      case Node(_, children) if children.nonEmpty => go(children.head, children.tail.toList ::: stack)
      case Node(_, _) =>
        if (stack.isEmpty) None
        else go(stack.head, stack.tail)
    }

    go(root, List[Node[A]]())
  }

  def insert(name: A, parent: A): Option[Node[A]] = {
    val parentNode = find(parent)
    parentNode match {
      case None => None
      case Some(node) => {
        val insertedNode = Node[A](name, Set[Node[A]]())
        node.children = node.children + insertedNode
        Some(insertedNode)
      }
    }
  }
}


object EvenTree {

  def forestOfEvenTrees(root: Node[String]): Int = {
    def add(): Int => Int = {
      var count = 0
      def inc(x: Int): Int = {
        count = count + x
        count
      }
      inc
    }
  
    def subTreeSize(node: Node[String], counter: (Int) => Int): Int = {
      if (node.children.isEmpty) 1
      else {
        val size = node.children.toList.map(subTreeSize(_, counter)).sum + 1
        if (size % 2 == 0) {
          counter(1)
          0
        }
        else size
      }
    }

    val counter = add()
    subTreeSize(root, counter)
    counter(-1)
  }


  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val m = sc.nextInt()
    val n = sc.nextInt()
    val edges: IndexedSeq[(String, String)] = for (i <- 0 until n) yield (sc.next(), sc.next())
    val tree: Tree[String] = new Tree(Node("1", Set[Node[String]]()))
    val maps = edges.map {
      case (x, y) => tree.insert(x, y)
    }

    print(forestOfEvenTrees(tree.root))
  }

}
