package pl.pionas.kotlinaplication.features.locations.presentation

import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_location.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.features.locations.presentation.model.LocationDisplayable

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()
    private val adapter: LocationAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()

    override fun initViews() {
        super.initViews()
        // initialize all view-related classes
        initRecycler()
    }

    private fun initRecycler() {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
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

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            setLocations(it)
        }
    }

    private fun setLocations(locations: List<LocationDisplayable>) {
        adapter.setItems(locations)
    }

}
