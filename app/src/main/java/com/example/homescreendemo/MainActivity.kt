package com.example.homescreendemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var stationAdapter: StationRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet(){
        val data = DataSource.createDataSet()
        stationAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        recycler_view.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            stationAdapter = StationRecyclerAdapter()
            adapter = stationAdapter
        }
    }
}
