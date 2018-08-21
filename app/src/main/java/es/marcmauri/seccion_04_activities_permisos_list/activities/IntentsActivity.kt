package es.marcmauri.seccion_04_activities_permisos_list.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import es.marcmauri.seccion_04_activities_permisos_list.R
import es.marcmauri.seccion_04_activities_permisos_list.models.Student
import es.marcmauri.seccion_04_activities_permisos_list.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        toolbarToLoad(toolbar as Toolbar)

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
        // intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY // No guarda el activity en el stack
        // intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION // No animacion
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Borra el stack completo
        startActivity(intent)
        // finish()
    }

    private fun goIntentObject() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        val student = Student("Marc", "Mauri", 25, false)
        intent.putExtra("student", student)
        startActivity(intent)
    }
}
