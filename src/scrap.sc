import scala.collection.mutable

def nested(n: Int): List[(Int, Int)] = {
  def go(i: Int, j: Int, acc: List[(Int, Int)]): List[(Int, Int)] = {
    if (i >= n) acc
    else if (j >= n - 1) go(i + 1, 0, (i, j) :: acc)
    else go(i, j + 1, (i, j) :: acc)
  }

  go(0, 0, List())
}


nested(5).reverse

val str = "9x34209asAb32sD840D9258 02934x2DoebAaab90CDEe348290"

val list = str.split(" ").map(_.toCharArray.toList).toList
val h1 = list.head
val h2 = list.tail.head
collection.SortedSet(h1 intersect (h2): _*)
//
//collection.SortedSet(List('a'): _*)

def factorial: Int => Int = {
  (n: Int) => n * factorial(n - 1)
}

def f(num: Int, arr: List[Int]): List[Int] = {
  arr.flatMap(List.fill(3)(_))
}

List(1, 2, 3, 4).zipWithIndex.filter {
  case (x, index) => index % 2 != 0
}.map(_._1)

def pascalTriangle: Stream[List[Int]] = {
  List(1) #:: pascalTriangle.map {
    x => {
      val left = 0 :: x
      val right = x ::: List(0)
      left.zip(right).map {
        case (a, b) => a + b
      }
    }
  }
}

pascalTriangle.take(5).toList(2)

"(())"