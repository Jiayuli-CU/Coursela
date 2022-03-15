package objects

case class Review(
                     reviewId: Int,
                     reviewDate: String,
                     rating: Int,
                     reviewerId: Int,
                     courseId: String
                 )
