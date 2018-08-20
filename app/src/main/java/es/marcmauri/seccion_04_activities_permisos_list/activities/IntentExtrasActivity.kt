package es.marcmauri.seccion_04_activities_permisos_list.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import es.marcmauri.seccion_04_activities_permisos_list.R
import kotlinx.android.synthetic.main.activity_intent_extras.*

class IntentExtrasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)

        getIntentExtrasFromPreviousActivity()
    }

    private fun getIntentExtrasFromPreviousActivity() {
        val name: String? = intent.getStringExtra("name")
        val lastName: String? = intent.getStringExtra("lastName")
        val age: Int = intent.getIntExtra("age",-1)
        val developer: Boolean = intent.getBooleanExtra("developer", false)

        if (name != null && lastName != null && age >= 0) {
            textViewName.text = name
            textViewLastName.text = lastName
            textViewAge.text = "$age"
            checkBoxDeveloper.text = "Developer"
            checkBoxDeveloper.isChecked = developer
        } else {
            checkBoxDeveloper.visibility = View.INVISIBLE
        }
    }
}
