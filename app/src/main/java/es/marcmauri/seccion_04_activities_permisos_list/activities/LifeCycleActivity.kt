package es.marcmauri.seccion_04_activities_permisos_list.activities

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import es.marcmauri.seccion_04_activities_permisos_list.R

class LifeCycleActivity : LifeCycleEventsActivity() {

    private var exitEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }

    override fun onBackPressed() {
        if (exitEnabled) super.onBackPressed()
        else {
            exitEnabled = true
            Toast.makeText(this, "Click back again to exit this screen", Toast.LENGTH_SHORT).show()
            Handler().postDelayed(Runnable { exitEnabled = false }, 2000)
        }
    }
}
