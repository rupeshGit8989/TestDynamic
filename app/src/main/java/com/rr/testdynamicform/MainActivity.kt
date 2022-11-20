package com.rr.testdynamicform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.rr.testdynamicform.adapter.FormAdapter
import com.rr.testdynamicform.databinding.ActivityMainBinding
import com.rr.testdynamicform.model.MainModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()
    }

    private fun init() {
        val jsonData = getJsonFromAssets("sample.json")
        val mainModel = Gson().fromJson(jsonData, MainModel::class.java)

        val formAdapter = FormAdapter()
        formAdapter.setData(mainModel.form_fields)
        bindRv(binding.rvDynamicForm, formAdapter)
    }

    private fun bindRv(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>?) {
        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    private fun getJsonFromAssets(fileName: String): String {
        return assets.open(fileName).bufferedReader().use { it.readText() }
    }
}