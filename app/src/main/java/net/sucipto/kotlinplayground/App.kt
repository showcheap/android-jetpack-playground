package net.sucipto.kotlinplayground

import android.app.Application
import androidx.room.Room
import net.sucipto.kotlinplayground.data.AppDatabase
import net.sucipto.kotlinplayground.data.PersonRepository
import net.sucipto.kotlinplayground.ui.detail.DetailViewModel
import net.sucipto.kotlinplayground.ui.detail.EditViewModel
import net.sucipto.kotlinplayground.ui.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {
    val appModule = module {
        single { Room.databaseBuilder(get(), AppDatabase::class.java, "database").build() }
        single { get<AppDatabase>().personDao() }
        single { PersonRepository(get()) }

        viewModel { MainViewModel(get()) }
        viewModel { DetailViewModel(get()) }
        viewModel { EditViewModel() }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}