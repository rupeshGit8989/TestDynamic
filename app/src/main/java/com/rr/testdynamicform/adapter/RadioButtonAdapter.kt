package com.rr.testdynamicform.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rr.testdynamicform.BaseAdapter
import com.rr.testdynamicform.databinding.ItemRadiobuttonBinding
import com.rr.testdynamicform.model.Options

class RadioButtonAdapter : BaseAdapter<RecyclerView.ViewHolder?, Options>() {

    var formData: MutableList<Options> = ArrayList()
    var selectedPosition = -1

    override fun setData(data: ArrayList<Options>) {
        this.formData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RadioButtonViewHolder.create(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RadioButtonViewHolder -> {
                holder.binding.radioButton.text = formData[position].label
                holder.binding.radioButton.isChecked = position == selectedPosition
                holder.binding.radioButton.setOnClickListener {
                    selectedPosition = position
                    notifyDataSetChanged()
                }
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return formData.size
    }

    class RadioButtonViewHolder(var binding: ItemRadiobuttonBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(inflater: LayoutInflater?, parent: ViewGroup?): RadioButtonViewHolder {
                val itemHomeBlogBinding = ItemRadiobuttonBinding.inflate(inflater!!, parent, false)
                return RadioButtonViewHolder(itemHomeBlogBinding)
            }
        }
    }

}
