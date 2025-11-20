package com.raunak.weatherforecast.geoLocation.data.locals

import androidx.room.Room
import androidx.room.RoomDatabase
import com.raunak.weatherforecast.geoLocation.data.locals.GeolocationDatabase
import java.io.File

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<GeolocationDatabase> {
        val os = System.getProperty("os.name").lowercase()
        val userHome = System.getProperty("user.home")
        val appDataDir = when {
            os.contains("win") -> File(System.getenv("APPDATA"), "weatherforecast")
            os.contains("mac") -> File(userHome, "Library/Application Support/weatherforecast")
            else -> File(userHome, "/.local/share/weatherforecast")
        }

        if (!appDataDir.exists()) {
            appDataDir.mkdirs()
        }
        val dbFile = File(appDataDir, GeolocationDatabase.DB_NAME)
        return Room.databaseBuilder(dbFile.absolutePath)
    }
}