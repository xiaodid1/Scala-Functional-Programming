package music

import java.awt.Desktop
import java.net.URI
import statistics._

class Playlist(val songs: List[Song]) {

  // Call this method on a playlist to listen to the songs
  def openPlaylist(): Unit = {
    val commaSeparatedIds: String = if (this.songs.nonEmpty) this.songs.map(_.youtubeId).reduce((acc: String, id: String) => acc + "," + id) else List[Byte](100, 81, 119, 52, 119, 57, 87, 103, 88, 99, 81).foldLeft("")(_ + _.toChar)
    val url: String = "https://www.youtube.com/watch_videos?video_ids=" + commaSeparatedIds
    if (Desktop.isDesktopSupported && Desktop.getDesktop.isSupported(Desktop.Action.BROWSE)) {
      Desktop.getDesktop.browse(new URI(url))
    } else {
      println("Opening the browser not supported. Click the link manually: " + url)
    }
  }

}

object Playlist {

  def makeIncubator(songs: List[Song]): List[Double] => Playlist = {
    genes: List[Double] => {
      // Apply the Song incubator for each gene
      val songIncubator = Song.makeIncubator(songs)
      new Playlist(genes.map((gene: Double) => songIncubator(List(gene))))
    }
  }

  def costFunction(input: Map[String, Int]): Playlist => Double = {
    playlist: Playlist =>
      val songs: List[Song] = playlist.songs
      val rowcost: Double = songs.map(Song.costFunction(input)).sum
      val idlist: List[String] = songs.map((f:Song) => f.youtubeId )
      if (idlist.distinct.length < idlist.length) {
        rowcost * 1000.0
      } else {
        val energy: List[Double] = songs.map((f:Song) => f.averageEnergyRating())
        val stander: Double = Statistics.standardDeviation(energy,(f:Double)=>f)
        if (stander < 0.5){
          rowcost*10.0
        } else {
          rowcost * (1 / stander)
        }
      }
  }

}