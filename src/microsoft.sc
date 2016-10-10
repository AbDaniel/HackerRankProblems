val tuples = "abc".zip("bbb").toList

def quicksort(list: List[Int]): List[Int]= {
  if (list.isEmpty) return Nil
  val partition = list.head
  val left = list.filter(_ < partition)
  val right = list.filter(_ > partition)

  quicksort(left) ::: List(partition) ::: quicksort(right)
}

def mergesort(list: List[Int]): List[Int] = {
  def swap(list: List[Int]): List[Int] = list match {
    case Nil => list
    case (x :: Nil) => list
    case (x :: y :: Nil) => list.reverse
  }

  def merge(first: List[Int], second: List[Int]): List[Int] = (first, second) match {
    case (x :: xs, y :: ys) if x <= y => x :: merge(xs, y :: ys)
    case (x :: xs, y :: ys) if x > y => y :: merge(x :: xs, ys)
    case (xs, Nil) => xs
    case (Nil, ys) => ys
  }

  def go(list: List[Int]): List[Int] = {
    val partition =
  }
}


quicksort(List(3, 6, 1, 4, 8, 5))