package pl.pionas.kotlinaplication.features.locations.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseAdapter
import pl.pionas.kotlinaplication.features.locations.presentation.model.LocationDisplayable

/**
 * Created by Adrian Pionka on 25 sierpień 2020
 * adrian@pionka.com
 */
class LocationAdapter() : BaseAdapter<LocationDisplayable>() {

    constructor(list: List<LocationDisplayable>) : this() {
        super.setItems(list)
    }

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LocationViewHolder(inflater, parent)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val movie: LocationDisplayable = items[position]
        (holder as LocationViewHolder).bind(movie)
    }

    class LocationViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.location_item, parent, false)) {
        private var mLocationView: TextView? = null


        init {
            mLocationView = itemView.findViewById(R.id.location_name)
        }

        fun bind(location: LocationDisplayable) {
            mLocationView?.text = location.name
        }

    }

}