package com.mwangi.cultivatewise.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mwangi.cultivatewise.databinding.CropsListItemBinding
import com.mwangi.cultivatewise.model.CropsResponse
import com.squareup.picasso.Picasso
import retrofit2.Response

class Adapter(var cropList: List<CropsResponse>, var context: Context): RecyclerView.Adapter<CropsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CropsViewHolder {
        var binding = CropsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CropsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CropsViewHolder, position: Int) {
        var crop = cropList[position]
        var binding = holder.binding
        binding.tvCropName.text = crop.name
        binding.tvCropDescription.text = crop.description

//        Picasso.get()
//            .load(crop.image)
//            .into(binding.ivCrop)

    }

    override fun getItemCount(): Int {
        return cropList.size
    }
}

class CropsViewHolder(var binding: CropsListItemBinding):RecyclerView.ViewHolder(binding.root)