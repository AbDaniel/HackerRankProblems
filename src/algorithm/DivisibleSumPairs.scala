package algorithm

/**
  * Created by abdaniel on 9/5/16.
  */
object DivisibleSumPairs {

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in);
    var n = sc.nextInt();
    var k = sc.nextInt();
    var a = new Array[Int](n);
    for (a_i <- 0 until n) {
      a(a_i) = sc.nextInt();
    }

    val count = (0 until n).combinations(2).count { pair =>
      if (pair(0) < pair(1) && ((a(pair(0)) + a(pair(1))) % k == 0)) true
      else false
    }

    print(count)

  }

}
