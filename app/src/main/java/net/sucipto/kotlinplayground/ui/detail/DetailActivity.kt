package net.sucipto.kotlinplayground.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import net.sucipto.kotlinplayground.R

class DetailActivity : AppCompatActivity() {

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        findNavController(R.id.nav_host_detail).setGraph(R.navigation.nav_detail, intent.extras)

    }
}
