package mx.mauriciogs.fragments.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import mx.mauriciogs.fragments.R
import mx.mauriciogs.fragments.ReceiverFragment
import mx.mauriciogs.fragments.databinding.FragmentGamesBinding
import mx.mauriciogs.fragments.model.Game
import mx.mauriciogs.fragments.view.adapters.GamesAdapter

class GamesFragment : Fragment() {

    private var _binding: FragmentGamesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        binding.rvGames.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvGames.adapter = GamesAdapter(
            requireActivity(),
            this@GamesFragment,
            games
        )
    }

    fun onClickItem(item: Game) {
        Toast.makeText(requireActivity(), "Juego seleccionado: ${item.title}", Toast.LENGTH_LONG)
            .show()

        val bundle = Bundle()
        bundle.putString("title", item.title)
        bundle.putString("genre", item.genre)
        bundle.putString("developer", item.developer)

        parentFragmentManager.setFragmentResult("requestGameResult", bundle)

        val receiver = ReceiverFragment()
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.flFragmentContainer, receiver)
            .commit()
    }

    companion object {
        val games = arrayListOf(
            Game(1, "Leage of Legends", "MOBA", "Riot Games"),
            Game(2, "Mario Cart", "Aventura", "Nintendo"),
            Game(3, "Fifa 22", "Deportes", "EA"),
            Game(4, "Watch Dogs", "Mundo abierto", "Ubisoft"),
            Game(5, "God of War", "Violencia|Aventura", "Activision"),
            Game(6, "Call of Duty", "Shooter", "Activision")
        )
    }

}