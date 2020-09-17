package pl.pionas.kotlinaplication.features.users.details.presentation

import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_user_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.BR
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.databinding.FragmentUserDetailsBinding

class UserDetailsFragment :
    BaseFragment<UserViewModel, FragmentUserDetailsBinding>(
        BR.viewModel,
        R.layout.fragment_user_details
    ) {
    override val viewModel: UserViewModel by viewModel()

    companion object {
        const val USER_DETAILS_KEY = "userDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            viewModel.userDisplayable = it.getParcelable(USER_DETAILS_KEY)
        }
    }

    override fun initViews(binding: FragmentUserDetailsBinding) {
        super.initViews(binding)
        showUserDetails()
    }

    private fun showUserDetails() {
        viewModel.userDisplayable?.let {
            textViewUserName.text = it.name
            Glide.with(imageViewUserAvatar).load(it.avatar)
            Glide
                .with(this)
                .load(it.avatar)
                .centerCrop()
                .placeholder(R.drawable.ic_cloud_download)
                .into(imageViewUserAvatar)
        } ?: throw IllegalArgumentException("userDetailsKey cannot be null")
    }

}