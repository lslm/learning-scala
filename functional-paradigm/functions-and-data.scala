// Playing with Scala classes

object week2 {
  val x = new Rational(6, 1)
  val y = new Rational(3, 1)
  val z = new Rational(2, 1)

  x + y // 9 / 1
  x + (y neg) // 3 / 1
  x * y // 18 / 1
  x / z // 3 / 1

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

    val numer = x
    val denom = y

    def + (that: Rational) = {
      new Rational(
        numer * that.denom + denom * that.numer,
        denom * that.denom
      )
    }

    def - (other: Rational) = {
      this + (other neg)
    }

    def * (other: Rational) = {
      new Rational(
        numer * other.numer,
        denom * other.denom
      )
    }

    def / (that: Rational) = {
      new Rational(
        numer * that.denom,
        denom * that.numer
      )
    }

    def < (that: Rational) = {
      numer * that.denom < that.numer * denom
    }

    def max(that: Rational) = {
      if (this < (that)) that else this
    }

    def equals(that: Rational) = {
      numer * that.denom == denom * that.numer
    }

    def neg = {
      new Rational(-numer, denom)
    }

    override def toString() = {
      numer / gcd(numer, denom) + " / " + denom / gcd(numer, denom)
    }
  }
}