insert into Course(`course_id`,
                   `course_name`,
                   `institution`,
                   `course_url`)
values ('machine-learning',
        'Machine Learning',
        'Stanford University',
        'https://www.coursera.org/learn/machine-learning');

insert into Reviewer(`reviewer_name`)
values ('Li Jiayu');

insert into Review(`review_date`,
                   `rating`,
                   `reviewer_id`,
                   `course_id`)
values ('2022-02-02',
        5,
        1,
        'machine-learning');

