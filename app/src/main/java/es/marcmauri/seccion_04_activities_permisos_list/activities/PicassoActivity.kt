package es.marcmauri.seccion_04_activities_permisos_list.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import es.marcmauri.seccion_04_activities_permisos_list.R
import es.marcmauri.seccion_04_activities_permisos_list.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_picasso.*
import java.lang.Exception

class PicassoActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)

        toolbarToLoad(toolbar as Toolbar)

        buttonLoader.setOnClickListener { loadImages() }

        // Este metodo pre-cachea la imagen
        Picasso.get()
                .load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg")
                .fetch()
    }

    private fun loadImages() {
        Picasso.get()
                .load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg")
                .resize(400, 400)
                .centerInside()
                .into(imageViewTop)

//      Picasso.get()
//              .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
//              .fit()
//              .into(imageViewBottom)

//      Picasso.get()
//              .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
//              .fit()
//              .transform(CircleTransform()) // Renderizar la imagen como un circulo
//              .into(imageViewBottom)

        Picasso.get()
                .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                .fetch(object : Callback {
                    override fun onSuccess() {
                        imageViewBottom.alpha = 0f // Marcamos el imageView como transparente

                        Picasso.get()
                                .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                                .fit()
                                .into(imageViewBottom)

                        // Iniciamos la animacion del imageView de transparente a solido en 1300ms
                        imageViewBottom.animate().setDuration(1300).alpha(1f).start()
                    }

                    override fun onError(e: Exception?) {}
                })
    }
}
