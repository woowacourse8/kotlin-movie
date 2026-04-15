package repository

import model.movie.Movie
import model.screening.Screening
import model.screening.Screenings
import java.time.LocalDate

interface ScreeningRepository {
    fun findBy(movie: Movie, date: LocalDate): Screenings

    fun findById(id: Long): Screening?
}
