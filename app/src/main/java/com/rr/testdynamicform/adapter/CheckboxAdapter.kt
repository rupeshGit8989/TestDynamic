package com.rr.testdynamicform.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rr.testdynamicform.BaseAdapter
import com.rr.testdynamicform.databinding.ItemCheckboxBinding
import com.rr.testdynamicform.model.Options

class CheckboxAdapter : BaseAdapter<RecyclerView.ViewHolder?, Options>() {

    var formData: MutableList<Options> = ArrayList()

    override fun setData(data: ArrayList<Options>) {
        this.formData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CheckBoxViewHolder.create(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CheckBoxViewHolder -> {
                holder.binding.checkBox.text = formData[position].label
                holder.binding.checkBox.isChecked = formData[position].isCheck
                holder.binding.checkBox.setOnClickListener {
                    formData[position].isCheck = !formData[position].isCheck
                    notifyItemChanged(position)
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

    class CheckBoxViewHolder(var binding: ItemCheckboxBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(inflater: LayoutInflater?, parent: ViewGroup?): CheckBoxViewHolder {
                val itemHomeBlogBinding = ItemCheckboxBinding.inflate(inflater!!, parent, false)
                return CheckBoxViewHolder(itemHomeBlogBinding)
            }
        }
    }

}
