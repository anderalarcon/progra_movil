package pe.edu.ulima.pm.helloapp

import android.app.Activity
import android.os.Bundle
import android.util.Log
import pe.edu.ulima.pm.helloapp.Views.OnFaceClickcListener
import pe.edu.ulima.pm.helloapp.Views.UlFaceView

class EjemploActivity : Activity(), OnFaceClickcListener {
    var faceView: UlFaceView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo) //Seteamos layaou con clase activity
        //Tenemos que decirle que se va ejectuar para que muestre la pantalla en el manifest


        faceView = findViewById<UlFaceView>(R.id.cara)
        faceView?.setOnFaceListener(this)

    }


    override fun OnClick() {//si esque algunos de los 2 es nulo no se ejecuta
        //cada vez que damos click en el view se va ir incrementando el tamaño de la boca
        faceView?.moutHeight=faceView?.moutHeight?.plus(100)!!;
    }
}