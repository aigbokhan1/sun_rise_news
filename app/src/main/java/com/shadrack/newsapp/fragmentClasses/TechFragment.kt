package com.shadrack.newsapp.fragmentClasses

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shadrack.newsapp.MainActivity
import com.shadrack.newsapp.NewsModel
import com.shadrack.newsapp.R

import com.shadrack.newsapp.ReadNewsActivity
import com.shadrack.newsapp.adapters.CustomAdapter

class TechFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tech, container, false)
        val newsData: MutableList<NewsModel> = MainActivity.techNews
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = CustomAdapter(newsData)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : CustomAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {

                val intent = Intent(context, ReadNewsActivity::class.java)
                intent.putExtra(MainActivity.NEWS_URL, newsData[position].url)
                intent.putExtra(MainActivity.NEWS_TITLE, newsData[position].headLine)
                intent.putExtra(MainActivity.NEWS_IMAGE_URL, newsData[position].image)
                intent.putExtra(MainActivity.NEWS_DESCRIPTION, newsData[position].description)
                intent.putExtra(MainActivity.NEWS_SOURCE, newsData[position].source)
                intent.putExtra(MainActivity.NEWS_PUBLICATION_TIME, newsData[position].time)
                intent.putExtra(MainActivity.NEWS_CONTENT, newsData[position].content)
                startActivity(intent)
            }
        })

        //ignore
        adapter.setOnItemLongClickListener(object : CustomAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int) {
            }
        })

        return view
    }

}