package com.rr.testdynamicform

import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

abstract class BaseAdapter<T : RecyclerView.ViewHolder?, D> : RecyclerView.Adapter<T>() {
    abstract fun setData(data: ArrayList<D>)
}