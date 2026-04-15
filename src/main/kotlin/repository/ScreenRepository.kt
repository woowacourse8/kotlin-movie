package repository

import model.Screen

interface ScreenRepository {
    fun findByName(name: String): Screen?
}
