package eulerProblem50

trait ESieve extends PrimeGenerator {
  override def primes(limit: Int) = {
    val composites = new Array[Boolean](limit)

    (2 to math.sqrt(limit).toInt).foreach(i =>
      if (!composites(i))
        (i * i until limit by i).foreach(composites(_) = true))

    val primes = for {
      i <- 2 until limit
      if (!composites(i))
    } yield i

    primes
  }
}