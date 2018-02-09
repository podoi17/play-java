name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42"
)

/*libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,

  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "mysql" % "mysql-connector-java" % "5.1.21"

)*/




fork in run := true