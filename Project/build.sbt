ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.1"

lazy val root = (project in file("."))
    .settings(
        name := "Project",
        libraryDependencies ++= Seq(
            "mysql" % "mysql-connector-java" % "8.0.28",
            "io.getquill" % "quill-jdbc_2.13" % "3.16.3"
        )
    )
