import controller.MovieReservationController
import database.DatabaseInitializer
import repository.inmemory.InMemoryScreenRepository
import repository.inmemory.InMemoryScreeningRepository
import repository.jdbc.JdbcMovieRepository
import repository.jdbc.JdbcReservationRepository
import repository.jdbc.JdbcReservedSeatRepository
import repository.jdbc.JdbcScreeningRepository
import view.InputView
import view.OutputView

fun main() {
    val isLocal = true

    DatabaseInitializer.initTables(isLocal)

    val inputView = InputView
    val outputView = OutputView

    val movieRepository = JdbcMovieRepository(isLocal)
    val screenRepository = InMemoryScreenRepository
    val screeningRepository = JdbcScreeningRepository(
        isLocal = isLocal,
        screenRepository = screenRepository,
        movieRepository = movieRepository
    )
    val reservationRepository = JdbcReservationRepository(isLocal, screeningRepository)
    val reservedSeatRepository = JdbcReservedSeatRepository(isLocal)

    MovieReservationController(
        screeningRepository = screeningRepository,
        movieRepository = movieRepository,
        reservationRepository = reservationRepository,
        reservedSeatRepository = reservedSeatRepository,
        inputView = inputView,
        outputView = outputView,
    ).run()
}
