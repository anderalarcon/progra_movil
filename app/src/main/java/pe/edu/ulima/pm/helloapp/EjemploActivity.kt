package pe.edu.ulima.pm.helloapp

import android.app.Activity
import android.os.Bundle

class EjemploActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo) //Seteamos layaou con clase activity
    //Tenemos que decirle que se va ejectuar para que muestre la pantalla en el manifest


    }
}