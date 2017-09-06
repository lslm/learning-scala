// Example from the book 'Manning Functional Programming with Scala'
// The following example shows how to use functional programming to remove side effects

// Ex.: Class with side effect
class Cafe {
  def buyCoffe(cc: CreditCard, p: Payments): Coffe = {
    val cup = new Coffe()
    p.charge(cc, cup.price) // side effect
    cup
  }
}

// Ex.: Class without side effect
class Cafe {
  def buyCoffe(cc: CreditCard): (Coffe, Charge) = {
    val cup = new Coffe()
    (cup, Charge(cc, cup.price)) // returns a pair of Coffe and Charge objects, eliminating side effects
  }

  def buyCoffes(cc: CreditCard, n: Int): (List[Coffe], Charge) = {
    val purchases: List[(Coffe, Charge)] = List.fill(n) (buyCoffe(cc)) //List.fill(n) (x) creates a List with n copies of x.
    val (coffes, charges) = purchases.unzip // unzip splits a list of pairs into a pair of lists, Here we are destructuring this pair to declare two values on one line
    (coffes, charges.reduce((c1, c2) => c1.combine(c2))) // charges.reduce reduces the entire list of charges to a single charge, using combine to combine charges two at a time.
  }
}