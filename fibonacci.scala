

// crazy simple
def fibFrom(a: Int, b: Int): Stream[Int] =
  a #:: fibFrom(b, a + b)



// If the function used :: instead of #::, then
// every call to the function would result in another call, thus causing an infinite
// recursion. Since it uses #::, though, the right-hand side is not evaluated until
// it is requested.
//
// And the reason is: Streams are lazily evaluated



val res = fibFrom(1, 1).take(7)

println(res.toList) // = List(1, 1, 2, 3, 5, 8, 13)
