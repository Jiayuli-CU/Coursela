package object service {
    def showResult[U] (result: List[(String, U)]): Unit = {
        result.foreach {
            case (name, value) => println(name + " " + value)
        }
    }
}
