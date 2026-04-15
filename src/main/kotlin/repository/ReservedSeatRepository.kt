package repository

import model.screening.Screening
import model.seat.Seats

interface ReservedSeatRepository {
    fun save(
        screening: Screening,
        seats: Seats,
    )

    fun findSeatsByScreening(screening: Screening): Seats
}
