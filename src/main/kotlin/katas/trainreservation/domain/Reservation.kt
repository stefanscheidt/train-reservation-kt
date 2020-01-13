package katas.trainreservation.domain

data class Coach(val value: String)
data class TrainId(val value: String)
data class BookingReference(val value: String)

data class Seat(
    val coach: Coach,
    val seatNumber: Int
) {
    companion object {
        fun of(coach: String, seatNumber: Int) = Seat(Coach(coach), seatNumber)
    }
}

data class Reservation(
    val trainId: TrainId,
    val bookingReference: BookingReference,
    val seats: List<Seat>
)

data class ReservationRequest(
    val trainId: TrainId,
    val seatCount: Int
)

data class TrainData(
    val trainId: TrainId,
    val seats: Map<Seat, BookingReference?>
)
