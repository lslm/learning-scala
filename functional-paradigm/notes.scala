/*
  This file contains some notes about the Scala syntax
*/

// "for-loop"
def printNameNTimes(name: String, times: Int) {
  def loop(n: Int): Unit = {
    if(n > times) return
    else {
      println(name)
      loop(n + 1)
    }
  }

  loop(1)
}

printNameNTimes("Hello world", 10) // prints 'hello world' 10 times

/*
 sum function
 This function takes a integer as argument and returns another
 function that takes an integer as parameter 
 and returns another integer, the sum of two numbers.
*/
def sum(n: Int): Int => Int = {
  def n2(x: Int): Int = {
    n + x
  }
  n2
}

sum(5) (3) // sums 5 and 3, returning 8
