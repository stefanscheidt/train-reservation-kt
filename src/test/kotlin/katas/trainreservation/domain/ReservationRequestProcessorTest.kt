package katas.trainreservation.domain

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ReservationRequestProcessorTest {

    val bookingReferenceService = mockk<BookingReferencePort>()
    val processor: ReservationRequestProcessor = TicketOffice(bookingReferenceService)

    @Test
    fun `booking ID of an successful reservation should be OK`() {
        val trainId = TrainId("Express 2000")

        val expectedBookingId = BookingId(value = "__booking_id__")
        every { bookingReferenceService.getBookingReference() } returns expectedBookingId

        val request = ReservationRequest(trainId, 2)
        val expectedReservation = Reservation(trainId, expectedBookingId, emptyList())

        val reservation = processor.makeReservation(request)

        assertThat(reservation).isEqualTo(expectedReservation)
    }
}
