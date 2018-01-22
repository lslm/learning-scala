package week4

object Sum {
  def apply(e1: Expr, e2: Expr) = new Sum(e1, e2)
}

case class Sum(e1: Expr, e2: Expr) extends Expr {
  def isNumber: Boolean = false
  def isSum: Boolean = true
  def numValue: Int = throw new Error("Sum.numValue")
  def leftOp: Expr = e1
  def rightOp: Expr = e2
}
