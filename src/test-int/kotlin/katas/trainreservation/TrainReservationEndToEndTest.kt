package katas.trainreservation

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
class TrainReservationEndToEndTest(
    @Autowired mockMvc: MockMvc
) {

    @Test
    fun `make reservation`() {
        // https://docs.spring.io/spring/docs/5.2.2.RELEASE/spring-framework-reference/testing.html#spring-mvc-test-server
    }
}
