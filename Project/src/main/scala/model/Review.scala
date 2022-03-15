package model

case class Review(
                     review_id: Int,
                     review_date: String,
                     rating: Int,
                     reviewer_id: Int,
                     course_id: String,
                     review_data: String
                 )
