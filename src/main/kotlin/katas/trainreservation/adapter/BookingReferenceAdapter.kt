package katas.trainreservation.adapter

import katas.trainreservation.domain.BookingId
import katas.trainreservation.domain.BookingReferencePort
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class BookingReferenceAdapter(
    val restTemplate: RestTemplate
) : BookingReferencePort {

    override fun getBookingReference(): BookingId {
        TODO("not implemented")
    }
}
