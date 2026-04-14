import controller.MovieReservationController
import repository.InMemoryScreeningRepository
import view.InputView
import view.OutputView

fun main() {
    MovieReservationController(
        screeningRepo = InMemoryScreeningRepository(),
        inputView = InputView,
        outputView = OutputView,
    ).run()
}
