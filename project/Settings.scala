import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys
import sbt._
import sbtassembly.AssemblyPlugin.autoImport._
import sbtassembly.PathList

import scalariform.formatter.preferences.FormattingPreferences

object Settings {

  object Formatting {
    lazy val formatSettings = SbtScalariform.scalariformSettings ++ Seq(
      ScalariformKeys.preferences in Compile := formattingPreferences,
      ScalariformKeys.preferences in Test := formattingPreferences
    )

    lazy val docFormatSettings = SbtScalariform.scalariformSettings ++ Seq(
      ScalariformKeys.preferences in Compile := docFormattingPreferences,
      ScalariformKeys.preferences in Test := docFormattingPreferences
    )

    def formattingPreferences: FormattingPreferences = {
      import scalariform.formatter.preferences._
      FormattingPreferences()
        .setPreference(RewriteArrowSymbols, true)
        .setPreference(AlignParameters, true)
        .setPreference(AlignSingleLineCaseStatements, true)
    }

    def docFormattingPreferences: FormattingPreferences = {
      import scalariform.formatter.preferences._
      FormattingPreferences()
        .setPreference(RewriteArrowSymbols, false)
        .setPreference(AlignParameters, true)
        .setPreference(AlignSingleLineCaseStatements, true)
    }
  }

  object Packaging {
    val assemblySettings = {
      assemblyMergeStrategy in assembly := {
        case PathList("META-INF", "io.netty.versions.properties", xs@_*) => MergeStrategy.first
        case PathList("javax", "servlet", xs@_*) => MergeStrategy.first
        case PathList(ps@_*) if ps.last endsWith ".html" => MergeStrategy.first
        case "application.conf" => MergeStrategy.concat
        case "unwanted.txt" => MergeStrategy.discard
        case x =>
          val oldStrategy = (assemblyMergeStrategy in assembly).value
          oldStrategy(x)
      }
    }
  }

}