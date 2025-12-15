import scala.math.Numeric.Implicits.infixNumericOps

def base[A: Numeric](b: A)(a: A): Debugable[A] =
  val result = a * b
  val log = s"base(${b})(${a}): ${result}"
  println(log)
  Debugable(Seq(log), result)

def f = base(2)
def g = base(3)
def h = base(4)

@main def main() = {
  val fmResult = f(100).flatMap(g).flatMap(h)
  println(s"fmResult: ${fmResult}")

  val fmaResult = f(100)
    .flatMap((fResult: Int) => g(fResult)
      .flatMap((gResult: Int) => h(gResult)
        .map((hResult: Int) => {
          hResult
        })
      )
    )
  println(s"fmaResult: ${fmaResult}")

  val forResult = for {
    fResult <- f(100)
    gResult <- g(fResult)
    hResult <- h(gResult)
  } yield {
    hResult
  }
  println(s"forResult: ${forResult}")

  System.exit(0)
}
