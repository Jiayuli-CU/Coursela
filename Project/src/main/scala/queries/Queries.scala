package queries

import dbSetup.getDbContext

object Queries extends App {
    val ctx = getDbContext(dbName = "coursela", port = 5432)
    import ctx._
    def rankCoursesByReviewerNumber(limit: Int): Unit = {
        // todo
    }

    def rankInstitutionsByReviewerNumber(limit: Int): Unit = {
        // todo
    }

    def rankCoursesByRating(limit: Int): Unit = {
        // todo
    }

    def rankInstitutionsByRating(limit: Int): Unit = {
        // todo
    }

    def rankInstitutionsByCoursesReleased(limit: Int): Unit = {
        // todo
    }

    def rankReviewersByReviewNumber(limit: Int): Unit = {
        // todo
    }
}
