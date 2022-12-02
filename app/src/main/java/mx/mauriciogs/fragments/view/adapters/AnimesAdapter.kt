package mx.mauriciogs.fragments.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import mx.mauriciogs.fragments.databinding.AnimesElementBinding
import mx.mauriciogs.fragments.model.Anime
import mx.mauriciogs.fragments.model.Game

class AnimesAdapter(
    private val context: Context,
    val datos: ArrayList<Anime>
): BaseAdapter() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int = datos.size

    override fun getItem(position: Int) = datos[position]

    override fun getItemId(position: Int) = datos[position].id

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding = AnimesElementBinding.inflate(layoutInflater)

        with(binding) {
            tvTitulo.text = datos[position].titulo
            tvTipo.text = getItem(position).tipo
            tvFecha.text = getItem(position).fecha
        }

        return binding.root
    }
}