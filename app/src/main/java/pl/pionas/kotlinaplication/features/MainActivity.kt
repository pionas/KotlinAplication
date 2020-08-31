package pl.pionas.kotlinaplication.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.features.characters.presentation.CharacterFragment
import pl.pionas.kotlinaplication.features.episodes.presentation.EpisodeFragment
import pl.pionas.kotlinaplication.features.locations.presentation.LocationFragment
import pl.pionas.kotlinaplication.features.users.login.presentation.LoginFragment

class MainActivity : AppCompatActivity() {

    private val episodeFragment: EpisodeFragment by inject()
    private val characterFragment: CharacterFragment by inject()
    private val locationFragment: LocationFragment by inject()
    private val loginFragment: LoginFragment by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.mainLayout, loginFragment).commit()
    }
}
