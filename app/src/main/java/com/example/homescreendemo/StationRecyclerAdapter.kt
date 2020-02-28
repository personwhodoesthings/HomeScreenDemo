package com.example.homescreendemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.homescreendemo.Models.Station
import kotlinx.android.synthetic.main.layout_station_list_item.view.*

class StationRecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: List<Station> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_station_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is StationViewHolder ->{
                holder.bind(items.get(position))
            }
        }
    }

    fun submitList(station: List<Station>)
    {
        items = station
    }


    class StationViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val station_image = itemView.station_image
        val station_title = itemView.station_title

        fun bind(station: Station){

            station_title.setText(station.title)

            val requestOptions = RequestOptions()
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .load(station.image)
                .into(station_image)
        }
    }


}