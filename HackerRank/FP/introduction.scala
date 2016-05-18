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