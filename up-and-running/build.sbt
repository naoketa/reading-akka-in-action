name := "akka-quickstart-scala"

version := "1.0"

scalaVersion := "2.12.6"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.5.23",
    "com.typesafe.akka" %% "akka-http"   % "10.1.8",
    "com.typesafe.akka" %% "akka-stream" % "2.5.19",
    "com.typesafe.akka" %% "akka-slf4j"      % "2.5.23",
    "ch.qos.logback"    %  "logback-classic" % "1.2.3",
    "com.typesafe.akka" %% "akka-testkit" % "2.5.23" % "test",
    "org.scalatest" %% "scalatest" % "3.0.8" % "test"
  )
}