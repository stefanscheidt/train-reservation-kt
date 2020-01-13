package katas.trainreservation.domain

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ReservationRequestProcessorTest {

    val bookingReferenceService = mockk<BookingReferencePort>()
    val trainDataService = mockk<TrainDataPort>()
    val processor: ReservationRequestProcessor = TicketOffice(
        bookingReferenceService,
        trainDataService
    )

    @Test
    fun `booking ID of an successful reservation should be OK`() {
        val trainId = TrainId("__train_id__")

        val expectedBookingId = BookingReference(value = "__booking_id__")
        every { bookingReferenceService.getBookingReference() } returns expectedBookingId

        val trainData = TrainData(
            trainId,
            mapOf(
                Seat.of("A", 1) to null,
                Seat.of("A", 2) to null
            )
        )
        every { trainDataService.getTrainData(trainId) } returns trainData

        val request = ReservationRequest(trainId, 2)
        val expectedReservation = Reservation(
            trainId = trainId,
            bookingReference = expectedBookingId,
            seats = listOf(
                Seat.of("A", 1),
                Seat.of("A", 2)
            )
        )

        val reservation = processor.makeReservation(request)

        assertThat(reservation).isEqualTo(expectedReservation)
    }
}
