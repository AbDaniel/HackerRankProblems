package functionalprog

import java.util

import scala.collection.immutable.HashMap.HashMap1

/**
  * Created by abdaniel on 9/4/16.
  */
object CoinsMemoziation {

  def changes(amount: Int, coins: Set[Int]): Int = {
    def count(amount: Int, table: util.HashMap[Int, List[Int]]) = ???

    count(amount, new util.HashMap[Int, List[Int]]())
  }

  def main(args: Array[String]): Unit = {
    print(changes(4, Set(1, 2, 3)))
  }

}
