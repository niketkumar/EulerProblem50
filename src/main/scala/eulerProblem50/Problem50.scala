package eulerProblem50

object Problem50 {
  def solution(limit: Int) = {
    (new LongestSum with ESieve).solution(limit)
  }
}