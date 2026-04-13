//package study
//
//import org.junit.jupiter.api.BeforeEach
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.boot.test.web.server.LocalServerPort
//import org.springframework.test.web.servlet.client.RestTestClient
//import kotlin.test.Test
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class ApplicationTest(
//    @param:LocalServerPort val port: Int,
//) {
//    private lateinit var client: RestTestClient // 얘 만들면 셋업 해줘야함 ㅇㅇ
//
//    @BeforeEach
//    fun setUp() {
//        client = RestTestClient
//            .bindToServer()
//            .baseUrl("http://localhost:$port")
//            .build()
//    }
//
//    @Test
//    fun test1() {
//        client.get().uri("/greeting").exchange()
//            .expectBody()
//            .jsonPath("$.name").isEqualTo("World") // $ 는 루트임. 가장 최상위의 Name 에 접근하겠다~ 이게 world 일 것.
//    }
//
//    @Test
//    fun test2() {
//        client.get().uri("/greeting?name=별터").exchange()
//            .expectBody()
//            .jsonPath("$.name").isEqualTo("별터")
//    }
//}
