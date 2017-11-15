// Playing with classes

object week2 {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  val t = new Rational(5) // 5 / 1

  x.sub(y).sub(z)
  y.add(y)
  x < (y)
  z max (y)

  class Rational(x: Int, y: Int) {
    // this is a predifined function that takes
    // a condition and a optional message
    require(y != 0, "Denominator must be nonzero")

    // secondary constructor
    // it created a new rational with 1
    // as default denominator
    def this(x: Int) = this(x, 1)

    // gretest common divisor
    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a
      else gcd(b, a % b)
    }
    
    val numer = x / gcd(x, y)
    val denom = y / gcd(x, y)

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

    def < (than: Rational) = {
      numer * than.denom < than.numer * denom
    }

    def max(that: Rational) = {
      if (this < (that)) that else this
    }

    def equals(other: Rational) = {
      numer * other.denom == denom * other.numer
    }

    override def toString() = {
      numer + " / " + denom
    }
  }
}