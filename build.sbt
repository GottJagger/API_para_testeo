ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "API_testing_local",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.2.10",
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.2.10",
      "com.typesafe.akka" %% "akka-stream" % "2.6.16",
    ),
    // https://mvnrepository.com/artifact/ch.megard/akka-http-cors
    libraryDependencies += "ch.megard" %% "akka-http-cors" % "1.2.0",
    // https://mvnrepository.com/artifact/org.json4s/json4s-native
    libraryDependencies += "org.json4s" %% "json4s-native" % "4.0.3",
    // https://mvnrepository.com/artifact/org.json4s/json4s-jackson
    libraryDependencies += "org.json4s" %% "json4s-jackson" % "4.0.3"


  )
