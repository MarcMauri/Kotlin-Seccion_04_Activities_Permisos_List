package es.marcmauri.seccion_04_activities_permisos_list.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import es.marcmauri.seccion_04_activities_permisos_list.MainActivity
import es.marcmauri.seccion_04_activities_permisos_list.R
import es.marcmauri.seccion_04_activities_permisos_list.others.*
import kotlinx.android.synthetic.main.activity_extension_functions.*

class ExtensionFunctionsActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_functions)

        toolbarToLoad(toolbar as Toolbar)

        buttonToast.setOnClickListener { toast("I love extension functions!") }
        buttonSnackBar.setOnClickListener { snackBar("I love extension functions", action = "Undo") { toast("Undo!!")} }
        buttonLoadByUrl.setOnClickListener { imageViewLoadedByUrl.loadByUrl("https://udemy-images.udemy.com/course/480x270/1325930_f5f6_3.jpg") }
        buttonGoToActivity.setOnClickListener { goToActivity<MainActivity>() }
    }
}
