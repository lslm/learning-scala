// Some questions

// 1: Check for Single Even
// Write a function that takes in an integer and returns a Boolean indication whether or not it is even.
// See if you can write this in one line

def isEven(num: Int): Boolean = {
  if(num%2 == 0) {
    return true
  }
  return false
}
isEven(2)
isEven(3)

// Check for evend in a list
//Write a function that returns true id there is an even number inside of a list,
// otherwise, return false

def containsEvenNumber(list: List[Int]): Boolean = {
  for(n <- list) {
    if(n%2 == 0) {
      return true
    }
  }
  return false
}

val list1 = List(1,2,3,4,5,6,7,8)
val list2 = List(1,3,5,7,9)
containsEvenNumber(list1)
containsEvenNumber(list2)

// Lucky number Seven
// Take in a list of integer and calculate their sum. However, sevens are lucky
// and they should be counted twice, meaning their value is 14 for the sum. Assume
// the list isn't empty
def luckyNumberSeven(numbers: List[Int]): Int = {
  var sum = 0
  for(n <- numbers) {
    var a = n
    if (a == 7) {
      a = a * 2
    }
    sum = sum + a
  }
  return sum
}

val list1 = List(1,2,3,4,5,6,7,8)
luckyNumberSeven(list1)

// Can you Balance
// Given a non-empty list of integer, return true id there is a place to split the list so that
// the sum of the numbers on one side is equal to the sum of the number on the other side.
// For example, given the list (1,2,3,4) would return true, you can split it in the middle.
// Another example is that (7,3,4) would return true 3+4=7.

println("Can you balance?")

def canYouBalance(list: List[Int]): Boolean = {
  val lists = list.grouped(Math.round(list.length/2.toFloat)).toList
  val list1 = lists(0)
  val list2 = lists(1)

  if (list1.sum == list2.sum)
    return true
  return false
}

canYouBalance(List(1,5,3,3))
canYouBalance(List(7,3,4))

// Check if a given word is Palimdrome
def isPalindrome(word: String): Boolean = {
  val reversedWord = word.reverse
  if (word.equalsIgnoreCase(reversedWord)) {
    return true
  }
  return false
}

var name = "Lucas"
var test = "Tenet"

isPalindrome(name)
isPalindrome(test)
