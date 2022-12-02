package mx.mauriciogs.fragments.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import mx.mauriciogs.fragments.R
import mx.mauriciogs.fragments.ReceiverFragment
import mx.mauriciogs.fragments.databinding.FragmentAnimesBinding
import mx.mauriciogs.fragments.model.Anime
import mx.mauriciogs.fragments.view.adapters.AnimesAdapter

class AnimesFragment : Fragment() {

    private var _binding: FragmentAnimesBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimesBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datos = ArrayList<Anime>()

        for (i in 1..10) {
            val animeTemp = Anime(i.toLong(),
                "Anime $i",
                "Tipo $i",
                "Fecha $i"
            )
            datos.add(animeTemp)
        }

        val adapter = AnimesAdapter(requireActivity(), datos)

        binding.lvAnimes.adapter = adapter

        binding.lvAnimes.setOnItemClickListener {
                parent, view, position, id ->
            Toast.makeText(requireContext(),
                "El item seleccionado tiene id: $id",
                Toast.LENGTH_LONG
            ).show()

            val bundle = Bundle()
            bundle.putString("titulo", datos[position].titulo)
            bundle.putString("tipo", datos[position].tipo)
            bundle.putString("fecha", datos[position].fecha)

            parentFragmentManager.setFragmentResult("requestAnimeResult", bundle)

            val receiver = ReceiverFragment()
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.flFragmentContainer, receiver)
                .commit()
        }
    }
}