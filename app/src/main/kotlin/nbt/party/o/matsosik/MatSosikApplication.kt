@file:Suppress("SpellCheckingInspection")

package nbt.party.o.matsosik

import android.app.Application
import config.Config
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MatSosikApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if (Config.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}