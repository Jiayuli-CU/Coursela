package queries

import dbSetup.getDbContext
import objects.Course

object Queries extends App {
    val ctx = getDbContext(dbName = "coursela", port = 5432)
    import ctx._

//    select (select course_name
//        from "Course"
//    where course_id = "Review".course_id)
//    as course_name,
//    count(*) as review_num
//    from "Review"
//    group by course_id
//    order by review_num desc
//    limit 1
    def rankCoursesByReviewerNumber(limit: Int): Unit = {
        val result =  run {
            quote {
                query[Course]
            }
        }
    }

//    select institution, count(institution) as review_num
//    from "Course"
//    join "Review" R on "Course".course_id = R.course_id
//    group by institution
//    order by review_num desc
//    limit 1
    def rankInstitutionsByReviewerNumber(limit: Int): Unit = {
        // todo
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
    def rankCoursesByRating(limit: Int): Unit = {
        // todo
    }

//    select institution, avg(rating) as avg_rating
//    from "Course"
//    join "Review" R on "Course".course_id = R.course_id
//    group by institution
//    order by avg_rating desc
//    limit 1
    def rankInstitutionsByRating(limit: Int): Unit = {
        // todo
    }

//    select institution, count(course_id) as course_released
//    from "Course"
//    group by institution
//    order by course_released desc
//    limit 1
    def rankInstitutionsByCoursesReleased(limit: Int): Unit = {
        // todo
    }

//    select reviewer_name, count(review_id) as review_num
//    from "Reviewer" join "Review" R on "Reviewer".reviewer_id = R.reviewer_id
//    group by reviewer_name
//    order by review_num desc
//    limit 1
    def rankReviewersByReviewNumber(limit: Int): Unit = {
        // todo
    }
}
