package com.felipemazetti.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_COMBUSTIVEL = "KEY_COMBUSTIVEL"

class CombustivelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_combustivel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCombustivel = findViewById<Button>(R.id.btn_combustivel)
        btnCombustivel.setOnClickListener {



            val edtCombustivelInput = findViewById<TextInputEditText>(R.id.edt_combustivel)
            val edtCombustivel = edtCombustivelInput.text.toString()

            if (edtCombustivel.isEmpty()){
                edtCombustivelInput.error = "Digite um valor"

            }else{
                val edtCombustivelFl = edtCombustivel.toFloat()
                val intent = Intent(this, ConsumoActivity::class.java)
                intent.putExtra(KEY_COMBUSTIVEL, edtCombustivelFl)
                startActivity(intent)
            }

        }


    }
}