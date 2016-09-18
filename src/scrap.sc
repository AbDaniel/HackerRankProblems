List(1, 2, 3, 4).zipWithIndex.sliding(2) toList

List(1, 2, 3, 4).foldRight(0)((x, y) => {
  if (x > y) x
  else y
})

def fib(a: Int, b: Int): Stream[Int] = {
  a #:: fib(b, b + a)
}


val fibo: Stream[Int] = 0 #:: 1 #:: fibo.zip(fibo.tail).map(x => x._1 + x._2)

"123"

fibo take 10 toList

//Method 1
def factorial1(n: Int, index: Int): Stream[Int] = {
  n #:: factorial1(index * n, index + 1)
}

//Method 2
val factorial2: Stream[Int] = 1 #:: factorial2.zipWithIndex.map(x => x._1 * (x._2 + 1))

//Method 3
val factorial3: Stream[Int] = 1 #:: Stream.from(1).zip(factorial3).map(x => x._1 * x._2)

//Method 3! This is buggy! It produces 1, 2, 6, 24.... instead of 1, 1, 2, 6
val factorial4: Stream[Int] = 1 #:: Stream.from(2).map((x: Int) => x * factorial4(x - 2))

factorial1(1, 1) take 10 toList

factorial2 take 10 toList

factorial3 take 10 toList

factorial4 take 10 toList

def fib(n: Int): Int = {
  def go(prev: Int, curr: Int, count: Int): Int = {
    if(count >= n) prev
    else go(curr, prev + curr, count + 1)
  }

  go(0, 1, 0)
}

(0 to 10).map(fib).toList

Math.log(10)