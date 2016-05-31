package scorex.waves.settings

import com.typesafe.config.ConfigFactory
import scorex.utils.ScorexLogging
import scala.concurrent.duration._

/**
  * System constants here.
  */

object Constants extends ScorexLogging {
  private val appConf = ConfigFactory.load("waves.conf").getConfig("app")

  val Product = appConf.getString("product")
  val Release = appConf.getString("release")
  val VersionString = appConf.getString("version")
  val AgentName = s"$Product - $Release v. $VersionString"

  val AvgBlockDelay: Long = 60.seconds.toMillis
}