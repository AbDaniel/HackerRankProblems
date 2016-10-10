package algorithm

/**
  * Created by abdaniel on 9/29/16.
  */
object LongestCommonSubSequence {

  def lcs(x: Array[Char], y: Array[Char], commonSubSeq: List[Char]): String = {
    if (x.isEmpty || y.isEmpty) commonSubSeq.mkString("")
    else if (x.lastOption.get == y.lastOption.get) {
      lcs(x.slice(0, x.length - 1), y.slice(0, y.length - 1), x.lastOption.get :: commonSubSeq)
    } else {
      val shorterX = lcs(x.slice(0, x.length - 1), y, commonSubSeq)
      val shorterY = lcs(x, y.slice(0, y.length - 1), commonSubSeq)
      if (shorterX.length > shorterY.length) shorterX
      else shorterY
    }

  }

  def main(args: Array[String]): Unit = {
    val a = "BANANA"
    val b = "ATANA"

    print(lcs(a.toCharArray, b.toCharArray, commonSubSeq = List[Char]()))
  }

}
