package pl.pionas.kotlinaplication.features.characters.details.presentation

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_character_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.features.characters.all.presentation.model.CharacterDisplayable

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
class CharacterDetailsFragment :
    BaseFragment<CharacterViewModel>(R.layout.fragment_character_details) {
    private var mCharacterDisplayable: CharacterDisplayable? = null
    override val viewModel: CharacterViewModel by viewModel()

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mCharacterDisplayable = it.getParcelable(CHARACTER_DETAILS_KEY)
        }
    }

    override fun initViews() {
        super.initViews()
        showCharacterDetails()
    }

    private fun showCharacterDetails() {
        mCharacterDisplayable?.let {
            textViewCharacterName.text = it.name
            textViewCharacterStatus.text = it.status
            textViewCharacterSpecies.text = it.species
        } ?: throw IllegalArgumentException("characterDetailsKey cannot be null")
    }

}