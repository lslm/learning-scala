/*
  High Order Functions: it is basically a function that can take another
  function as a parameter
*/

// Ex 1: I want the sum of all integers between a and b.
def sumInt(a: Int, b: Int): Int =
  if(a > b) 0 else a + sumInt(a + 1, b)

// Ex 2: I want the sum of all cubes between a and b
def sumCubes(a: Int, b: Int): Int =
  if(a > b) 0 else (a * a * a) + cubes(a + 1, b)

// Ex 3: The sum of all factorials of the numbers between a and b
def fact(a: Int) =
  if(a == 0) 1
  else a * fact(a - 1)

def sumFact(a: Int, b: Int): Int =
  if(a > b) 0 else fact(a) + sumFact(a + 1, b)

// I could write a function that takes the 'sum' function
def sum(f: Int => Int, a: Int, b: Int) =
  if(a > b) 0 else f(a) + sum(f, a + 1, b)

// I then could call the function this way
sum(sumInt, 3, 10)  // the sum of all integer between 3 and 10
sum(sumCubes, 2, 9) // the sum of all cubes between 2 and 9
sum(sumFact, 1, 5)  // the sum of all factorials between 1 and 5

/*
  Function Types
  f: A => B is the type of a function that takes a parameter of type A and
  returns the result of type B
  So, Int => Int is a function that maps Integers to Integers
*/

/*
  Anonymous Functions
*/
(x: Int) => x * x * x // cubes
x => x * x // squares

/*
  The Tail-recursive version of the sum function
*/
def sum(f: Int => Int, a: Int, b: Int): Int {
  def loop(a: Int, acc: Int) {
    if (a > b) acc
    else loop(a + 1, acc + f(a))
  }
  loop(a, 0)
}
// the tail-recursive version could be called this way
sum(x => x*x*x, 2, 7) // the sum of all cubes of the numbers between 2 and 7
sum(fact, 4, 8) // the sum of all factorials of the numbers between 4 and 8
