package es.marcmauri.seccion_04_activities_permisos_list.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import es.marcmauri.seccion_04_activities_permisos_list.R
import es.marcmauri.seccion_04_activities_permisos_list.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_extension_functions.*

class ExtensionFunctionsActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_functions)

        toolbarToLoad(toolbar as Toolbar)
    }
}
