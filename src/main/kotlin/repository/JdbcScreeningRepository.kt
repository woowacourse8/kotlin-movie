package repository

import database.DatabaseConnectionFactory
import model.movie.Movie
import model.screening.Screening
import model.screening.ScreeningSeatMap
import model.screening.Screenings
import java.time.LocalDate
import java.time.LocalDateTime

class JdbcScreeningRepository(
    private val isLocal: Boolean,
    private val screenRepository: ScreenRepository
) : ScreeningRepository {
    override fun findBy(
        movie: Movie,
        date: LocalDate
    ): Screenings {
        val connection = DatabaseConnectionFactory.createConnection(isLocal = isLocal)
        val screenings = mutableListOf<Screening>()

        connection.use { conn ->
            val sql = """
                SELECT *
                FROM screening
                WHERE movie_id = ?
                AND CAST(start_date_time AS DATE) = ?
            """.trimIndent()

            conn.prepareStatement(sql).use { pStatement ->
                pStatement.setLong(
                    1,
                    requireNotNull(movie.id) { "DB에 저장된 영화 ID(${movie.id})를 찾을 수 없습니다." }
                )
                pStatement.setObject(2, date)

                val resultSet = pStatement.executeQuery()

                while (resultSet.next()) {
                    val id = resultSet.getLong("id")
                    val startDateTime =
                        resultSet.getObject("start_date_time", LocalDateTime::class.java)
                    val screenName = resultSet.getString("screen_name")

                    val screen = requireNotNull(screenRepository.findByName(screenName)) {
                        "DB에 저장된 상영관 이름($screenName)을 찾을 수 없습니다."
                    }

                    screenings.add(
                        Screening(
                            id = id,
                            movie = movie,
                            startDateTime = startDateTime,
                            seatMap = ScreeningSeatMap(screen)
                        )
                    )
                }
            }
        }
        return Screenings(screenings)
    }
}
