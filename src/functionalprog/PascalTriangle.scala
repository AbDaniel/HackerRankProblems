package functionalprog

/**
  * Created by abdaniel on 10/5/16.
  */
object PascalTriangle {

  def pascalTriangle: Stream[List[Int]] = {
    List(1) #:: pascalTriangle.map {
      x =>
        val left = 0 :: x
        val right = x ::: List(0)
        left.zip(right).map {
          case (a, b) => a + b
        }
    }
  }


  def main(args: Array[String]): Unit = {
    val n: Int = io.StdIn.readLine().toInt
    pascalTriangle.take(n).foreach(x => println(x.mkString(" ")))
  }

}
