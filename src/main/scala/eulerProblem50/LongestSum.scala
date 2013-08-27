package eulerProblem50

import scala.collection.immutable.Range.Inclusive
import scala.collection.mutable.HashSet

abstract class LongestSum4 extends PrimeGenerator {

  /**
   * Return a 4-tuple (Terms Count, Start Prime, End Prime, Sum Prime)
   */
  def solution(limit: Int): (Int, Int, Int, Int) = {
    val givenPrimes = primes(limit)

    val primesSet = HashSet() ++ givenPrimes

    val cumsums = givenPrimes.foldLeft(Vector[Int](0))((vec, p) => vec :+ (vec.last + p))

    val maxRes = new Inclusive(0, cumsums.size - 1, 1).foldLeft((0, 0, 0)) { (triple, i) =>
      val (maxLen, _, _) = triple
      new Inclusive(i - maxLen - 1, 0, -1).
        takeWhile(j => (cumsums(i) - cumsums(j)) < limit).
        foldLeft(triple)((tri, j) =>
          if (primesSet contains (cumsums(i) - cumsums(j))) (i - j, i, j)
          else tri)
    }

    (maxRes._1, givenPrimes(maxRes._3), givenPrimes(maxRes._2), (cumsums(maxRes._2) - cumsums(maxRes._3)))
  }
}