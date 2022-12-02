package mx.mauriciogs.fragments.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import mx.mauriciogs.fragments.R
import mx.mauriciogs.fragments.databinding.ActivityMainBinding
import mx.mauriciogs.fragments.view.fragments.AnimesFragment
import mx.mauriciogs.fragments.view.fragments.GamesFragment
import mx.mauriciogs.fragments.view.fragments.InitialFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var initialFragment: InitialFragment
    private lateinit var animesFragment: AnimesFragment
    private lateinit var gamesFragment: GamesFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setInitialFrag()
        animesFragment = AnimesFragment()
        gamesFragment = GamesFragment()
    }

    private fun setInitialFrag() {
        initialFragment = InitialFragment()
        supportFragmentManager
            .beginTransaction()
            .add(binding.flFragmentContainer.id, initialFragment)
            .commit()
    }

    fun click(view: View) {
        val transaction = supportFragmentManager.beginTransaction()
        when(view.id) {
            binding.btnAnimes.id -> {
                transaction
                    .replace(
                        binding.flFragmentContainer.id,
                        animesFragment
                    ).commit()
            }
            binding.btnGames.id -> {
                transaction
                    .replace(
                        binding.flFragmentContainer.id,
                        gamesFragment
                    ).commit()
            }
        }
    }
}