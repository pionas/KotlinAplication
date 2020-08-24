package pl.pionas.kotlinaplication.features.characters.presentation

import androidx.lifecycle.observe
import org.koin.androidx.viewmodel.ext.android.viewModel

import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        // initialize all view-related classes
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun onIdleStatus() {
        super.onIdleStatus()
        // handle idle state here
    }

    override fun onPendingState() {
        super.onPendingState()
        // handle pending state here
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {

        }
    }

}
