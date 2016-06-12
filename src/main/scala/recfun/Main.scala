package recfun

import scala.annotation.tailrec

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
      if (n == 0) acc else loop(acc * n, n - 1)
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

  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def evaluate(chars: List[Char], opened: Int): Boolean = {
      if (chars.isEmpty) opened == 0 // terminate after processing List
      else if (chars.head.equals('(')) evaluate(chars.tail, opened + 1) // check for '('
      else if (chars.head.equals(')')) opened > 0 && evaluate(chars.tail, opened - 1) // check for ')' and ensure balancing
      else evaluate(chars.tail, opened) // move on
    }
    evaluate(chars.filter(c => c.equals(')') || c.equals('(')), 0) // remove non parentheses before evaluation (not strictly necessary)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {

    def evaluate(m: Int, c: List[Int]): Int = {
      if (m == 0) 1
      else if (c.isEmpty || m < 0) 0
      else
        evaluate(m, c.tail) + evaluate(m - c.max, c)

    }
    evaluate(money, coins.sortWith(_>_))  // coins sorted in descendding order
  }

}
