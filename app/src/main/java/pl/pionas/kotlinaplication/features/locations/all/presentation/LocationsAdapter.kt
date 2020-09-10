package pl.pionas.kotlinaplication.features.locations.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.pionas.kotlinaplication.core.adapter.BindableAdapter
import pl.pionas.kotlinaplication.core.base.BaseAdapter
import pl.pionas.kotlinaplication.databinding.LocationItemBinding
import pl.pionas.kotlinaplication.features.locations.all.presentation.model.LocationDisplayable

/**
 * Created by Adrian Pionka on 25 sierpień 2020
 * adrian@pionka.com
 */
class LocationsAdapter(private val locationsViewModel: LocationsViewModel) :
    BindableAdapter<LocationDisplayable>,
    BaseAdapter<LocationDisplayable>() {

    constructor(locationsViewModel: LocationsViewModel, list: List<LocationDisplayable>) : this(
        locationsViewModel
    ) {
        super.setItems(list)
    }

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LocationItemBinding.inflate(inflater, parent, false)
        return LocationViewHolder(binding, locationsViewModel)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val movie: LocationDisplayable = items[position]
        (holder as LocationViewHolder).bind(movie)
    }

    class LocationViewHolder(
        private val binding: LocationItemBinding,
        private val locationsViewModel: LocationsViewModel
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(location: LocationDisplayable) {
            with(binding) {
                binding.item = location
                locationsViewModel.let { locationViewModel ->
                    root.setOnClickListener {
                        locationViewModel.onLocationClick(location)
                    }
                }
                binding.executePendingBindings()
            }
        }

    }

}