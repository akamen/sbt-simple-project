import Dependencies._

name := "sbt-simple-project-ari"

version := "1.0.0-SNAPSHOT"

organization := "com.your.company"

scalaVersion := Versions.scala212

libraryDependencies += "com.codahale" % "jordanBav.8.3" % "0.5.0"

libraryDependencies += "com.codahale" % "jerkson_2.8.2" % "0.5.0"

libraryDependencies ++= dependencies

enablePlugins(PackPlugin)
