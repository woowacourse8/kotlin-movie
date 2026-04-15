import controller.MovieReservationController
import repository.inmemory.InMemoryScreeningRepository
import view.InputView
import view.OutputView

fun main() {
    MovieReservationController(
        screeningRepo = InMemoryScreeningRepository(),
        inputView = InputView,
        outputView = OutputView,
    ).run()
}
