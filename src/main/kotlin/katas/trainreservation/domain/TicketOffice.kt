package katas.trainreservation.domain

class TicketOffice(
    private val bookingReferencePort: BookingReferencePort,
    private val trainDataPort: TrainDataPort
) : ReservationRequestProcessor {

    override fun makeReservation(reservationRequest: ReservationRequest): Reservation {
        val bookingReference = bookingReferencePort.getBookingReference()
        val trainData = trainDataPort.getTrainData(reservationRequest.trainId)
        return Reservation(
            trainId = reservationRequest.trainId,
            bookingReference = bookingReference,
            seats = trainData?.seats?.keys?.toList() ?: emptyList()
        )
    }
}
