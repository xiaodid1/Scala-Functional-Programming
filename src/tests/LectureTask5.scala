package tests

import org.scalatest._
import music._

class LectureTask5 extends FunSuite {
  test(""){

    def cnmpare(x:Double, y:Double): Boolean={
      Math.abs(x-y)<0.0001
    }
    val test1: Map[String,Int] = Map("123"->4,"234"->1,"345"->5,"456"->2,"567"->3)

    val song1: Song = new Song (" 122","222","123",
      List(new SongRating(2,3),
      new SongRating(4,3),
      new SongRating(5,3)))
    val ans1: Double = Song.costFunction(test1).apply(song1)
    assert(cnmpare(ans1,0.073529411))

    val song2: Song = new Song (" 122","222","234",
      List(new SongRating(2,3),
        new SongRating(4,3),
        new SongRating(5,3)))
    val ans2: Double = Song.costFunction(test1).apply(song2)
    assert(cnmpare(ans2,1000.0))

    val song3: Song = new Song (" 122","222","345",
      List(new SongRating(2,3),
        new SongRating(4,3),
        new SongRating(5,3)))
    val ans3: Double = Song.costFunction(test1).apply(song3)
    assert(cnmpare(ans3,0.058823529411764705))

    val song4: Song = new Song (" 122","222","456",
      List(new SongRating(2,3),
        new SongRating(4,3),
        new SongRating(5,3)))
    val ans4: Double = Song.costFunction(test1).apply(song4)
    assert(cnmpare(ans4,1000.0))

    val song5: Song = new Song (" 122","222","999",
      List(new SongRating(2,3),
        new SongRating(4,3),
        new SongRating(5,3)))
    val ans5: Double = Song.costFunction(test1).apply(song5)
    assert(cnmpare(ans5,0.09803921568627452))

    val song6: Song = new Song (" 122","222","567",
      List(new SongRating(2,3),
        new SongRating(4,3),
        new SongRating(5,3)))
    val ans6: Double = Song.costFunction(test1).apply(song6)
    assert(cnmpare(ans6,0.09803921568627452))

  }

}
