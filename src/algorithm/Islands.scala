package algorithm

/**
  * Created by abdaniel on 9/10/16.
  */

object Islands {

  def inputTable: Array[Array[(Int, Boolean)]] = {
    val sc = new java.util.Scanner(System.in)
    val rowLen = sc.nextInt()
    val colLen = sc.nextInt()
    val table = Array.fill(rowLen, colLen)((0, false))
    for (i <- 0 until rowLen) {
      for (j <- 0 until colLen) {
        table(i)(j) = (sc.nextInt(), false)
      }
    }
    table
  }

  def valid(row: Int, col: Int, table: Array[Array[(Int, Boolean)]]): Boolean = {
    (row >= 0 && col >= 0) && (row < table.length && col < table(0).length) &&
      (table(row)(col)._1 == 1 && !table(row)(col)._2)
  }

  def DFS(table: Array[Array[(Int, Boolean)]], row: Int, col: Int): Unit = {
    val neighbours = List((-1, -1), (-1, 0), (-1, 1), (0, -1),
      (0, 1), (1, -1), (1, 0), (1, 1))

    table(row)(col) = (table(row)(col)._1, true)

    neighbours.foreach {
      case (x, y) => if (valid(row + x, col + y, table)) DFS(table, row + x, col + y)
    }
  }

  def main(args: Array[String]): Unit = {
    val table = inputTable

    var count = 0
    for (i <- table.indices) {
      for (j <- table(0).indices) {
        if (table(i)(j)._1 == 1 && !table(i)(j)._2) {
          count += 1
          DFS(table, i, j)
        }
      }
    }
    print(count)

  }
}
