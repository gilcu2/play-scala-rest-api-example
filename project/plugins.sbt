// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.15")

// sbt-paradox, used for documentation
addSbtPlugin("com.lightbend.paradox" % "sbt-paradox" % "0.2.1")

// Load testing tool:
// http://gatling.io/docs/2.2.2/extensions/sbt_plugin.html
addSbtPlugin("io.gatling" % "gatling-sbt" % "2.2.0")

// Scala formatting: "sbt scalafmt"
// https://olafurpg.github.io/scalafmt
addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "0.3.1")

addSbtPlugin("com.typesafe.sbt" %% "sbt-native-packager" % "1.2.0-M8")