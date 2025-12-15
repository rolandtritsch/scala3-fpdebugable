# scala3-fpdebugable - Implementing Alvinj's Debugable

This is a playground to play around with monads.

We are implementing the Debugable class from Alvinj's Functional Programing book.

To make this work you need to run ...

```bash
scala-cli run . --watch
```

... and then make changes to the code to you hearts content.

To see the de-sugared for-comprehesion you can run ...

```bash
scala-cli clean && scala-cli compile . -O -Xprint:typer
```

**Challenge**: Make this code work ...

```scala
f(100).flatten
```
