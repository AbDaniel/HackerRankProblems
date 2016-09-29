package algorithm

/**
  * Created by abdaniel on 9/21/16.
  */
object commonchar {

  def commonchar(inputs: List[List[Char]]) = {
    inputs.reduce {
      (x, y) => x.intersect(y)
    }
  }

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    for (a_i <- 0 to n) {
      val line: String = sc.nextLine()
      if (!line.isEmpty) {
        val inputs: List[List[Char]] = line.split(" ").map(_.toCharArray.toList).toList
        println(collection.SortedSet(commonchar(inputs): _*).mkString(""))
      }
    }

  }

}
