package pe.edu.ulima.pm.helloapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var eteUsuario: EditText? = null
    var etePassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        eteUsuario = findViewById(R.id.eteUsuario)
        etePassword = findViewById(R.id.etePassword)
        val btn: Button = findViewById(R.id.butLogin)

        /* btn.setOnClickListener(this)*/

        //Tiene como argumento de entrada un lambda
        btn.setOnClickListener { v: View ->
            val usuario = eteUsuario!!.text.toString()
            var password = etePassword!!.text.toString()
            if (usuario == "pm" && password == "123") {
                Toast.makeText(this, "Login Correcto", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "login incorrecto", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClick(p0: View?) {
        Log.i("MainActivity", "Se hizo click")

        val usuario = eteUsuario!!.text.toString()
        var password = etePassword!!.text.toString()
        if (usuario == "pm" && password == "123") {
            Toast.makeText(this, "Login Correcto", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "login incorrecto", Toast.LENGTH_SHORT).show()
        }
    }

//Pasar poder hacer uso de eventos listernet tenemos que setear  la clase con view y arreglar los errores imporando member
/*    val etepassword2=findViewById<EditText>(R.id.etePassword)*/

}