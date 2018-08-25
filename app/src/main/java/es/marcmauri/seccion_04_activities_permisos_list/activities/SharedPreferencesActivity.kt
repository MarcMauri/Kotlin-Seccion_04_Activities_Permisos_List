package es.marcmauri.seccion_04_activities_permisos_list.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import es.marcmauri.seccion_04_activities_permisos_list.R
import es.marcmauri.seccion_04_activities_permisos_list.app.preferences
import es.marcmauri.seccion_04_activities_permisos_list.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
        toolbarToLoad(toolbar as Toolbar)

        buttonSave.setOnClickListener { setValuesSharedPreferences(); cleanEditTexts(); getValuesSharedPreferences() }
        getValuesSharedPreferences()
    }

    private fun getValuesSharedPreferences() {
        if (preferences.name.isNotEmpty() && preferences.age >= 0)
            textViewSharedPreferences.text = "Welcome ${preferences.name}, your age is ${preferences.age}"
        else
            textViewSharedPreferences.text = "Welcome! Please save your name and age"
    }

    private fun setValuesSharedPreferences() {
        if (editTextName.text.toString().isNotEmpty() && editTextAge.toString().isNotEmpty()) {
            preferences.name = editTextName.text.toString()
            preferences.age = editTextAge.text.toString().toInt()
            Snackbar.make(constraint, "Values have been saved successfully", Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(constraint, "Please fill the name and the age before saving", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun cleanEditTexts() {
        editTextName.text.clear()
        editTextAge.setText("")
    }
}
