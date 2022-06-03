package tests

import org.scalatest._
import music._

import scala.io.{BufferedSource, Source}

class LectureTask4 extends FunSuite {
  test("") {
    val rate: SongRating = new SongRating(4, 5)
    val song: Song = new Song("dadasd", "dadad", "dadadasdsa", List(new SongRating(4, 5)))
    val anssong: Song = new Song("dadasd", "dadad", "dadadasdsa", List(new SongRating(4, 5), new SongRating(4, 5)))
    val outcome: Song = song.addRating(rate)
    assert(outcome.title == anssong.title)
    assert(outcome.artist == anssong.artist)
    assert(outcome.youtubeId == anssong.youtubeId)
    for (i <- anssong.ratings.indices) {
      assert(anssong.ratings(i).rating == outcome.ratings(i).rating)
      assert(anssong.ratings(i).energy == outcome.ratings(i).energy)
    }
    val ans : List[Song] = Song.readSongsFromFile("data/test.csv")
    for (i <- ans){
      for (f <- i.ratings){
        println(f.energy)
      }
    }

  }
}