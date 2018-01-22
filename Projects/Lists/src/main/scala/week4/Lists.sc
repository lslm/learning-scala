def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys => {
    if (x <= y) x :: xs
    else y :: insert(x, ys)
  }
}

def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case x :: xs => insert(x, isort(xs))
}

def ul = List(10,9,8,7,6,5)
def ol = isort(ul)

print(ol)
