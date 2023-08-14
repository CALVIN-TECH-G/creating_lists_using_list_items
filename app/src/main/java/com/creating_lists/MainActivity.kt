package com.creating_lists

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.creating_lists.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myList = binding.myList
        val countrylist = listOf("uganda", "kenya", "Tanzania", "japan", "Rwanda", "Nigeria")
        val citylist = listOf("kampala", "nairobi", "dar el salama","Tokyo","kigali","abuja" )


        //array adapter with single item view
        //val arrayAdapter = ArrayAdapter(this, R.layout.list_item_layout, R.id.country_id, countryList)

        val arrayAdapter = NewAdapter(this, countrylist,citylist)

        myList.adapter = arrayAdapter


    }
}

class NewAdapter(context: Context, val countryList: List<String>, val cityList: List<String>): ArrayAdapter<String>(context,R.layout.list_item_layout, R.id.country_id,countryList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
       val view = super.getView(position, convertView, parent)
        val countryid = view.findViewById<TextView>(R.id.country_id)
        val cityid = view.findViewById<TextView>(R.id.city_id)

        countryid.text = countryList[position]
        cityid.text = cityList[position]

        return view

    }
}