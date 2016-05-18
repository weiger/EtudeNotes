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