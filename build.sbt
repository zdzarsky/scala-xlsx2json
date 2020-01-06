name := "scala-xlsx2json"

version := "0.1"

scalaVersion := "2.13.1"
mainClass in(Compile, run) := Some("com.github.zdzarsky.App")

resourceDirectory in Compile := baseDirectory.value / "src/main/resources"

resourceDirectory in Test := baseDirectory.value / "src/test/test-resources"


// Apache POI
libraryDependencies += "org.apache.poi" % "poi" % "4.1.1"
libraryDependencies += "org.apache.poi" % "poi-ooxml" % "4.1.1"
// Scala Test
libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"
// Json
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.8.1"

