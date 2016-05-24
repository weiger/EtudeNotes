//Solve Me First FP
object Solution {
  def main(args: Array[String]) {
    println(io.Source.stdin.getLine().take(2).map(_.toInt).sum)
  }
}
//Hello World N Times
def f(n:Int): Unit = {
  (0 to n - 1).foreach(_ => println("Hello World"))
}

//List Replication
def f(num:Int, arr:List[Int]):List[Int] = {
  arr.flatMap( e => (1 to num).map(_ => e).toList)
}

//Filter Array
def f(delim:Int, arr:List[Int]): List[Int] = {
  arr.filter( _ < delim)
}

//Filter Positions in a List
def f(arr:List[Int]): List[Int] = {
  arr.zipWithIndex.filter(x => (x._2 % 2) == 1).map(x => x._1)
}

//Array Of N Elements
def f(num:Int) : List[Int] = {
  List.fill(num)(scala.util.Random.nextInt(num))
}

//Reverse a List
def f(arr:List[Int]):List[Int] = arr.reverse

//Sum of Odd Elements
def f(arr:List[Int]):Int = arr.filter(x => (x & 1) == 1).sum

//List Length
def f(arr:List[Int]):Int = { (arr.zipWithIndex.last)._2 + 1 }

//Update List
def f(arr:List[Int]):List[Int] = { arr.map(x => x.abs) }

//Eval ex
object Solution {

  def f(x: Float) = {
    val N = 10
    def helper(n: Int, term: Double, sum: Double): Float = {
      if (n == N) sum.toFloat
      else helper(n + 1, term * x / (n + 1), sum + term)
    }
    helper(1, x, 1.0F)
  }

  def main(args: Array[String]) {
    var n = readInt
    (1 to n) foreach (x => println(f(readFloat())))
  }
}