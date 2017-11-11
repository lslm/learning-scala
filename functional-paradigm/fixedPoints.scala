/*
  Fixed points
*/

// A number x is called a fixed point of a function f if f(x) = x

// The fixed point of the following function is 2, because 2 = 1 + 1/2
x => 1 + x/2

/*
  For some functions we can find the fixed point by starting with
  an initial estimate and the by applying the f in a repetivie way

  x, f(x), f(f(x)), f(f(f(x))),...

  until the value does not vary anymore or the change is
  sufficiently small
*/

// A function to find the fixed point of a given function
import Math.abs
val tolerance = 0.0001

def isCloseEnough(x: Double, y: Double) = {
  abs((x - y) / x) / x < tolerance
}

def fixedPoint(f: Double => Double) (firstGuess: Double) = {
  def loop(guess: Double): Double = {
    val next = f(guess)
    if (isCloseEnough(guess, next)) next
    else loop(next)
  }

  loop(firstGuess)
}

fixedPoint(x => 1 + x/2)(2) // 2

/*
  Let's return to the square roots

  Here is a specification of the sqrt function
  sqrt(x) = the number y such that y * y = x
  
  Or by dividing both sides of the equation with y
  sqrt(x) = the number y such that y = x / y

  Consequently, sqrt(x) is the fixed point of the function
  (y => x / y)
*/

def sqrt(x: Double) = fixedPoint(y => x / y)(1.0) // does not work...

/*
  The function above does not work because it enters into a infinity loop
  One way to eliminate the ocilation is to prevent the estimation
  from varying too much. This can be done by averaging successive values
  of the original sequence
*/

def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1.0)

/*
  Function as return values
  
  We began by observing that sqrt(x) is a fixed point of the function
  y => x / y. Then the iteration converges by averaging successive values

  This technique of stabilizing by averaging is general enough to merit
  being abstracted into its own function 
*/

def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

def sqrt(x: Double) =
  fixedPoint(averageDamp(y => x / y)(1.0))
