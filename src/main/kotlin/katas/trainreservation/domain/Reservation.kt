package katas.trainreservation.domain

data class Coach(val value: String)
data class TrainId(val value: String)
data class BookingId(val value: String)

data class Seat(
    val coach: Coach,
    val seatNumber: Int
)

data class Reservation(
    val trainId: TrainId,
    val bookingId: BookingId,
    val seats: List<Seat>
)

data class ReservationRequest(
    val trainId: TrainId,
    val seatCount: Int
)
