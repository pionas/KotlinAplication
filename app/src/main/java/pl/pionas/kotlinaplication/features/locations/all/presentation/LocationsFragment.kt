package pl.pionas.kotlinaplication.features.locations.all.presentation

import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_location.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.features.locations.all.presentation.model.LocationDisplayable

class LocationsFragment : BaseFragment<LocationsViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationsViewModel by viewModel()

    private val linearLayoutManager: LinearLayoutManager by inject()
    private val divider: DividerItemDecoration by inject()
    private val locationAdapter: LocationsAdapter by inject()

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    private fun initRecycler() {
        with(recyclerView) {
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = locationAdapter
        }
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    override fun onIdleStatus() {
        super.onIdleStatus()
        progressBarLoading.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    override fun onPendingState() {
        super.onPendingState()
        progressBarLoading.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        with(recyclerView) {
            layoutManager = null
            adapter = null
        }
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            setLocations(it)
        }
    }

    private fun setLocations(locations: List<LocationDisplayable>) {
        locationAdapter.setItems(locations)
    }

}
