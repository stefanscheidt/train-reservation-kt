package katas.trainreservation.domain

class TicketOffice(
    private val bookingReferencePort: BookingReferencePort
) : ReservationRequestProcessor {

    override fun makeReservation(reservationRequest: ReservationRequest): Reservation {
        val bookingReference = bookingReferencePort.getBookingReference()
        return Reservation(reservationRequest.trainId, bookingReference, listOf())
    }
}
