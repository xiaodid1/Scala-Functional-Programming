package music

import statistics.Statistics

import scala.io.{Source}


class Song(val title: String, val artist: String, val youtubeId: String, val ratings: List[SongRating]) {

  def averageRating(): Double = {
    // This is an example of calling your average function to get the average rating of a song
    Statistics.average(ratings, (rating: SongRating) => rating.rating)
  }

  def averageEnergyRating(): Double = {
    // This is an example of calling your average function to get the average energy rating of a song
    Statistics.average(ratings, (rating: SongRating) => rating.energy)
  }

  // comment this in when you complete LT3 to compute the bayesian average of song ratings
  def bayesianRating(extraRatings: Int, valueOfExtraRatings: Int): Double = {
    Statistics.bayesianAverage(this.ratings, (rating: SongRating) => rating.rating, extraRatings, valueOfExtraRatings)
  }

  def addRating(newrating:SongRating): Song = {
    val newsong: Song = new Song(title,artist,youtubeId,this.ratings.appended(newrating))
    newsong
  }

}


object Song {


  def readSongsFromFile(filename: String): List[Song] = {
    // Read all lines of the file into a List
    val file = Source.fromFile(filename)
    val lines: List[String] = file.getLines().toList
    file.close()
    def recursivereadsong(input: List[String]): Map[String, Song] = {
      if (input.isEmpty) {
        Map()
      } else {
        val songs: String = input.head
        val split: Array[String] = songs.split(",")
        val nextstep = recursivereadsong(input.drop(1))
        if (nextstep.contains(split.head)){
          nextstep + (split(0) -> nextstep(split.head).addRating(new SongRating(split(3).toInt, split(4).toInt)))
        } else {
          nextstep + (split(0) -> new Song(split(2), split(1), split.head, List( new SongRating(split(3).toInt, split(4).toInt))))
        }
      }
    }
    recursivereadsong(lines).values.toList
  }
  // TODO: Parse the lines and return a List of Songs containing all the information from the file

  def makeIncubator(songs: List[Song]): List[Double] => Song = {
    genes: List[Double] => {
      // assumes there is only 1 gene and converts that Double to an Int and retrieves the song at
      // that position in the list
      val geneSong: Int = (genes.head.abs * songs.length).toInt % songs.length
      songs(geneSong)
    }
  }

  def costFunction(input: Map[String, Int]): Song => Double = {
    songs: Song => {
      val rating: Int = input.getOrElse(songs.youtubeId, 3)
      if (rating <= 2){
        1000.0
      } else {
        1 / (songs.bayesianRating(2,3) * rating)
      }
    }
  }



}