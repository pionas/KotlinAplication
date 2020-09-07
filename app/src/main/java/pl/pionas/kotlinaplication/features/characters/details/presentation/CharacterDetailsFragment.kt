package pl.pionas.kotlinaplication.features.characters.details.presentation

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_character_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.BR
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.databinding.FragmentCharacterDetailsBinding

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
class CharacterDetailsFragment :
    BaseFragment<CharacterViewModel, FragmentCharacterDetailsBinding>(
        BR.viewModel,
        R.layout.fragment_character_details
    ) {
    override val viewModel: CharacterViewModel by viewModel()

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            viewModel.characterDisplayable = it.getParcelable(CHARACTER_DETAILS_KEY)
        }
    }

    override fun initViews(binding: FragmentCharacterDetailsBinding) {
        super.initViews(binding)
        showCharacterDetails()
    }

    private fun showCharacterDetails() {
        viewModel.characterDisplayable?.let {
            textViewCharacterName.text = it.name
            textViewCharacterStatus.text = it.status
            textViewCharacterSpecies.text = it.species
        } ?: throw IllegalArgumentException("characterDetailsKey cannot be null")
    }

}