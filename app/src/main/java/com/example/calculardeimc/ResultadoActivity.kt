package com.example.calculardeimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)


        val bundle = intent.extras

        if (bundle != null) {

            val peso = bundle["peso"].toString()
            val altura = bundle["altura"].toString()

            textRPeso.text = "Peso Informado:$peso kg"
            textRAltura.text = "Altura Informada:$altura m"

            val imc =
                java.lang.Double.valueOf(peso) / (java.lang.Double.valueOf(altura) * java.lang.Double.valueOf(
                    altura
                ))
            val imc2 = String.format("%.2f", imc)

            textRImc.text = imc2

            var resultado = ""

            if (imc > 0 && imc < 18.5) {
                resultado = "Magreza"
                textDiagnostico.setTextColor(resources.getColor(R.color.azulclaro))
            } else if (imc >= 18.5 && imc < 25) {
                resultado = "Normal"
                textDiagnostico.setTextColor(resources.getColor(R.color.azul))
            } else if (imc >= 25 && imc < 30) {
                resultado = "Sobrepeso"
                textDiagnostico.setTextColor(resources.getColor(R.color.amarelo))
            } else if (imc > 30 && imc < 40) {
                resultado = "Obesidade"
                textDiagnostico.setTextColor(resources.getColor(R.color.laranja))
            } else if (imc > 40) {
                resultado = "Obesidade grave"
                textDiagnostico.setTextColor(resources.getColor(R.color.vermelho))
            }

            textDiagnostico.text = resultado

    }
}
}