insert into "course"(course_id,
                     course_name,
                     institution,
                     course_url)
values ('machine-learning',
        'Machine Learning',
        'Stanford University',
        'https://www.coursera.org/learn/machine-learning');

insert into "reviewer"(reviewer_name)
values ('Li Jiayu');

insert into "review"(review_date,
                     rating,
                     reviewer_id,
                     course_id)
values ('2022-02-02',
        5,
        1,
        'machine-learning');