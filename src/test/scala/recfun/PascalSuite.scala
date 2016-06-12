package recfun

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {

  import Main.pascal

  test("pascal: col=0,row=2") {
    assert(pascal(0, 2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1, 2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1, 3) === 3)
  }

  test("pascal: col=0,row=0") {
    assert(pascal(0, 0) === 1)
  }

  test("pascal: col=3,row=3") {
    assert(pascal(3, 3) === 1)
  }

  test("pascal: col=4, row=3") {
    try {
      pascal(4, 3)
      fail()
    }
    catch {
      case _: IllegalArgumentException =>
    }
  }

  test("pascal: col=-1, row=3") {
    try {
      pascal(-1, 3)
      fail()
    }
    catch {
      case _: IllegalArgumentException =>
    }
  }

  test("pascal: col=1, row=-3") {
    try {
      pascal(1, -3)
      fail()
    }
    catch {
      case _: IllegalArgumentException =>
    }
  }

  test("pascal: col=1, row=-0") {
    try {
      pascal(1, 0)
      fail()
    }
    catch {
      case _: IllegalArgumentException =>
    }
  }

  test("pascal: test large numbers") {
    println("Pascal's Triangle")
    for (row <- 0 to 100) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    assert(true)
  }
}
