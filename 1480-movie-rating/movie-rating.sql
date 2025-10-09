# Write your MySQL query statement below
With TopUser AS (SELECT Users.name AS results FROM MovieRating JOIN Users USING (user_id) GROUP BY Users.user_id ORDER BY COUNT(MovieRating.movie_id) DESC, Users.name LIMIT 1),
TopMovie AS (SELECT Movies.title AS results FROM MovieRating JOIN Movies USING (movie_id) WHERE DATE_FORMAT(created_at, '%Y-%m')='2020-02' GROUP BY Movies.movie_id ORDER BY AVG(MovieRating.rating) DESC, Movies.title LIMIT 1)
SELECT results FROM TopUser UNION ALL SELECT results FROM TopMovie;