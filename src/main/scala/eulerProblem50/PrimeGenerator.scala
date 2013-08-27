package eulerProblem50

import scala.collection.immutable.IndexedSeq

trait PrimeGenerator {
  def primes(limit: Int): IndexedSeq[Int]
}