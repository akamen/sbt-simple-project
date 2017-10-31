import com.typesafe.sbt.SbtScalariform.ScalariformKeys
import sbt.{AutoPlugin, Def, PluginTrigger, Setting, _}

import scalariform.formatter.preferences.FormattingPreferences

object Formatting extends AutoPlugin {

  override def trigger: PluginTrigger = allRequirements

  override def projectSettings: Seq[Def.Setting[_]] = formatSettings

  lazy val formatSettings: Seq[Setting[_]] = Seq(
    ScalariformKeys.autoformat in Test := true,
    ScalariformKeys.autoformat in Compile := true,
    ScalariformKeys.preferences in Compile := formattingPreferences,
    ScalariformKeys.preferences in Test := formattingPreferences
  )

  lazy val docFormatSettings: Seq[Setting[_]] = Seq(
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
