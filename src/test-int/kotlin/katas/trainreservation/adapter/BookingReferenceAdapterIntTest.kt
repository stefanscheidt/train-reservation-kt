package katas.trainreservation.adapter

import org.junit.jupiter.api.Test
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.web.client.RestTemplate

class BookingReferenceAdapterIntTest {

    private val restTemplate = RestTemplate()
    private val mockServer = MockRestServiceServer.bindTo(restTemplate).build()
    private val bookingReferenceAdapter = BookingReferenceAdapter(restTemplate)

    @Test
    fun `get booking reference`() {
        // https://docs.spring.io/spring/docs/5.2.2.RELEASE/spring-framework-reference/testing.html#spring-mvc-test-client
    }
}
