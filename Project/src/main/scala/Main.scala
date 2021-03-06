import dao.Queries
import service.showResult

import scala.io.StdIn


object Main {
    def userInterfaceSetup(): Unit = {
        println(
            "______________________________________________________________\n" +
                "                     Welcome to Coursela!                     \n" +
                "______________________________________________________________\n" +
                "Functions:\n" +
                "1. Top N Courses reviewed by most number of reviewers.\n" +
                "2. Top N Institutions reviewed by most number of reviewers\n" +
                "3. Top N Courses having the highest ratings.\n" +
                "4. Top N Institutions having the highest ratings.\n" +
                "5. Top N reviewers sending the most number of reviews.\n" +
                "6. Top N institutions releasing the most number of courses.\n" +
                "7. Exit.\n" +
                "______________________________________________________________\n"
        )
    }

    def inputParameters(): (Int, Int) = {
        print("Please input the index of your selected function: ")
        var selection: Int = 0
        try {
            selection = StdIn.readInt()
        } catch {
            case _: NumberFormatException =>
                println("Invalid number format. System exit now.")
                System.exit(0)
        }
        var limit: Int = 0
        if (selection > 0 && selection < 7) {
            print("Please input your desired number N: ")
            try {
                limit = StdIn.readInt()
                while (limit <= 0) {
                    print("Illegal N. Please re-input your desired number N: ")
                    limit = StdIn.readInt()
                }
            } catch {
                case _: NumberFormatException =>
                    println("Invalid number format. System exit now.")
                    System.exit(0)
            }
        }
        print("______________________________________________________________\n")
        (selection, limit)
    }

    def main(args: Array[String]): Unit = {
        userInterfaceSetup()

        while (true) {
            val result = inputParameters()
            result._1 match {
                case 1 => showResult(Queries.rankCoursesByReviewerNumber(limit = result._2))
                case 2 => showResult(Queries.rankInstitutionsByReviewerNumber(limit = result._2))
                case 3 => showResult(Queries.rankCoursesByRating(limit = result._2))
                case 4 => showResult(Queries.rankInstitutionsByRating(limit = result._2))
                case 5 => showResult(Queries.rankReviewersByReviewNumber(limit = result._2))
                case 6 => showResult(Queries.rankInstitutionsByCoursesReleased(limit = result._2))
                case 7 => println("Goodbye!"); System.exit(0)
                case _ => println("Illegal input.")
            }
        }
    }
}