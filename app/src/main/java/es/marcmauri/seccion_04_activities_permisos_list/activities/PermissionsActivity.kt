package es.marcmauri.seccion_04_activities_permisos_list.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast
import es.marcmauri.seccion_04_activities_permisos_list.R
import es.marcmauri.seccion_04_activities_permisos_list.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_permissions.*

class PermissionsActivity : ToolbarActivity() {

    private val requestCameraPermission = 100
    private val requestCameraPicture = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)

        buttonPicture.setOnClickListener { getPictureFromCameraAskingPermissions() }
    }

    private fun getPictureFromCameraAskingPermissions() {
        // 1. Anadir permiso al manifest
        // 2. Comprobar el permiso de la camara
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Si no fue aceptado (Para versiones de 6.0 [API 23] en adelante)
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), requestCameraPermission)
        } else {
            // Si fue aceptado... (o version anterior a 6.0 [API 23])
            goToCamera()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            requestCameraPermission -> {
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permiso aceptado
                    goToCamera()
                } else {
                    // Permiso denegado
                    Toast.makeText(this, "You can't take a picture if you don't allow it", Toast.LENGTH_SHORT).show()
                }
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    private fun goToCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, requestCameraPicture)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode) {
            requestCameraPicture -> {
                // Comprobar si el resultado es bueno
                if (resultCode == Activity.RESULT_OK) {
                    // Obtenemos los extras del intent recibido por parametros
                    val extras = data!!.extras
                    // Formamos el Bitmap a partir de los extras
                    val imageBitmap = extras.get("data") as Bitmap // la docu dice que la key es 'data'
                    // Cargamos la foto como Bitmap en el imageView
                    imageViewPicture.setImageBitmap(imageBitmap)
                } else {
                    // La foto no ha sido tomada con exito
                    Toast.makeText(this, "Picture has failed", Toast.LENGTH_SHORT).show()
                }
            }
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
