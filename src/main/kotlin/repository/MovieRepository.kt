package repository

import model.movie.Movies

interface MovieRepository {
    fun getMovies(): Movies
}
