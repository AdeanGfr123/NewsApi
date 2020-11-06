package com.example.newsapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import coil.size.Scale
import com.example.newsapi.databinding.ActivityDetailBinding
import com.example.newsapi.model.ArticlesItem

class DetailActivity : AppCompatActivity(){

    companion object{
        const val DETAIL_NEWS = "DETAIL_NEWS"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        val data = intent.getParcelableExtra<ArticlesItem>(DETAIL_NEWS) as ArticlesItem

        binding.run {
            setContentView(root)

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            title = data.title

            imgToolbar.apply {
                load(data.urlToImage){
                    scale(Scale.FILL)
                }
                contentDescription = data.description
            }
            txtContent.text = data.content

            txtDate.text = data.publishedAt
        }
    }
}