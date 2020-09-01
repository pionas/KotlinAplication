package pl.pionas.kotlinaplication.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseAdapter
import pl.pionas.kotlinaplication.features.characters.all.presentation.model.CharacterDisplayable

/**
 * Created by Adrian Pionka on 25 sierpień 2020
 * adrian@pionka.com
 */
class CharactersAdapter(private val charactersViewModel: CharactersViewModel) :
    BaseAdapter<CharacterDisplayable>() {

    constructor(charactersViewModel: CharactersViewModel, list: List<CharacterDisplayable>) : this(
        charactersViewModel
    ) {
        super.setItems(list)
    }

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(inflater, parent, charactersViewModel)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val movie: CharacterDisplayable = items[position]
        (holder as CharacterViewHolder).bind(movie)
    }

    class CharacterViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        charactersViewModel: CharactersViewModel
    ) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.character_item, parent, false)) {
        private var mCharacterView: TextView? = null
        private var mCharactersViewModel: CharactersViewModel


        init {
            mCharacterView = itemView.findViewById(R.id.character_name)
            mCharactersViewModel = charactersViewModel
        }

        fun bind(character: CharacterDisplayable) {
            mCharacterView?.text = character.name
            mCharacterView?.setOnClickListener {
                mCharactersViewModel.onCharacterClick(character)
            }
        }
    }

}