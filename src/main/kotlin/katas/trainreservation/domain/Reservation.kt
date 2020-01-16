package katas.trainreservation.domain

data class CoachId(val value: String)
data class TrainId(val value: String)
data class BookingReference(val value: String)

data class Seat(
    val coachId: CoachId,
    val seatNumber: Int
)

fun seatOf(coachId: String, seatNumber: Int): Seat =
    Seat(CoachId(coachId), seatNumber)

data class Reservation(
    val trainId: TrainId,
    val bookingReference: BookingReference,
    val seats: List<Seat>
)

data class ReservationRequest(
    val trainId: TrainId,
    val seatCount: Int
)
