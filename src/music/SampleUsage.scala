package music

object SampleUsage {

  def main(args: Array[String]): Unit = {
    // sample usage of the code in this project

    val songs = Song.readSongsFromFile("data/song_ratings_2017.csv")
    val k = 10

    // Plays the top 10 songs as rated by students in 2017
//    val numberOfExtraRatings: Int = 2
//    val valueOfExtraRatings: Int = 3
//    val bayesianRatingFunction: Song => Double = (song: Song) => song.bayesianRating(numberOfExtraRatings, valueOfExtraRatings)
//    new Playlist(Statistics.topK(songs, bayesianRatingFunction, k)).openPlaylist()

    // Plays the 10 most controversial songs as rated by students in 2017
//    val stddevFunction = (song: Song) => Statistics.standardDeviation(song.ratings, (v: SongRating) => v.rating)
//    new Playlist(Statistics.topK(songs, stddevFunction, k)).openPlaylist()
  }

}
