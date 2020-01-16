package katas.trainreservation.domain

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class TicketOfficeTest {

    val bookingReferenceService = mockk<BookingReferencePort>()
    val trainDataService = mockk<TrainDataPort>()
    val ticketOffice: TicketOffice = TicketOffice(
        bookingReferenceService,
        trainDataService
    )

    @Test
    fun `reserve free seat`() {
        val trainId = TrainId("__train_id__")
        every {
            bookingReferenceService.getBookingReference()
        } returns BookingReference("__booking_reference_2__")

        every {
            trainDataService.getTrainData(trainId)
        } returns TrainData(
            trainId = trainId,
            seats = mapOf(
                bookedSeatOf("A", 1, "__booking_reference_1__"),
                bookedSeatOf("A", 2, "__booking_reference_1__"),
                bookedSeatOf("A", 3, "__booking_reference_1__"),
                bookedSeatOf("A", 4, "__booking_reference_1__"),
                bookedSeatOf("A", 5, "__booking_reference_1__"),
                bookedSeatOf("A", 6, "__booking_reference_1__"),
                freeSeatOf("A", 7),
                freeSeatOf("A", 8),
                freeSeatOf("A", 9),
                freeSeatOf("A", 10)
            )
        )
    }
}

fun bookedSeatOf(coachId: String, seatNumber: Int, bookingReference: String): Pair<Seat, BookingReference?> =
    seatOf(coachId, seatNumber) to BookingReference(bookingReference)

fun freeSeatOf(coachId: String, seatNumber: Int): Pair<Seat, BookingReference?> =
    seatOf(coachId, seatNumber) to null
