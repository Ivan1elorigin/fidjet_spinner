package com.example.fidjet_spinner
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val et1=findViewById<EditText>(R.id.et1)
        val et2=findViewById<EditText>(R.id.et2)
        val tv1=findViewById<TextView>(R.id.tv1)
        val button=findViewById<Button>(R.id.button)
        val spinner=findViewById<Spinner>(R.id.spinner)
        val lista = arrayOf("sumar", "restar", "multiplicar",
            "dividir", "potencia", "factorial", "raiz_cuadrada")
        val adaptador1 = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, lista)
        spinner.adapter = adaptador1
        button.setOnClickListener {
            when (spinner.selectedItem.toString()) {
                "sumar" -> tv1.text = "Resultado: ${et1.text.toString().toInt() + et2.text.toString().toInt()}"
                "restar" -> tv1.text = "Resultado: ${et1.text.toString().toInt() - et2.text.toString().toInt()}"
                "multiplicar" -> tv1.text = "Resultado: ${et1.text.toString().toInt() * et2.text.toString().toInt()}"
                "dividir" -> tv1.text = "Resultado: ${et1.text.toString().toInt() / et2.text.toString().toInt()}"
                "potencia" -> tv1.text = "Resultado: ${Math.pow(et1.text.toString().toDouble(), et2.text.toString().toDouble())}"
                "factorial" -> tv1.text = "Resultado: ${factorialIterativo(et1.text.toString().toInt())}"
                "raiz_cuadrada" -> tv1.text = "Resultado: ${Math.sqrt(et1.text.toString().toDouble())}"

            }
        }
    }

    fun factorialIterativo(n: Int): Int {
        var factorial = 1
        for (i in 1..n) {
            factorial *= i
        }
        return factorial
    }
}