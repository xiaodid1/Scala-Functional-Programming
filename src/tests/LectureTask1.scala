package tests

import org.scalatest._
import statistics.Statistics._

class LectureTask1 extends FunSuite {


  test("your test") {
    val list:List[Int] = List(1,2,5,4,3,5,555)

    val expectans1: Double = 82.14285714285714

    val ans1: Double = average(list,f = {a:Int => a.toDouble})

    assert(Math.abs(expectans1-ans1)<0.0001)

    def f(a : String): Double ={
      a.length.toDouble
    }

    def a(f: Int): Double = {
      f.toDouble
    }

    val list1: List[Int] = List(555,555,555,5555,5, 6666)
    val anslist1: List[Int] = List(6666, 5555, 555, 555)
    val ans2list1: List[Int] = List(6666, 5555, 555, 555, 555, 5)
    assert(topK(list1,a,4)==anslist1)
    assert(topK(list1,a,10)==ans2list1)

    val list2: List[String] = List("afhajflajkfj", "adisjhdisjdis", "sdjis", "dhusdhiosdhji", "adisjhdisjdis", "disodisodiosdosidsoidsodisodi")
    val anslist2: List[String] = List("disodisodiosdosidsoidsodisodi", "adisjhdisjdis", "dhusdhiosdhji")
    val ans2list2: List[String] = List("disodisodiosdosidsoidsodisodi", "adisjhdisjdis", "dhusdhiosdhji", "adisjhdisjdis", "afhajflajkfj", "sdjis")
    assert(topK(list2,f,3)==anslist2)
    assert(topK(list2,f,7)==ans2list2)
  }


}
