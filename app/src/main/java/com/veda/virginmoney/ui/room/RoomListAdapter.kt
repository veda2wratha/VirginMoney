package com.veda.virginmoney.ui.room

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.veda.virginmoney.data.model.Room
import com.veda.virginmoney.databinding.LayoutRoomListItemBinding

class RoomListAdapter(private val dataSet: ArrayList<Room>) :
    RecyclerView.Adapter<RoomListAdapter.ViewHolder>() {

    class ViewHolder(private val view: LayoutRoomListItemBinding) : RecyclerView.ViewHolder(view.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Room) {
            view.capacity.text = "Maximum Occupancy : ${item.maxOccupancy}"
            view.name.text = "Room ${item.id}"
            if(item.isOccupied) {
                view.occupied.text = "Occupied"
                view.occupied.setTextColor(Color.parseColor("#ff0000"))
            } else {
                view.occupied.text = "Not Occupied"
                view.occupied.setTextColor(Color.parseColor("#007500"))
            }

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutRoomListItemBinding =
            LayoutRoomListItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val dataModel: Room = dataSet[position]
        viewHolder.bind(dataModel)
    }
    override fun getItemCount() = dataSet.size
}