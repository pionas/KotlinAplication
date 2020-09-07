package pl.pionas.kotlinaplication.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.pionas.kotlinaplication.core.adapter.BindableAdapter
import pl.pionas.kotlinaplication.core.base.BaseAdapter
import pl.pionas.kotlinaplication.databinding.CharacterItemBinding
import pl.pionas.kotlinaplication.features.characters.all.presentation.model.CharacterDisplayable

/**
 * Created by Adrian Pionka on 25 sierpień 2020
 * adrian@pionka.com
 */
class CharactersAdapter(private val charactersViewModel: CharactersViewModel) :
    BindableAdapter<CharacterDisplayable>,
    BaseAdapter<CharacterDisplayable>() {

    constructor(charactersViewModel: CharactersViewModel, list: List<CharacterDisplayable>) : this(
        charactersViewModel
    ) {
        super.setItems(list)
    }

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharacterItemBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding, charactersViewModel)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val movie: CharacterDisplayable = items[position]
        (holder as CharacterViewHolder).bind(movie)
    }

    class CharacterViewHolder(
        private val binding: CharacterItemBinding,
        private val charactersViewModel: CharactersViewModel
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharacterDisplayable) {
            with(binding) {
                binding.item = character
                charactersViewModel.let { characterViewModel ->
                    root.setOnClickListener {
                        characterViewModel.onCharacterClick(character)
                    }
                }
                binding.executePendingBindings()
            }
        }
    }

}