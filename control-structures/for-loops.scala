//////// FOR LOOPS IN SCALA ////////
////////////////////////////////////
// for(item <- iterable_sequence) {
//   do something
// }
////////////////////////////////////

for(item <- List(1,2,3)) {
  println("Hello world") // prints 'hello world' 3 times
}

// using lists with generic values
for(item <- List(1,2,3,"Lucas",5)) {
  println(item) // prints each list elements per line
}

// using Arrays
for(num <- Array.range(0, 10)) {
  println(num: Int)
}

// using Sets (not ordered)
for(num <- Set(1,2,3,4,5)) {
  println(num)
}

// Getting things more funny
println("Take the even and odd numbers from a range of 0 to 10")
for(num <- Range(0,10)) {
  if(num % 2 == 0) {
    println(s"$num is even")
  } else {
    println(s"$num is odd")
  }
}

val names = List("Lucas", "Santos", "Ellen", "João", "Selene")
for (name <- names) {
  if(name.startsWith("S")) {
    println(s"$name starts with 'S'")
  } else {
    println(s"$name does not start with 'S'")
  }
}