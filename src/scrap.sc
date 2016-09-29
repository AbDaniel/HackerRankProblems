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
collection.SortedSet(h1 intersect(h2): _*)
//
//collection.SortedSet(List('a'): _*)