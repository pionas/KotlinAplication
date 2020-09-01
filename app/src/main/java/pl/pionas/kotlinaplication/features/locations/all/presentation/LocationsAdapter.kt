package pl.pionas.kotlinaplication.features.locations.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseAdapter
import pl.pionas.kotlinaplication.features.locations.all.presentation.model.LocationDisplayable

/**
 * Created by Adrian Pionka on 25 sierpień 2020
 * adrian@pionka.com
 */
class LocationsAdapter(private val locationsViewModel: LocationsViewModel) :
    BaseAdapter<LocationDisplayable>() {

    constructor(locationsViewModel: LocationsViewModel, list: List<LocationDisplayable>) : this(
        locationsViewModel
    ) {
        super.setItems(list)
    }

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LocationViewHolder(inflater, parent, locationsViewModel)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val movie: LocationDisplayable = items[position]
        (holder as LocationViewHolder).bind(movie)
    }

    class LocationViewHolder(
        inflater: LayoutInflater, parent: ViewGroup,
        locationsViewModel: LocationsViewModel
    ) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.location_item, parent, false)) {
        private var mLocationView: TextView? = null
        private var mLocationsViewModel: LocationsViewModel


        init {
            mLocationView = itemView.findViewById(R.id.location_name)
            mLocationsViewModel = locationsViewModel
        }

        fun bind(location: LocationDisplayable) {
            mLocationView?.text = location.name
            mLocationView?.setOnClickListener {
                mLocationsViewModel.onLocationClick(location)
            }
        }

    }

}