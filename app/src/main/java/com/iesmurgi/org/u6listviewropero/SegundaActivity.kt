package com.iesmurgi.org.u6listviewropero

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.segunda_activity)

        val mibundle = intent.extras
        var mensaje = mibundle?.getString("MENSAJE")?.toLowerCase()
        val textviewMensaje = findViewById<TextView>(R.id.textviewMensaje)
        mensaje = "Ha " + mensaje
        textviewMensaje.text = mensaje


        val btnVolver: Button = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener { onBackPressed() }
    }
}