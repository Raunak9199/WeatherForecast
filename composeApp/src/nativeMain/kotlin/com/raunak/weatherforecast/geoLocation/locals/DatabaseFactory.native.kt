package com.raunak.weatherforecast.geoLocation.locals

import androidx.room.Room
import androidx.room.RoomDatabase
import com.raunak.weatherforecast.geoLocation.data.locals.GeolocationDatabase
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<GeolocationDatabase> {
        val dbFile = documentDirectory() +"/${GeolocationDatabase.DB_NAME}"
        return Room.databaseBuilder<GeolocationDatabase>(
            name = dbFile
        )
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    private fun documentDirectory(): String {
        val urls = NSFileManager.defaultManager.URLsForDirectory(
            directory = NSDocumentDirectory,
            inDomains = NSUserDomainMask
        )

        // Cast first element from List<*> to NSURL
        val docUrl = urls.firstOrNull() as? NSURL
            ?: error("Could not get iOS document directory URL")

        // NSURL.path is available ONLY after casting
        return docUrl.path
            ?: error("Document directory URL has no valid path")
    }
}