package algorithm

/**
  * Created by abdaniel on 9/5/16.
  */
object Kangaroo {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    val x1 = sc.nextInt()
    val v1 = sc.nextInt()
    val x2 = sc.nextInt()
    val v2 = sc.nextInt()

    val canCatchUp: Boolean = !(x1 > x2 && v1 >= v2) && !(x2 > x1 && v2 >= v1)
    if(canCatchUp && (x1 - x2) % (v2 - v1) == 0) print("YES")
    else print("NO")

  }

}
