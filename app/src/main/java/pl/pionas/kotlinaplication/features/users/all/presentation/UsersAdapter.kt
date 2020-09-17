package pl.pionas.kotlinaplication.features.users.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.pionas.kotlinaplication.core.adapter.BindableAdapter
import pl.pionas.kotlinaplication.core.base.BaseAdapter
import pl.pionas.kotlinaplication.databinding.UserItemBinding
import pl.pionas.kotlinaplication.features.users.all.presentation.model.UserDisplayable

/**
 * Created by Adrian Pionka on 25 sierpień 2020
 * adrian@pionka.com
 */
class UsersAdapter(private val usersViewModel: UsersViewModel) :
    BindableAdapter<UserDisplayable>,
    BaseAdapter<UserDisplayable>() {

    constructor(usersViewModel: UsersViewModel, list: List<UserDisplayable>) : this(
        usersViewModel
    ) {
        super.setItems(list)
    }

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding, usersViewModel)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val movie: UserDisplayable = items[position]
        (holder as UserViewHolder).bind(movie)
    }

    class UserViewHolder(
        private val binding: UserItemBinding,
        private val usersViewModel: UsersViewModel
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserDisplayable) {
            with(binding) {
                binding.item = user
                usersViewModel.let { userViewModel ->
                    root.setOnClickListener {
                        userViewModel.onUserClick(user)
                    }
                }
                binding.executePendingBindings()
            }
        }

    }

}