//package study
//
//import model.movie.Movie
//import model.movie.Movies
//import model.movie.RunningTime
//import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.runApplication
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.RequestParam
//import org.springframework.web.bind.annotation.RestController
//import repository.MovieRepository
//import repository.ScreeningRepository
//import java.time.LocalDateTime
//
//data class Greeting(
//    val id: Long,
//    val name: String,
//) {
//    fun sayHello(): String = "Hello, $name!"
//}
//
//@RestController // json 타입을 반환할 때 사용하는 어노테이션
//class GreetingController {
//    @GetMapping("/greeting")
//    fun hello(
//        @RequestParam(required = false) name: String = "World"
//    ): Greeting {
//        return Greeting(1L, name)
//    }
//}
//
//@RestController
//class MoviesController {
//    @GetMapping("/api/movies")
//    fun allMovies(
//        @RequestParam(required = false) title: String
//    ): List<ScreeningDto> {
//        return ScreeningRepository().getAllScreenings().map { screening ->
//            ScreeningDto(
//                id = 1L,
//                title = screening.movie.title,
//                runningTimeMinutes = screening.movie.runningTime.minute,
//                screenings = listOf(
//                    ScreeningTime(
//                        id = 101L,
//                        startAt = screening.startDateTime,
//                        endAt = screening.endDateTime
//                    )
//                )
//            )
//        }
//    }
//}
//
//data class ScreeningDto(
//    val id: Long,
//    val title: String,
//    val runningTimeMinutes: Long,
//    val screenings: List<ScreeningTime>
//)
//
//data class ScreeningTime(
//    val id: Long,
//    val startAt: LocalDateTime,
//    val endAt: LocalDateTime
//)
//
//@SpringBootApplication
//class Application
//
//fun main(args: Array<String>) {
//    runApplication<Application>(*args)
//}
