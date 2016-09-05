package functionalprog

/**
  * Created by abdaniel on 9/4/16.
  */
object MthElement {

  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val m = scala.io.StdIn.readLine().toInt
    val numbers = scala.io.StdIn.readLine().split(" ")
    if(m > numbers.size) print("NIL")
    else print(numbers.drop(numbers.size - m).head)
  }

}
