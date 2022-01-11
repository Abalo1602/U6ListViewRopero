package com.iesmurgi.org.u6listviewropero

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdapterRopero(val context: Context, var data:List<Ropa>): BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Ropa {
        return data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vh: ViewHolder
        val view: View

        if(convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.esqueleto_ropero,parent,false)
            vh=ViewHolder(view)
            view.tag=vh
        }else{
            view=convertView
            vh=view.tag as ViewHolder
        }

        //Entrada de datos
        val prenda=getItem(position)

        if(prenda!=null){
            vh.holderTextViewRopa.text=prenda.nombre
            vh.holderImageViewRopa.setImageResource(prenda.imagen)
        }


        return view
    }

    //Inner class, puede acceder a todos los miembros de la clase que la contiene.
    inner class ViewHolder(v: View){
        val holderTextViewRopa: TextView =v.findViewById(R.id.tvRopa)
        val holderImageViewRopa: ImageView =v.findViewById(R.id.iv_imagen)
    }
}