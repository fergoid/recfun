package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  def fact(n: Int): Int = {
    def loop(acc: Int, n: Int): Int = {
      if (n == 0) acc else loop(acc * n, n-1)
    }
    loop(1, n)
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c > r) throw new IllegalArgumentException("No of columns cannot be greater than row number")

    if (c < 0 || r < 0) throw new IllegalArgumentException("Column and Row must be positive numbers")

    fact(r) / (fact(c) * fact(r - c))

  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = ???

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
