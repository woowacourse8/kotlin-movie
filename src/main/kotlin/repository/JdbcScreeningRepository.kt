package repository

import model.movie.Movie
import model.screening.Screening
import model.screening.Screenings
import java.time.LocalDate

class JdbcScreeningRepository : ScreeningRepository {
    override fun findBy(
        movie: Movie,
        date: LocalDate
    ): Screenings {
        TODO("Not yet implemented")
    }

    override fun update(newScreening: Screening) {
        TODO("Not yet implemented")
    }
}
