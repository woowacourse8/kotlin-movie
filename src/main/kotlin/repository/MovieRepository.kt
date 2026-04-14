package repository

import model.movie.Movie
import model.movie.Movies

interface MovieRepository {
    fun getMovies(): Movies

    fun findById(id: Long): Movie?
}
