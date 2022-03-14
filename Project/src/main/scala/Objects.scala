case class Course (
    courseId: String,
    courseName: String,
    institution: String,
    courseUrl: String,
)

case class Reviewer (
    reviewerId: Int,
    reviewerName: String,
)

case class Review (
    reviewId: Int,
    reviewDate: String,
    rating: Int,
    reviewerId: Int,
    courseId: String
)

