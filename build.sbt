import sbt.Keys._

lazy val GatlingTest = config("gatling") extend Test

scalaVersion := "2.11.11"

version := "0.1"

libraryDependencies += "com.netaporter" %% "scala-uri" % "0.4.14"
libraryDependencies += "net.codingwell" %% "scala-guice" % "4.1.0"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test
libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.2" % Test
libraryDependencies += "io.gatling" % "gatling-test-framework" % "2.2.2" % Test
    
// The Play project itself
lazy val root = (project in file("."))
  .enablePlugins(Common, PlayScala, GatlingPlugin, RpmPlugin)
  .configs(GatlingTest)
  .settings(inConfig(GatlingTest)(Defaults.testSettings): _*)
  .settings(
    name := """play-rest-api""",
    scalaSource in GatlingTest := baseDirectory.value / "/gatling/simulation"
  )

// Documentation for this project:
//    sbt "project docs" "~ paradox"
//    open docs/target/paradox/site/index.html
lazy val docs = (project in file("docs")).enablePlugins(ParadoxPlugin).
  settings(
    paradoxProperties += ("download_url" -> "https://example.lightbend.com/v1/download/play-rest-api")
  )


maintainer in Linux := "First Lastname <first.last@example.com>"

packageSummary in Linux := "My custom package summary"

packageDescription := "My longer package description"

rpmRelease := "1"

rpmVendor := "example.com"

rpmUrl := Some("http://github.com/example/server")

rpmLicense := Some("Apache v2")