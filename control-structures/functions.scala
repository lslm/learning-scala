///////// FUNCTIONS IN SCALA /////////
////////////////////////////////////
// def functionName(): ReturnType = {
//   performs an operation
// }
////////////////////////////////////

def printSomething(): Unit = {
  println("Printing something...")
}

def greeting(name: String): Unit = {
  println(s"Hello, $name")
}

def getSumOfTwoNumbers(x: Int, y: Int): Int = {
  return x + y // 'return' keyword is optional
}

def isPrime(number: Int): Boolean = {
  for (n <- Range(2, number)) {
    if(number%n == 0) {
      return false
    }
  }
  return true
}

printSomething // calling the printSomething function
greeting("Lucas") // prints 'Hello, Lucas'
println(getSumOfTwoNumbers(2,4)) // returns and print 6

println("is 35 prime? " + isPrime(35))
println("is 11 prime? " + isPrime(11))

val nums = Range(1,100)
for(n <- nums) {
  println(s"Is $n prime?: "+ isPrime(n))
}
