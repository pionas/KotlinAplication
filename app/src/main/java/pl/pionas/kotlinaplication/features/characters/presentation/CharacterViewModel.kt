package pl.pionas.kotlinaplication.features.characters.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import pl.pionas.kotlinaplication.core.base.BaseViewModel
import pl.pionas.kotlinaplication.features.characters.domain.GetCharactersUseCase
import pl.pionas.kotlinaplication.features.characters.domain.model.Character
import pl.pionas.kotlinaplication.features.characters.presentation.model.CharacterDisplayable

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
class CharacterViewModel(private val getCharactersUseCase: GetCharactersUseCase) : BaseViewModel() {
    private val _characters by lazy {
        MutableLiveData<List<Character>>()
            .also {
                getCharacters(it)
            }
    }

    val characters: LiveData<List<CharacterDisplayable>> by lazy {
        _characters.map { characters ->
            characters.map { CharacterDisplayable(it) }
        }
    }

    private fun getCharacters(characterLiveData: MutableLiveData<List<Character>>) {
        setPendingState()
        getCharactersUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { characterLiveData.value = it }
            result.onFailure {
                handleFailure(it)
            }
        }
    }
}