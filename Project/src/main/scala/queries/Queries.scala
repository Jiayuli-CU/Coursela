package queries

import objects._
import dbSetup._
import io.getquill.Ord

object Queries extends App {
    val ctx = getDbContext(dbName = "postgres", port = 5432)
    import ctx._
    def rankCoursesByReviewerNumber(limit: Int): Result[RunQueryResult[(String, Long)]] = {
        val topCourses = run {
            quote {
                query[Review]
                  .groupBy(_.courseId)
                  .map {
                      case (course, review) => (course, review.size)
                  }
                  .sortBy(_._2)(Ord.desc)
                  .take(limit)
            }
        }
        topCourses
    }

    def rankInstitutionsByReviewerNumber(limit: Int): Result[RunQueryResult[(String, Long)]] = {
        val topInstitutions = run {
            quote {
                query[Review]
                  .join(query[Course])
                  .on(
                      (r, c) => r.courseId == c.courseId
                  )
                  .groupBy(_._2.institution)
                  .map {
                      case (institution, tuple) => (institution, tuple.size)
                  }
                  .sortBy(_._2)(Ord.desc)
                  .take(limit)
            }
        }
        topInstitutions
    }

    def rankCoursesByRating(limit: Int): Result[RunQueryResult[(String, Option[BigDecimal])]] = {
        val topRatedCourses = run {
            quote {
                query[Review]
                  .groupBy(_.courseId)
                  .map {
                      case (course, tuple) => (course,
                        tuple.map(_.rating).avg
                      )
                  }
                  .sortBy(_._2)(Ord.desc)
                  .take(limit)
            }
        }
        topRatedCourses
    }

    def rankInstitutionsByRating(limit: Int): Result[RunQueryResult[(String, Option[BigDecimal])]] = {
        val topRatedInstitutions = run {
            quote {
                query[Review]
                  .join(query[Course])
                  .on(
                      (r, c) => r.courseId == c.courseId
                  )
                  .groupBy(_._2.institution)
                  .map {
                      case (institution, tuple) => (institution,
                          tuple.map(_._1.rating).avg
                      )
                  }
                  .sortBy(_._2)(Ord.desc)
                  .take(limit)
            }
        }
        topRatedInstitutions
    }

    def rankInstitutionsByCoursesReleased(limit: Int): Result[RunQueryResult[(String, Long)]] = {
        val topReleasedInstitutions = run {
            quote {
                query[Course]
                  .groupBy(_.institution)
                  .map {
                      case (institution, courses) => (institution, courses.size)
                  }
                  .sortBy(_._2)(Ord.desc)
                  .take(limit)
            }
        }
        topReleasedInstitutions
    }

    def rankReviewersByReviewNumber(limit: Int): Result[RunQueryResult[(String, Long)]] = {
        val topReviewers = run {
            quote {
                query[Review]
                  .groupBy(_.reviewId)
                  .map {
                      case (id, reviews) => (id, reviews.size)
                  }
                  .join(query[Reviewer])
                  .on (
                      (tuple, reviewer) => (tuple._2 == reviewer.reviewerId)
                  )
                  .map {
                      case ((id, cnt), name) => (name.reviewerName, cnt)
                  }
            }
        }
        topReviewers
    }
}
