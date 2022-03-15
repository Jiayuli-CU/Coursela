import queries.Queries

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
        val selection: Int = StdIn.readInt()
        print("Please input your desired number N: ")
        val limit: Int = StdIn.readInt()
        print("______________________________________________________________\n")
        (selection, limit)
    }

    def main(args: Array[String]): Unit = {
        userInterfaceSetup()

        while (true) {
            val result = inputParameters()
            result._1 match {
                case 1 => Queries.rankCoursesByReviewerNumber(limit = result._2)
                case 2 => Queries.rankInstitutionsByReviewerNumber(limit = result._2)
                case 3 => Queries.rankCoursesByRating(limit = result._2)
                case 4 => Queries.rankInstitutionsByRating(limit = result._2)
                case 5 => Queries.rankReviewersByReviewNumber(limit = result._2)
                case 6 => Queries.rankInstitutionsByCoursesReleased(limit = result._2)
                case 7 => println("Goodbye!"); System.exit(0)
                case _ => println("Illegal input.")
            }
        }
    }
}