package tests

import org.scalatest._
import statistics.Statistics._

class LectureTask3 extends FunSuite {
  test(""){

    def compare(a:Double, b:Double): Boolean={
      Math.abs(a - b)<0.0001
    }

    def f (a : Int): Double ={
      a.toDouble
    }

    def a(f : String): Double ={
      f.toDouble
    }

    val list:List[Int] = List(1,2,5,4,3,5,555)
    val outcome: Double = bayesianAverage(list, f, 4, 5)
    val ans: Double = 54.09090909090909
    assert(compare(outcome,ans))

    val list1: List[String] = List("5", "5", "5", "5", "5", "4", "3", "0")
    val ans1: Double = 4.0
    assert(compare(bayesianAverage(list1,a,3,4),ans1))
    val ans2: Double = 4.0
    assert(compare(bayesianAverage(list1,a,0,0),ans2))

    val list2: List[Int] = List(5)
    val ans3: Double = 4.142857142857143
    assert(compare(bayesianAverage(list2,f,6,4),ans3))

    val ans4 = Double.NaN

    assert(bayesianAverage(List(),f,0,0).isNaN==ans4.isNaN)
  }

}
