package katas.trainreservation.domain

interface ReservationRequestProcessor {

    fun makeReservation(reservationRequest: ReservationRequest): Reservation
}
