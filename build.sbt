import Dependencies._

name := "sbt-simple-project-ari"

version := "1.0.0-SNAPSHOT"

organization := "com.your.company"

scalaVersion := Versions.scala212


libraryDependencies ++= dependencies

enablePlugins(PackPlugin)
