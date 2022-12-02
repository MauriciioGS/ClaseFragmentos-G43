package mx.mauriciogs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.mauriciogs.fragments.databinding.FragmentReceiverBinding
import mx.mauriciogs.fragments.model.Anime
import mx.mauriciogs.fragments.model.Game

class ReceiverFragment : Fragment() {

    private var _binding: FragmentReceiverBinding? = null
    private val binding get() = _binding!!

    private lateinit var game: Game
    private lateinit var anime: Anime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parentFragmentManager.setFragmentResultListener(
            "requestGameResult",
            this
        ) { requestKey, bundle ->
            when(requestKey) {
                "requestGameResult" -> {
                    val title = bundle.getString("title", "")
                    val genre = bundle.getString("genre")
                    val dev = bundle.getString("developer")

                    if (title != null && genre != null && dev != null){
                        game = Game(
                            100,
                            title,
                            genre,
                            dev
                        )
                    }
                    setUIGame()
                }
            }
        }

        parentFragmentManager.setFragmentResultListener(
            "requestAnimeResult",
            this
        ) {  requestKey, bundle ->
            anime = Anime(
                100,
                bundle.getString("titulo", ""),
                bundle.getString("tipo", ""),
                bundle.getString("fecha", "")
            )
            setUIAnime()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReceiverBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setUIGame() {
        with(binding){
            textView.text = game.title
            textView2.text = game.genre
            textView3.text = game.developer
        }
    }

    private fun setUIAnime() {
        with(binding) {
            textView.text = anime.titulo
            textView2.text = anime.tipo
            textView3.text = anime.fecha
        }
    }

}