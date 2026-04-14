package model.movie

data class Movie(
    val id: Long? = null,
    val title: String,
    val runningTime: RunningTime,
)
