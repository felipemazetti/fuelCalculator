package com.felipemazetti.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

const val KEY_CONSUMO = "KEY_DESTINO_CONSUMO"

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtCombustivelFl = intent.getFloatExtra(KEY_COMBUSTIVEL, 0.0f)

        val btnConsumo = findViewById<Button>(R.id.btn_consumo)
        btnConsumo.setOnClickListener{
            val edtConsumoInput = findViewById<TextInputEditText>(R.id.edt_consumo)
            val edtConsumo = edtConsumoInput.text.toString()

            if (edtConsumo.isEmpty()){
                edtConsumoInput.error = "Digite um valor"
            }else {
                val edtConsumoFl = edtConsumo.toFloat()


                val intent = Intent(this, DistanciaActivity::class.java)
                intent.putExtra(KEY_COMBUSTIVEL, edtCombustivelFl)
                intent.putExtra(KEY_CONSUMO, edtConsumoFl)
                startActivity(intent)
            }
        }

    }
}