val scala3Version = "3.1.1"
val scala2Version = "2.13.6"
val globalVersion = "0.1.0-SNAPSHOT"

lazy val tp = project
    .in(file("."))
    .settings(
        name := "TeamProject",
        version := globalVersion,
        scalaVersion := scala2Version,
        libraryDependencies ++= {
            Seq(
                "org.typelevel" %% "cats-core" % "2.7.0",
                "org.scalactic" %% "scalactic" % "3.2.10",
                "org.scalatest" %% "scalatest" % "3.2.10" % "test",
                "org.scalacheck" %% "scalacheck" % "1.15.4" % "test",
                "com.github.nscala-time" %% "nscala-time" % "2.30.0",
                "io.getquill" %% "quill-jdbc" % "3.16.3",
                "io.getquill" %% "quill-jasync-postgres" % "3.16.3",
                "org.postgresql" % "postgresql" % "42.3.2",
                "org.slf4j" % "slf4j-simple" % "1.7.36"
            )
        }
    )