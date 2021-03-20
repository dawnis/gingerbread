
lazy val server = (project in file("server"))
  .settings(commonSettings)
  .settings(
    scalaJSProjects := Seq(client),
    pipelineStages in Assets := Seq(scalaJSPipeline),
    pipelineStages := Seq(digest, gzip),
    // triggers scalaJSPipeline when using compile or continuous compilation
    compile in Compile := ((compile in Compile) dependsOn scalaJSPipeline).value,
    libraryDependencies ++= Seq(
      "com.vmunier" %% "scalajs-scripts" % "1.1.4",
      guice,
      specs2 % Test
    )
  )
  .enablePlugins(PlayScala, WebScalaJSBundlerPlugin)
  .dependsOn(sharedJvm)

lazy val client = (project in file("client"))
  .settings(commonSettings)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "1.1.0",
      "com.github.japgolly.scalajs-react" %%% "core" % "1.7.7"
    ),
    libraryDependencies += "me.shadaj" %%% "slinky-core" % "0.6.7", // core React functionality, no React DOM
    libraryDependencies += "me.shadaj" %%% "slinky-web" % "0.6.7", // React DOM, HTML and SVG tags
    libraryDependencies += "me.shadaj" %%% "slinky-native" % "0.6.7", // React Native components
    libraryDependencies += "me.shadaj" %%% "slinky-hot" % "0.6.7", // Hot loading, requires react-proxy package
    libraryDependencies += "me.shadaj" %%% "slinky-scalajsreact-interop" % "0.6.7", // Interop with japgolly/scalajs-react
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    scalacOptions += "-Ymacro-annotations",
    npmDependencies in Compile ++= Seq(
      "react" -> "16.13.1",
      "react-dom" -> "16.13.1")
  )
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
  .dependsOn(sharedJs)

lazy val shared = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("shared"))
  .settings(commonSettings)
  .jsConfigure(_.enablePlugins(ScalaJSWeb))
lazy val sharedJvm = shared.jvm
lazy val sharedJs = shared.js

lazy val commonSettings = Seq(
  scalaVersion := "2.13.1",
  organization := "com.dds"
)
