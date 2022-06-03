package tests

import org.scalatest._
import statistics.Statistics._


class LectureTask2 extends FunSuite {
  test(""){

    def compare(a:Double, b:Double): Boolean={
      Math.abs(a - b)<0.0001
    }

    def f (a : Int): Double ={
      a.toDouble
    }

    def a(f : String): Double ={
      f.length.toDouble
    }


    val list:List[Int] = List(10, 12, 23, 23, 16, 23, 21, 16)

    val ans:Double = 4.8989794855664

    assert(compare(standardDeviation(list,f),ans))

    val list1:List[String] = List("QEQWEQWEQWE",
      "FWFDSFSDFSDFSDFSDFfsfsdfsdf",
      "adadadasdasdasdasd",
      "dadsdasdasiopdjasipodjpasjdpiasjdpisaidopaspoidjaspd",
      "adasjidoasjdioasjdioasodiasdoasdjasiodioasd",
      "asdjkaiosdjaiosjdiaosdjiaosjdioasjd")

    val ans1: Double = 14.059397805975

    assert(compare(standardDeviation(list1,a),ans1))

    val list2: List[Int] = List(0)

    assert(compare(standardDeviation(list2,f),0.0))


    val list3 = List()
    val ans2 = Double.NaN
    assert(standardDeviation(list3,a).isNaN==ans2.isNaN)
  }

}
