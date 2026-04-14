package repository

import database.DatabaseConnectionFactory
import model.movie.Movie
import model.movie.Movies
import model.movie.RunningTime

class JdbcMovieRepository(private val isLocal: Boolean) : MovieRepository {
    override fun getMovies(): Movies {
        val connection = DatabaseConnectionFactory.createConnection(isLocal = isLocal)
        val movies = mutableListOf<Movie>()

        connection.use { conn ->
            conn.createStatement().use { statement ->
                val sql = """
                    SELECT * FROM movie
                """.trimIndent()

                val resultSet = statement.executeQuery(sql)

                while (resultSet.next()) {
                    val id = resultSet.getLong("id")
                    val title = resultSet.getString("title")
                    val runningTime = resultSet.getLong("running_time")

                    movies.add(
                        Movie(
                            id = id,
                            title = title,
                            runningTime = RunningTime(runningTime)
                        )
                    )
                }
            }
        }
        return Movies(movies)
    }

    override fun findById(id: Long): Movie? {
        val movies = getMovies()
        return movies.findById(id)
    }
}
