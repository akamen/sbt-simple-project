
object HelloWorld {

  def main(args: Array[String]): Unit = {
    val message = Option("Scala") match {
      case Some(name) ⇒ s"Hello $name"
      case _          ⇒ "Hello world"
    }
    println(message)
  }

}
