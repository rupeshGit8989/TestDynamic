package com.rr.testdynamicform.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rr.testdynamicform.BaseAdapter
import com.rr.testdynamicform.databinding.*
import com.rr.testdynamicform.model.FormModel

class FormAdapter : BaseAdapter<RecyclerView.ViewHolder?, FormModel>() {

    var formData: MutableList<FormModel> = ArrayList()
    private val textInputView = 0
    private val numberInputView = 1
    private val emailInputView = 2
    private val ratingView = 3
    private val radioButtonView = 4
    private val checkboxView = 5

    @SuppressLint("NotifyDataSetChanged")
    override fun setData(data: ArrayList<FormModel>) {
        this.formData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            textInputView -> {
                TextViewHolder.create(LayoutInflater.from(parent.context), parent)
            }
            numberInputView -> {
                NumberViewHolder.create(LayoutInflater.from(parent.context), parent)
            }
            checkboxView -> {
                CheckBoxViewHolder.create(LayoutInflater.from(parent.context), parent)
            }
            emailInputView -> {
                EmailViewHolder.create(LayoutInflater.from(parent.context), parent)
            }
            radioButtonView -> {
                RadioButtonViewHolder.create(LayoutInflater.from(parent.context), parent)
            }
            ratingView -> {
                RatingViewHolder.create(LayoutInflater.from(parent.context), parent)
            }
            else -> TextViewHolder.create(LayoutInflater.from(parent.context), parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TextViewHolder -> {
                holder.binding.tvLabel.hint = formData[position].templateOptions.label
                holder.binding.edtTextInput.hint = formData[position].templateOptions.options[0].label
            }
            is NumberViewHolder -> {
                holder.binding.tvLabel.hint = formData[position].templateOptions.label
                holder.binding.edtNumberInput.hint = formData[position].templateOptions.options[0].label
            }
            is EmailViewHolder -> {
                holder.binding.tvLabel.hint = formData[position].templateOptions.label
                holder.binding.edtEmail.hint = formData[position].templateOptions.options[0].label
            }
            is CheckBoxViewHolder -> {
                holder.binding.tvLabel.hint = formData[position].templateOptions.label
                val checkboxAdapter = CheckboxAdapter()
                checkboxAdapter.setData(formData[position].templateOptions.options)
                bindRv(holder.binding.rvCheckBox, checkboxAdapter)
            }
            is RadioButtonViewHolder -> {
                holder.binding.tvLabel.hint = formData[position].templateOptions.label
                val radioButtonAdapter = RadioButtonAdapter()
                radioButtonAdapter.setData(formData[position].templateOptions.options)
                bindRv(holder.binding.rvRadioButton, radioButtonAdapter)
            }
            is RatingViewHolder -> {
                holder.binding.tvLabel.hint = formData[position].templateOptions.label
                if (formData[position].templateOptions.options.size > 0) {
                    val rating = formData[position].templateOptions.options[0].value.toFloat()
                    holder.binding.ratingBar.rating = rating
                }
            }
        }
    }

    private fun bindRv(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>?) {
        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    override fun getItemViewType(position: Int): Int {
        return when (formData[position].key) {
            "checkbox" -> {
                checkboxView
            }
            "radio_button" -> {
                radioButtonView
            }
            "text_input" -> {
                textInputView
            }
            "number_input" -> {
                numberInputView
            }
            "email_input" -> {
                emailInputView
            }
            "star_ratings" -> {
                ratingView
            }
            else -> position
        }
    }

    override fun getItemCount(): Int {
        return formData.size
    }

    class TextViewHolder(var binding: RowTextInputBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(inflater: LayoutInflater?, parent: ViewGroup?): TextViewHolder {
                val itemHomeBlogBinding = RowTextInputBinding.inflate(inflater!!, parent, false)
                return TextViewHolder(itemHomeBlogBinding)
            }
        }
    }

    class NumberViewHolder(var binding: RowNumberInputBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(inflater: LayoutInflater?, parent: ViewGroup?): NumberViewHolder {
                val itemHomeBlogBinding = RowNumberInputBinding.inflate(inflater!!, parent, false)
                return NumberViewHolder(itemHomeBlogBinding)
            }
        }
    }

    class CheckBoxViewHolder(var binding: RowCheckboxBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(inflater: LayoutInflater?, parent: ViewGroup?): CheckBoxViewHolder {
                val itemHomeBlogBinding = RowCheckboxBinding.inflate(inflater!!, parent, false)
                return CheckBoxViewHolder(itemHomeBlogBinding)
            }
        }
    }

    class EmailViewHolder(var binding: RowEmailInputBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(inflater: LayoutInflater?, parent: ViewGroup?): EmailViewHolder {
                val itemHomeBlogBinding = RowEmailInputBinding.inflate(inflater!!, parent, false)
                return EmailViewHolder(itemHomeBlogBinding)
            }
        }
    }

    class RadioButtonViewHolder(var binding: RowRadiobuttonBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(inflater: LayoutInflater?, parent: ViewGroup?): RadioButtonViewHolder {
                val itemHomeBlogBinding = RowRadiobuttonBinding.inflate(inflater!!, parent, false)
                return RadioButtonViewHolder(itemHomeBlogBinding)
            }
        }
    }

    class RatingViewHolder(var binding: RowRatingBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(inflater: LayoutInflater?, parent: ViewGroup?): RatingViewHolder {
                val itemHomeBlogBinding = RowRatingBinding.inflate(inflater!!, parent, false)
                return RatingViewHolder(itemHomeBlogBinding)
            }
        }
    }

}
