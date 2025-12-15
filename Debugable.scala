case class Debugable[A](logs: Seq[String], value: A):
  def map(f: A => A): Debugable[A] =
    println(s"map() - ${this}")
    Debugable(this.logs, f(this.value))

  def flatMap(f: A => Debugable[A]): Debugable[A] =
    val next = f(this.value)
    println(s"fmap() - ${this} - ${next}")
    Debugable(this.logs ++ next.logs, next.value)

  def flatten: A = this.value
