name := "spark-dataframes-meetup"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.5"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.5.1"

fork := true

updateOptions := updateOptions.value.withCachedResolution(true)
