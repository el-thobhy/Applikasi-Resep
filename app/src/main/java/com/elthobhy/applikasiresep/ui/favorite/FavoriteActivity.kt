package com.elthobhy.applikasiresep.ui.favorite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.elthobhy.applikasiresep.R
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.utils.Constants
import com.elthobhy.applikasiresep.databinding.ActivityFavoriteBinding
import com.elthobhy.applikasiresep.ui.detail.DetailActivity
import org.koin.android.ext.android.inject

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private val favoriteViewModel by inject<FavoriteViewModel>()
    private val adapterFav by inject<AdapterFav>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        showRv()
        setAppBar()
    }

    private fun setAppBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.bookmark)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun getData() {
        favoriteViewModel.getFav().observe(this){
            adapterFav.submitList(it)
        }
    }

    private fun showRv() {
        binding.rvPopular.apply {
            layoutManager =
                LinearLayoutManager(this@FavoriteActivity,  LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = adapterFav
        }
        adapterFav.setOnClickCallback(object : AdapterFav.OnItemClickCallback {
            override fun onClicked(data: DomainDetail) {
                goToListArea(data)
            }
        })
    }

    private fun goToListArea(data: DomainDetail) {
        val intent = Intent(this@FavoriteActivity, DetailActivity::class.java)
        intent.putExtra(Constants.ID_MEAL, data.idMeal)
        startActivity(intent)
    }
}