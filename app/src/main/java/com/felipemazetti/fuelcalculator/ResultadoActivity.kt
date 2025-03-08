package com.felipemazetti.fuelcalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat
import java.util.Currency
import java.util.Locale

class ResultadoActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val edtCombustivel = intent.getFloatExtra(KEY_COMBUSTIVEL, 0.0f)
        val edtConsumo = intent.getFloatExtra(KEY_CONSUMO, 0.0f)
        val edtDistancia = intent.getFloatExtra(KEY_DISTANCIA, 0.0f)

        val custoTotal = (edtDistancia / edtConsumo) * edtCombustivel
        val custoTotalSt = custoTotal.toString()

        val tvResultado = findViewById<TextView>(R.id.tv_resultado)
        tvResultado.text = ConvertToBrl(custoTotalSt)

        val tvPreco = findViewById<TextView>(R.id.tv_preco)
        val edtCombustivelSt = edtCombustivel.toString()
        tvPreco.text = "Preço: $edtCombustivelSt"

        val tvConsumo = findViewById<TextView>(R.id.tv_consumo)
        val edtConsumoSt = edtConsumo.toString()
        tvConsumo.text = "Consumo: $edtConsumoSt km/l"

        val tvKm = findViewById<TextView>(R.id.tv_km)
        val edtDistanciaSt = edtDistancia.toString()
        tvKm.text = "Km: $edtDistanciaSt "

        val btnNovoCalculo = findViewById<Button>(R.id.btn_novo_calculo)

        btnNovoCalculo.setOnClickListener {
            val intent = Intent(this, CombustivelActivity::class.java)
            startActivity(intent)
        }

    }

    fun ConvertToBrl(value: String): String{
        val format = DecimalFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))
        val valueDouble = value.toDouble()
        return format.format(valueDouble)

    }
}