name := "spark-dataframes-meetup"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.5"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "1.5.2",
  "org.scalatest" %% "scalatest" % "2.2.5",
  "org.mockito" % "mockito-core" % "1.10.19")

fork := true

updateOptions := updateOptions.value.withCachedResolution(true)
