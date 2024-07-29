package com.app.convertrrealfordolarstateu

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.convertrrealfordolarstateu.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConvert.setOnClickListener {
            if (verifyCampos()){
                var resu = converterReal(binding.valor?.text.toString().toFloat())
                val formattedResu = DecimalFormat("#.##").format(resu)
                binding.telaResultado.visibility = View.VISIBLE
                binding.resultadoConversao.text = "O valor de Real para Dolar ${formattedResu.toString()}"
                clearFields()
            }
        }

    }

    private fun clearFields() {
        binding.valor!!.text.clear()
    }

    private fun converterReal(real: Float): Double {
        val dolar = real *  0.18
        return dolar
    }

    private fun verifyCampos():Boolean{
        var veri = if (binding.valor!!.text.isBlank()){
            Toast.makeText(this,
                "digite um valor",
                Toast.LENGTH_SHORT).show()
            false
        }else{
            true
        }
        return veri
    }


}

