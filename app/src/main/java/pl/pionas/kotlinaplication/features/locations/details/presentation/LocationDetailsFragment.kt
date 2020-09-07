package pl.pionas.kotlinaplication.features.locations.details.presentation

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_location_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.BR
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.databinding.FragmentLocationDetailsBinding

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
class LocationDetailsFragment :
    BaseFragment<LocationViewModel, FragmentLocationDetailsBinding>(
        BR.viewModel,
        R.layout.fragment_location_details
    ) {
    override val viewModel: LocationViewModel by viewModel()

    companion object {
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            viewModel.locationDisplayable = it.getParcelable(LOCATION_DETAILS_KEY)
        }
    }

    override fun initViews(binding: FragmentLocationDetailsBinding) {
        super.initViews(binding)
        showLocationDetails()
    }

    private fun showLocationDetails() {
        viewModel.locationDisplayable?.let {
            textViewLocationName.text = it.name
            textViewLocationUrl.text = it.url
        } ?: throw IllegalArgumentException("locationDetailsKey cannot be null")
    }

}