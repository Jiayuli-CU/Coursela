package dao

import dbSetup._
import io.getquill.Ord
import model._


object Queries extends App {
    //    select (select course_name
    //        from "Course"
    //    where course_id = "Review".course_id)
    //    as course_name,
    //    count(*) as review_num
    //    from "Review"
    //    group by course_id
    //    order by review_num desc
    //    limit 1
    def rankCoursesByReviewerNumber(limit: Int): List[(String, Long)] = {
        val ctx = getDbContext(dbName = "postgres", port = 5432)
        import ctx._
        val topCourses = run {
            quote {
                query[Review]
                  .join(query[Course])
                  .on (
                    (r, c) => r.course_id == c.course_id
                  )
                  .groupBy(_._2.course_name)
                  .map {
                      case (cname, reviews) => (cname, reviews.size)
                  }
                  .sortBy(_._2)(Ord.desc)
                  .take(lift(limit))
            }
        }
        topCourses
    }

    //    select institution, count(institution) as review_num
    //    from "Course"
    //    join "Review" R on "Course".course_id = R.course_id
    //    group by institution
    //    order by review_num desc
    //    limit 1
    def rankInstitutionsByReviewerNumber(limit: Int): List[(String, Long)] = {
        val ctx = getDbContext(dbName = "postgres", port = 5432)
        import ctx._
        val topInstitutions = run {
            quote {
                query[Review]
                  .join(query[Course])
                  .on(
                      (r, c) => r.course_id == c.course_id
                  )
                  .groupBy(_._2.institution)
                  .map {
                      case (institution, tuple) => (institution, tuple.size)
                  }
                  .sortBy(_._2)(Ord.desc)
                  .take(lift(limit))
            }
        }
        topInstitutions
    }

  //    select (select course_name
  //        from "Course"
  //    where course_id = "Review".course_id)
  //    as course_name,
  //    avg(rating) as avg_rating
  //    from "Review"
  //    group by course_id
  //    order by avg_rating desc
  //    limit 1
  def rankCoursesByRating(limit: Int): List[(String, Option[BigDecimal])] = {
      val ctx = getDbContext(dbName = "postgres", port = 5432)
      import ctx._
      val topRatedCourses = run {
            quote {
                query[Review]
                  .join(query[Course])
                  .on (
                    (r, c) => r.course_id == c.course_id
                  )
                  .groupBy(_._2.course_name)
                  .map {
                    case (cname, tuples) => (cname,
                      tuples.map(_._1.rating).avg
                    )
                  }
                  .sortBy(_._2)(Ord.desc)
                  .take(lift(limit))
            }
        }
        topRatedCourses
    }

    //    select institution, avg(rating) as avg_rating
    //    from "Course"
    //    join "Review" R on "Course".course_id = R.course_id
    //    group by institution
    //    order by avg_rating desc
    //    limit 1
    def rankInstitutionsByRating(limit: Int): List[(String, Option[BigDecimal])] = {
        val ctx = getDbContext(dbName = "postgres", port = 5432)
        import ctx._
        val topRatedInstitutions = run {
            quote {
                query[Review]
                  .join(query[Course])
                  .on(
                      (r, c) => r.course_id == c.course_id
                  )
                  .groupBy(_._2.institution)
                  .map {
                      case (institution, tuple) => (institution,
                          tuple.map(_._1.rating).avg
                      )
                  }
                  .sortBy(_._2)(Ord.desc)
                  .take(lift(limit))
            }
        }
        topRatedInstitutions
    }

    //    select institution, count(course_id) as course_released
    //    from "Course"
    //    group by institution
    //    order by course_released desc
    //    limit 1
    def rankInstitutionsByCoursesReleased(limit: Int): List[(String, Long)] = {
        val ctx = getDbContext(dbName = "postgres", port = 5432)
        import ctx._
        val topReleasedInstitutions = run {
            quote {
                query[Course]
                  .groupBy(_.institution)
                  .map {
                      case (institution, courses) => (institution, courses.size)
                  }
                  .sortBy(_._2)(Ord.desc)
                  .take(lift(limit))
            }
        }
        topReleasedInstitutions
    }

    //    select reviewer_name, count(review_id) as review_num
    //    from "Reviewer" join "Review" R on "Reviewer".reviewer_id = R.reviewer_id
    //    group by reviewer_name
    //    order by review_num desc
    //    limit 1
    def rankReviewersByReviewNumber(limit: Int): List[(String, Long)] = {
        val ctx = getDbContext(dbName = "postgres", port = 5432)
        import ctx._
        val topReviewers = run {
            quote {
                query[Review]
                  .join(query[Reviewer])
                  .on (
                      (review, reviewer) => review.review_id == reviewer.reviewer_id
                  )
                  .groupBy(_._2.reviewer_name)
                  .map {
                      case (name, tuple) => (name, tuple.size)
                  }
                  .sortBy(_._2)(Ord.desc)
                  .take(lift(limit))
            }
        }
        topReviewers
    }
}
