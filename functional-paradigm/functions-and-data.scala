// Playing with classes

object week2 {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x.sub(y).sub(z)
  y.add(y)

  class Rational(x: Int, y: Int) {
    def numer = x
    def denom = y

    def add(other: Rational) = {
      new Rational(
        numer * other.denom + denom * other.numer,
        denom * other.denom
      )
    }

    def sub(other: Rational) = {
      new Rational(
        numer * other.denom - denom * other.numer,
        denom * other.denom
      )
    }

    def mult(other: Rational) = {
      new Rational(
        numer * other.numer,
        denom * other.denom
      )
    }

    def div(other: Rational) = {
      new Rational(
        numer * other.denom,
        denom * other.numer
      )
    }

    def equals(other: Rational) = {
      numer * other.denom == denom * other.numer
    }

    override def toString() = {
      numer + " / " + denom
    }
  }
}