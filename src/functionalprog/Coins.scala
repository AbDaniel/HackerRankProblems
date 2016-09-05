package functionalprog

/**
  * Created by abdaniel on 9/4/16.
  */
object Coins {

  def changes(amount: Int, coins: Set[Int]): Int = {
    if (amount == 0) return 1
    if (amount < 0 || coins.isEmpty) return 0

    changes(amount - coins.head, coins) + changes(amount, coins.tail)
  }

  def main(args: Array[String]): Unit = {
    print(changes(4, Set(1, 2, 3)))
  }

}
