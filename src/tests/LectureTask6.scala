package tests

import org.scalatest._
import music._
import statistics._

class LectureTask6 extends FunSuite {
  test(""){

    def compare(x:Double, y:Double): Boolean={
      Math.abs(x-y)<0.0001
    }

    val test1: Map[String,Int] = Map("123"->4,"234"->1,"345"->5,"456"->2,"567"->3)

    val input: List[Song] = List(new Song (" 122","222","123",
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
          new SongRating(5,3))),
      new Song (" 122","222","345",
        List(new SongRating(2,3),
          new SongRating(4,3),
          new SongRating(5,3))))

    val song1: Playlist = new Playlist(input)
    assert(compare(Playlist.costFunction(test1).apply(song1),1000191.1764705882))

    val input2: List[Song] = List(new Song (" 122","222","123",
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

    val song2: Playlist = new Playlist(input2)
    assert(compare(Playlist.costFunction(test1).apply(song2),10001.323529411764))

    val input3: List[Song] = List(new Song (" 122","222","123",
      List(new SongRating(2,2),
        new SongRating(4,2),
        new SongRating(5,2))),
      new Song (" 122","222","234",
        List(new SongRating(2,23),
          new SongRating(4,23),
          new SongRating(5,23))),
      new Song (" 122","222","345",
        List(new SongRating(2,23000),
          new SongRating(4,230000),
          new SongRating(5,23000))))
    val song3: Playlist = new Playlist(input3)
    assert(compare(Playlist.costFunction(test1).apply(song3),0.023064014839862337))
  }

}
