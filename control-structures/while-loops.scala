//////// WHILE LOOPS IN SCALA ////////
////////////////////////////////////
// while(condition) {
//   do something
// }
////////////////////////////////////
import util.control.Breaks._ // for break utility
var x = 0
while(x <= 10) {
  println(s"$x is currently less or equal to 10")
  x = x + 1
}

var y = 0
while(y <= 10) {
  println(s"$y is currently less or equal to 10")
  y = y + 1
  if(y == 5) {
    println("Breaking...")
    break
  }
}
