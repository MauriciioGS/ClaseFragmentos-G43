package mx.mauriciogs.fragments.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import mx.mauriciogs.fragments.databinding.GamesElementBinding
import mx.mauriciogs.fragments.model.Game
import mx.mauriciogs.fragments.view.fragments.AnimesFragment
import mx.mauriciogs.fragments.view.fragments.GamesFragment

class GamesAdapter(
    private val context: Context,
    private val fragment: Fragment,
    private val games: ArrayList<Game>
) : RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    inner class ViewHolder(view: GamesElementBinding): RecyclerView.ViewHolder(view.root) {
        val tvTitle = view.tvTitle
        val tvGenre = view.tvGenre
        val tvDeveloper = view.tvDeveloper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GamesElementBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = games[position]

        with(holder){
            tvTitle.text = item.title
            tvGenre.text = item.genre
            tvDeveloper.text = item.developer
        }

        // Para manejar los clicks a cada item tipo viewholder:
        holder.itemView.setOnClickListener {
            if (fragment is GamesFragment) fragment.onClickItem(item)
        }
    }

    override fun getItemCount(): Int = games.size

}