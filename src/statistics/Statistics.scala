package statistics

object Statistics {

  def average[T](data: List[T], f: T => Double): Double = {
    val sum: Double = data.map(f).sum
    val length: Int = data.length
    val ans: Double = sum / length
    ans
    // brainstorming
  }

  def topK[T](data: List[T], f: T => Double, k:Int): List[T] = {
    val datasort: List[T] = data.sortWith((a:T,b:T) => f(a) > f(b))
    datasort.take(k)
  }

  def standardDeviation[T](input: List[T], f: T => Double): Double= {
    val avg: Double = average(input, f)
    val sum: Double = input.map(f).map((a:Double) => Math.pow(a - avg, 2)).sum
    Math.sqrt(sum / input.length)
  }

  def bayesianAverage[T](input: List[T], f: T => Double, a:Int , b:Int):Double= {
    val inputsum: Double = input.map(f).sum
    val newsum: Double = inputsum + (a.toDouble * b.toDouble)
    newsum / (input.length + a).toDouble

  }

}
