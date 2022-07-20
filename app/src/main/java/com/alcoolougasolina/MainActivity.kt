package com.alcoolougasolina

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    var valorGasolina = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Carregar os componentes
        // O método findViewById busca componentes da view
        val seekbar = findViewById<SeekBar>(R.id.seekBar)
        val txtGasolina = findViewById<TextView>(R.id.txtValorGasolina)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btn = findViewById<Button>(R.id.btnCalcular)

        // Tamanho da seekbar
        seekbar.max = 1000

        // Listener p/ seekbar
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                var valorGasolina = p1
                var texto = "R$"
                texto += formataValor (valorGasolina/100.0)
                txtGasolina.text = texto
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                txtResultado.text = "Selecione o valor da Gasolina"
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                txtResultado.text = "Clique em calcular para saber o Resultado"
            }

        })

        /// Listener do botão CALCULAR
        btn.setOnClickListener {
            var valorResultado = (valorGasolina * 0.7)/100.0
            var texto = "Abasteça com Alcool se ele custar até R$: "
            texto += formataValor(valorResultado)
            txtResultado.text = texto
        }
    }

    private fun formataValor(valor: Double): String {
        Log.i("log format",String.format(Locale.FRANCE, format = "%.2f",valor))
        return String.format(Locale.FRANCE, format = "%.2f",valor)

    }

}