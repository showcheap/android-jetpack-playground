package net.sucipto.kotlinplayground.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import net.sucipto.kotlinplayground.R

class DetailActivity : AppCompatActivity() {

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        navController = findNavController(R.id.nav_host_detail)
        navController.setGraph(R.navigation.nav_detail, intent.extras)

//        NavigationUI.setupActionBarWithNavController(this, navController)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                if(!navController.navigateUp()){
                    finish()
                }

                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
