package pl.pionas.kotlinaplication.features.locations.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_location.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.BR
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.databinding.FragmentLocationBinding

class LocationsFragment : BaseFragment<LocationsViewModel, FragmentLocationBinding>(
    BR.viewModel,
    R.layout.fragment_location
) {

    override val viewModel: LocationsViewModel by viewModel()

    private val linearLayoutManager: LinearLayoutManager by inject()
    private val divider: DividerItemDecoration by inject()
    private val locationAdapter: LocationsAdapter by inject()

    override fun initViews(binding: FragmentLocationBinding) {
        super.initViews(binding)
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

    override fun onDestroyView() {
        super.onDestroyView()
        with(recyclerView) {
            layoutManager = null
            adapter = null
        }
    }

}
