package tests

import genetics._
import music.{Playlist, Song, SongRating}
import org.scalatest._

class ApplicationObjective1 extends FunSuite {
  test(""){

    val test1: Map[String,Int] = Map("123"->4,"234"->1,"345"->5,"456"->2,"567"->3)

    val input1: List[Song] = List(new Song (" 122","222","123",
      List(new SongRating(2,3),
        new SongRating(4,3),
        new SongRating(5,3))),
      new Song (" 122","222","234",
        List(new SongRating(2,3),
          new SongRating(4,3),
          new SongRating(5,3))),
      new Song (" 122","222","345",
        List(new SongRating(2,3),
          new SongRating(4,3),
          new SongRating(5,3))))
    val listdouble : List[Double]= List(1.0,3.0,4.0)

    val incubator: Playlist = Playlist.makeIncubator(input1).apply(listdouble)

    val costfunction = Playlist.costFunction(test1).apply(incubator)
    println(costfunction)

    //println(GeneticAlgorithm.geneticAlgorithm(incubator, costfunction, 3))
  }

}
