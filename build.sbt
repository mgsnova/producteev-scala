name := "producteev"

version := "0.5"

seq(ProguardPlugin.proguardSettings :_*)

makeInJarFilter <<= (makeInJarFilter) {
  (makeInJarFilter) => {
    (file) => file match {
      case "scalatest-1.3.jar" => makeInJarFilter(file) + ",!**"
      case "scalatest-1.4.1.jar" => makeInJarFilter(file) + ",!**"
      case "scalatest-1.5.jar" => makeInJarFilter(file) + ",!**"
      case "asm-all-3.3.1.jar" => makeInJarFilter(file) + ",!**"
      case "easymock-3.0.jar" => makeInJarFilter(file) + ",!**"
      case "objenesis-1.2.jar" => makeInJarFilter(file) + ",!**"
      case _ => makeInJarFilter(file)
    }
  }
}

proguardLibraryJars += new java.io.File("/Applications/dev/android/android-sdk-mac_x86/platforms/android-8/android.jar")

proguardOptions ++= Seq(
  "-dontpreverify",
  "-repackageclasses ''",
  "-allowaccessmodification",
  "-optimizations !code/simplification/arithmetic",
  "-dontwarn",
  "-dontoptimize",
  "-dontobfuscate",
  "-dontskipnonpubliclibraryclasses",
  "-dontskipnonpubliclibraryclassmembers",
  "-keepattributes Exceptions,InnerClasses,Signature,Deprecated,SourceFile,LineNumberTable,*Annotation*,EnclosingMethod",
  "-keep public class org.producteev.** { public protected *; }"
)
