package repository

import model.reservation.Reservation
import model.reservation.Reservations
import java.time.LocalDate

interface ReservationRepository {
    fun save(reservation: Reservation)

    fun findByDate(date: LocalDate): Reservations
}
