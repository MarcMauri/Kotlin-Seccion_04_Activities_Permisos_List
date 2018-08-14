package es.marcmauri.seccion_04_activities_permisos_list.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Button
import es.marcmauri.seccion_04_activities_permisos_list.R
import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*

class KotlinAndroidExtensionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_android_extensions)

        val btn = findViewById<Button>(R.id.buttonById)
        btn.setOnClickListener { view ->
            Snackbar.make(view, "Click By ID!", Snackbar.LENGTH_SHORT).show()
        }

        buttonByKAT.setOnClickListener { view ->
            Snackbar.make(view, "Click By KAT!", Snackbar.LENGTH_SHORT).show()
        }
    }
}
