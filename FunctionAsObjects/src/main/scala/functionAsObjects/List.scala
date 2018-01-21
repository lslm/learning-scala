package functionAsObjects

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val heah: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
}

object List {
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons[T](x2, new Nil))
  def apply[T]() = new Nil
}
