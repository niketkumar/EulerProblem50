package eulerProblem50

object Problem50 {
  def solution(limit: Int) = {
    (new LongestSum4 with ESieve).solution(limit)
  }
}