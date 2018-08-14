package es.marcmauri.seccion_04_activities_permisos_list.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import es.marcmauri.seccion_04_activities_permisos_list.R

class ClickEventsActivity : AppCompatActivity(), View.OnLongClickListener {

    // 1) Click en XML
    // 2) Click en linea
    // 3) Click by IDS en 'when'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_events)

        clickInLine()

        val btn1 = findViewById<Button>(R.id.buttonClickMulti1)
        val btn2 = findViewById<Button>(R.id.buttonClickMulti2)
        val btn3 = findViewById<Button>(R.id.buttonClickMulti3)

        btn1.setOnLongClickListener(this)
        btn2.setOnLongClickListener(this)
        btn3.setOnLongClickListener(this)
    }

    // Regla obligatoria para clicks en XMLs:
    // el metodo tiene que ser publico, nombres tienen que coincidir y recibe 1 solo parametro (View)
    fun xmlClick(view: View) {
        Snackbar.make(view, "Click by XML!", Snackbar.LENGTH_SHORT).show()
    }

    private fun clickInLine() {
        val btn = findViewById<Button>(R.id.buttonClickInLine)
        btn.setOnClickListener { view -> Snackbar.make(view, "Click in Line!", Snackbar.LENGTH_SHORT).show() }
    }

    override fun onLongClick(view: View): Boolean {
        when (view.id) {
            R.id.buttonClickMulti1 -> Snackbar.make(view, "Click Multi 1!", Snackbar.LENGTH_SHORT).show()
            R.id.buttonClickMulti2 -> Snackbar.make(view, "Click Multi 2!", Snackbar.LENGTH_SHORT).show()
            R.id.buttonClickMulti3 -> Snackbar.make(view, "Click Multi 3!", Snackbar.LENGTH_SHORT).show()
        }
        return true
    }

}
