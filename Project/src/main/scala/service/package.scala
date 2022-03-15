

package object service {
    def showResult[U](result: List[(String, U)]): Unit = {
        println("Your requested result is: ")
        result.zip((1 to result.size).toList).foreach {
            case ((name, value), index) =>
                value match {
                case Some(i) => println(index + "    " + name + "    " + i)
                case _ => println(index + "    " + name + "    " + value)
            }
        }
        println()
    }
}
