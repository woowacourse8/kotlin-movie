package repository

import model.movie.Movie
import model.screening.Screening
import model.screening.ScreeningSeatMap
import model.screening.Screenings
import repository.InMemoryMovieRepository.F1_THE_MOVIE
import repository.InMemoryMovieRepository.IRON_MAN
import repository.InMemoryMovieRepository.ROBOT_DREAM
import repository.InMemoryMovieRepository.TOY_STORY
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class InMemoryScreeningRepository(
    private var screenings: Screenings = Screenings(createScreenings()),
): ScreeningRepository {
    override fun findBy(
        movie: Movie,
        date: LocalDate,
    ): Screenings = Screenings(screenings.filter { it.movie == movie && it.showDate == date })

    override fun update(newScreening: Screening) {
        screenings =
            Screenings(screenings.map { if (it.isSameScreening(newScreening)) newScreening else it })
    }

    companion object {
        private val BASE_DATE: LocalDate = LocalDate.of(2025, 9, 20)
        private val fMovie1 =
            Screening(
                F1_THE_MOVIE,
                LocalDateTime.of(BASE_DATE, LocalTime.of(10, 20)),
                ScreeningSeatMap(InMemoryScreenRepository.screen1),
            )
        private val fMovie2 =
            Screening(
                F1_THE_MOVIE,
                LocalDateTime.of(BASE_DATE, LocalTime.of(13, 0)),
                ScreeningSeatMap(InMemoryScreenRepository.screen1),
            )
        private val fMovie3 =
            Screening(
                F1_THE_MOVIE,
                LocalDateTime.of(BASE_DATE, LocalTime.of(15, 40)),
                ScreeningSeatMap(InMemoryScreenRepository.screen1),
            )
        private val fMovie4 =
            Screening(
                F1_THE_MOVIE,
                LocalDateTime.of(BASE_DATE, LocalTime.of(20, 10)),
                ScreeningSeatMap(InMemoryScreenRepository.screen1),
            )
        private val tMovie1 =
            Screening(
                TOY_STORY,
                LocalDateTime.of(BASE_DATE, LocalTime.of(13, 30)),
                ScreeningSeatMap(InMemoryScreenRepository.screen2),
            )
        private val tMovie2 =
            Screening(
                TOY_STORY,
                LocalDateTime.of(BASE_DATE, LocalTime.of(16, 0)),
                ScreeningSeatMap(InMemoryScreenRepository.screen2),
            )
        private val iMovie1 =
            Screening(
                IRON_MAN,
                LocalDateTime.of(BASE_DATE, LocalTime.of(9, 50)),
                ScreeningSeatMap(InMemoryScreenRepository.screen3),
            )
        private val rMovie1 =
            Screening(
                ROBOT_DREAM,
                LocalDateTime.of(BASE_DATE, LocalTime.of(21, 0)),
                ScreeningSeatMap(InMemoryScreenRepository.screen3),
            )

        private fun createScreenings(): List<Screening> = listOf(fMovie1, fMovie2, fMovie3, fMovie4, tMovie1, tMovie2, iMovie1, rMovie1)
    }
}
