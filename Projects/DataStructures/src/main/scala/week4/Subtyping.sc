class IntSet() {

}

class NonEmpty(x: Int, a: IntSet, b: IntSet) extends IntSet {

}

class Empty() extends IntSet {

}

val a: Array[NonEmpty] = Array(new NonEmpty(1, new  Empty, new Empty))
val b: Array[IntSet] = a
b(0) = new Empty
val s: NonEmpty = a(0)

def assertAllPos[S <: Set[Int]](r: S): S = {

}