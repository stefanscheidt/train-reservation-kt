package katas.trainreservation.domain


data class Seat(
    val coach: String,
    val seatNumber: Int
)

data class Reservation(
    val trainId: String,
    val bookingId: String,
    val seats: List<Seat>
)

data class ReservationRequest(
    val trainId: String,
    val seatCount: Int
)