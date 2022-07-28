package com.dedesaepulloh.assesment.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.dedesaepulloh.assesment.data.OtherNews
import com.dedesaepulloh.assesment.databinding.FragmentNewsBinding
import com.dedesaepulloh.assesment.presentation.adapter.NewsAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var adapter: NewsAdapter
    private var listNews = ArrayList<OtherNews>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jsonFileString = getJsonDataFromAsset(requireContext(), "posts.json")
        val gson = Gson()
        val dataNews = object : TypeToken<ArrayList<OtherNews>>() {}.type
        val news: ArrayList<OtherNews> = gson.fromJson(jsonFileString, dataNews)
        news.forEachIndexed { idx, news ->
            Log.i("data", "> Item $idx:\n$news") }

        adapter = NewsAdapter(news)

        binding.apply {
            rvOtherNews.layoutManager = GridLayoutManager(context, 2)
            rvOtherNews.setHasFixedSize(true)
            rvOtherNews.adapter = adapter
        }
    }


    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

}