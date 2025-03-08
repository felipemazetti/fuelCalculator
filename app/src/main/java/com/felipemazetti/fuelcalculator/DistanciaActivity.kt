package com.felipemazetti.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

const val KEY_DISTANCIA = "KEY_DISTANCIA"
class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtCombustivelFl = intent.getFloatExtra(KEY_COMBUSTIVEL, 0.0f)
        val edtConsumoFl = intent.getFloatExtra(KEY_CONSUMO, 0.0f)

        val btnResultado = findViewById<Button>(R.id.btn_resultado)
        btnResultado.setOnClickListener {
            val edtDistanciaInput = findViewById<TextInputEditText>(R.id.edt_distancia)
            val edtDistancia = edtDistanciaInput.text.toString()

            if (edtDistancia.isEmpty()){
                edtDistanciaInput.error = "Digite um valor"

            }else{
                val edtDistanciaFl = edtDistancia.toFloat()

                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra(KEY_COMBUSTIVEL, edtCombustivelFl)
                intent.putExtra(KEY_CONSUMO, edtConsumoFl)
                intent.putExtra(KEY_DISTANCIA, edtDistanciaFl )
                startActivity(intent)
            }
        }

    }
}