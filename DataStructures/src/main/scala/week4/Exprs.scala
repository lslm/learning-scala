package week4

object Exprs {
  def show(e: Expr): String = e match {
    case Number(e: Int) => e.toString
    case Sum(left: Expr, right: Expr) => show(left) + " + " + show(right)
  }
}
