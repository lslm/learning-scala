// Playing with classes

object week2 {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x.sub(y).sub(z)
  y.add(y)
  x.less(y)
  z.max(y)

  class Rational(x: Int, y: Int) {
    // gretest common divisor
    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a
      else gcd(b, a % b)
    }
    
    def numer = x / gcd(x, y)
    def denom = y / gcd(x, y)

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

    def less(than: Rational) = {
      numer * than.denom < than.numer * denom
    }

    def max(that: Rational) = {
      if (this.less(that)) that else this
    }

    def equals(other: Rational) = {
      numer * other.denom == denom * other.numer
    }

    override def toString() = {
      numer + " / " + denom
    }
  }
}