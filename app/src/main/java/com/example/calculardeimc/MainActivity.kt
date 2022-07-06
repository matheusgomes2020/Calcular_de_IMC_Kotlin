package com.example.calculardeimc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun validarCampos( view: View ){

        val altura: String = editTextAltura.text.toString()
        val peso: String = editTextPeso.text.toString()

        if ( !altura.isEmpty() ){
            if ( !peso.isEmpty() ){

                val intent = Intent( this, ResultadoActivity::class.java ).apply {
                    putExtra( "peso", peso )
                    putExtra( "altura", altura )
                }

                startActivity( intent )

            } else {
                Toast.makeText(this, "Digite o seu peso!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Digite a sua altura!", Toast.LENGTH_SHORT).show()
        }


    }

}