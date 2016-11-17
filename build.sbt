import Dependencies._
import Settings.Formatting

name := "sbt-simple-project"

version := "1.0.0-SNAPSHOT"

organization := "com.your.company"

scalaVersion := Versions.scala212

libraryDependencies ++= dependencies

Formatting.formatSettings
