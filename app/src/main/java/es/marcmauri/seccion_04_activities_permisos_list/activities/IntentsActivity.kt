package es.marcmauri.seccion_04_activities_permisos_list.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import es.marcmauri.seccion_04_activities_permisos_list.R
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        val btnExtras = buttonIntentExtras
        val btnFlags = buttonIntentFlags
        val btnObject = buttonIntentObject

        buttonIntentExtras.setOnClickListener { goIntentExtras() }
        buttonIntentFlags.setOnClickListener { goIntentFlags() }
        buttonIntentObject.setOnClickListener { goIntentObject() }
    }

    private fun goIntentExtras() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        intent.putExtra("name", "Manolo")
        intent.putExtra("lastName", "De los Palotes")
        intent.putExtra("age", 27)
        intent.putExtra("developer", true)
        startActivity(intent)
    }

    private fun goIntentFlags() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        startActivity(intent)
    }

    private fun goIntentObject() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        startActivity(intent)
    }
}
