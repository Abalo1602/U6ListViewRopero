package com.iesmurgi.org.u6listviewropero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private lateinit var adapter:AdapterRopero
    private var data = ArrayList<Ropa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listviewRopero : ListView = findViewById(R.id.listviewRopa)
        supportActionBar?.title="U6_ListViewRopero"
        cargarDatos()
        adapter = AdapterRopero(this, data)
        listviewRopero.adapter=adapter
        listviewRopero.setOnItemClickListener(this)

        val texto: TextView = findViewById(R.id.text)
        registerForContextMenu(texto)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.menu_contextual, menu)
        menu.setHeaderTitle("Menu contextual")
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        var nombrePrenda=view!!.findViewById<TextView>(R.id.tvRopa).text
        val auxiliar= Intent(this,SegundaActivity::class.java)
        val mensaje:String

        var checked = (view.findViewById<RadioGroup>(R.id.rgTallas) as RadioGroup).checkedRadioButtonId

        when (checked){
            R.id.rbTallaS->{
                mensaje ="elegido "+nombrePrenda+" pequeña."
                auxiliar.putExtra("MENSAJE",mensaje)
                startActivity(auxiliar)
            }

            R.id.rbTallaM->{
                mensaje ="elegido "+nombrePrenda+" mediana."
                auxiliar.putExtra("MENSAJE",mensaje)
                startActivity(auxiliar)
            }

            R.id.rbTallaL-> {
                mensaje ="elegido " + nombrePrenda + " grande."
                auxiliar.putExtra("MENSAJE", mensaje)
                startActivity(auxiliar)
            }

            R.id.rbTallaXL-> {
                mensaje ="elegido " + nombrePrenda + " extra grande."
                auxiliar.putExtra("MENSAJE", mensaje)
                startActivity(auxiliar)
            }
            else->{
                Toast.makeText(
                    this.applicationContext,
                    "Seleccione talla.",
                    Toast.LENGTH_LONG).show()}
        }
    }

    fun cargarDatos() {

            data.add(Ropa("Calcetin rojo", R.drawable.calcetin, "Para los pies"))
            data.add(Ropa("Calcetin gris",R.drawable.calcetin1, "Para los pies"))
            data.add(Ropa("Calcetin dibujo",R.drawable.calcetin2, "Para los pies"))
            data.add(Ropa("Calcetin azul",R.drawable.calcetin3, "Para los pies"))
            data.add(Ropa("Calcetin multicolor",R.drawable.calcetin4, "Para los pies"))

            data.add(Ropa("Camiseta amarilla", R.drawable.camiseta, "Con dibujo"))
            data.add(Ropa("Camiseta cielo", R.drawable.camiseta2, "Con dibujo"))
            data.add(Ropa("Camiseta azul", R.drawable.camiseta3, "Con dibujo"))
            data.add(Ropa("Camiseta rosa", R.drawable.camiseta4, "Con dibujo"))

            data.add(Ropa("Gorra beige", R.drawable.gorra, "Para tapar el pelo"))
            data.add(Ropa("Gorra naranja", R.drawable.gorra1, "Para tapar el pelo"))
            data.add(Ropa("Gorra roja", R.drawable.gorra2, "Para tapar el pelo"))

            data.add(Ropa("Legging azul", R.drawable.legging, "Muuu bonitos"))
            data.add(Ropa("Legging negro", R.drawable.legging1, "Muuu bonitos"))

            data.add(Ropa("Pantalon gris", R.drawable.pantalon, "Too facherito"))
            data.add(Ropa("Pantalon amarillo", R.drawable.pantalon1, "Too facherito"))
            data.add(Ropa("Pantalon azul", R.drawable.pantalon2, "Too facherito"))

            data.add(Ropa("Sudadera roja", R.drawable.sudadera, "Con capucha"))
            data.add(Ropa("Sudadera blanca", R.drawable.sudadera1, "Con capucha"))
            data.add(Ropa("Sudadera verde", R.drawable.sudadera2, "Con capucha"))
            data.add(Ropa("Sudadera azul", R.drawable.sudadera3, "Con capucha"))

            data.add(Ropa("Vestido verde", R.drawable.vestido, "Palabra de honor con vuelo"))
            data.add(Ropa("Vestido rosa oscuro", R.drawable.vestido1, "Palabra de honor con vuelo"))
            data.add(Ropa("Vestido rosa claro", R.drawable.vestido2, "Palabra de honor con vuelo"))

    }
}