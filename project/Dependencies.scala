import sbt._

object Dependencies {

  object Versions {
    val config = "1.3.3"
    val scala212 = "2.12.7"
    val scalatest = "3.0.5"
    val scala211 = "2.11.11"
  }

  object Compiles {
    val config = "com.typesafe" % "config" % Versions.config
  }

  object Tests {
    val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % Versions.scalatest % Test
  }

  import Compiles._

  lazy val dependencies = Seq(config, Tests.scalaTest)

}
