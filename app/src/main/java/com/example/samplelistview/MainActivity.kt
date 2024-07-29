package com.example.samplelistview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(findViewById(R.id.my_toolbar))


        val listView = findViewById<ListView>(R.id.listView)

        val quoteList = arrayListOf<String>()
        quoteList.add("1. The greatest glory in living lies not in never falling, but in rising every time we fall.")
        quoteList.add("2. There is a way to get started, but there is no way to get lost.")
        quoteList.add("3. I have not failed. I've just found 10,000 ways that won't work.")
        quoteList.add("4. The way to get started is to quit talking and begin doing.")
        quoteList.add("5. Your time is limited, so don't waste it living someone else's life.")
        quoteList.add("6. It is never too late to be what you might have been.")
        quoteList.add("7. If you look at what you have in life, you'll always have more.")
        quoteList.add("8. Life is what happens when you're busy making other plans.")
        quoteList.add("9. Do not go where the path may lead, go instead where there is no path and leave a trail.")
        quoteList.add("10. When you reach the end of your rope, tie a knot in it and hang on.")

        val adapterForListView  = ArrayAdapter(this, android.R.layout.simple_list_item_1, quoteList)
        listView.adapter = adapterForListView

        listView.setOnItemClickListener {parent, view, position, id ->
            val text = "Clicked on item " + (view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }


    }
}