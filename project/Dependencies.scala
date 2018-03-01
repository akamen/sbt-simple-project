import sbt._

object Dependencies {

  object Versions {
    val scala212 = "2.12.4"
    val scalatest = "3.0.5"
    val scala211 = "2.11.11"
    val scalaLogging = "3.8.0"
  }

  object Compile {
    val scalaLogging: ModuleID = "com.typesafe.scala-logging" %% "scala-logging" % Versions.scalaLogging
  }

  object Test {
    val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % Versions.scalatest % "test"
  }

  import Compile._

  lazy val dependencies = Seq(scalaLogging, Test.scalaTest)

}
