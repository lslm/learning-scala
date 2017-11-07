/*
  Currying
*/

// definition of a function the returns the cube of a
def cubes(a: Int): Int =
  a * a * a

// definition of the factorial function
def fact(a: Int) =
  if(a == 0) 1
  else a * fact(a - 1)

// the sum function... See 'high-order-functions.scala'
def sum(f: Int => Int, a: Int, b: Int): Int {
  def loop(a: Int, acc: Int) {
    if (a > b) acc
    else loop(a + 1, acc + f(a))
  }
  loop(a, 0)
}

def sumSquare = sum(x => x * x, 1, 5)
def sumCubes = sum(cubes, 3, 9)
def sumFacts = sum(fact, 3, 7)


// Currying the sum function
def sum(f: Int => Int)(Int, Int) => Int = {
  def sumF(a: Int, b: Int) = {
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  }
  sumF
}

/*
 The sum functionis now a function that returns another function.
 The returned function sumF applies the given function parameter
 and sums the results.
 We can then define
*/
def sumInt = sum(x => x)
def sumFact(fact)(5, 6)

sum(fact)(2, 5)

/*
  1 - In the last example, the sum(fact) applies the factorial function
  and returns the sum of factorials function.
  2 - sum(fact) is therefore equivalent to sumFact() function
  3 - the function is next applied to the arguments 2 and 5
*/

/*
  Multiple parameter lists
*/

def sum(f: Int => Int)(a: Int, b: Int): int =
  if(a > b) 0 else f(a) + sum(f)(a + 1, b)

def sumCubes(a: Int, b: Int) = sum(x => x * x * x)(a, b)

sumCubes(5,6) //341

/*
  More about functional types
*/

def sum(f: Int => Int)(a: Int, b: Int): Int = {...}

/*
  The type of the function above is a function that takes a function as a
  parameter and returns a function that takes two integers as arguments and
  finally returns a integer.

  This could be expressed this way:
  (Int => Int) => ((Int => Int) => Int)

  Note that functional types associates to the right. That is to say that:
  Int => Int => Int is equivalent to Int => (Int => Int)
*/
