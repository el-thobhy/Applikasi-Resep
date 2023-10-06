package com.elthobhy.applikasiresep.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.LinearLayoutManager
import com.elthobhy.applikasiresep.R
import com.elthobhy.applikasiresep.ui.area.AreaActivity
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.utils.Constants
import com.elthobhy.applikasiresep.core.utils.Status
import com.elthobhy.applikasiresep.databinding.ActivityMainBinding
import com.elthobhy.applikasiresep.ui.detail.DetailActivity
import com.elthobhy.applikasiresep.ui.search.SearchActivity
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeViewModel by inject<HomeViewModel>()
    private val adapterMain by inject<AdapterMain>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onCLick()
        showRv()
        getData()
    }

    private fun onCLick() {
        binding.searchView.setOnClickListener {
            val optionsCompat: ActivityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    Pair(binding.searchView, getString(R.string.search_transition))
                )
            startActivity(
                Intent(this,SearchActivity::class.java),
                optionsCompat.toBundle()
            )
        }
    }

    private fun getData() {
        homeViewModel.getPopular().observe(this){
            when(it.status){
                Status.LOADING -> {
                    binding.shimmerPopular1.visibility = View.VISIBLE
                    binding.shimmerPopular2.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    binding.shimmerPopular1.visibility = View.GONE
                    binding.shimmerPopular2.visibility = View.GONE
                    adapterMain.submitList(it.data)
                }
                Status.ERROR -> {
                    binding.lottie.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun showRv() {
        with(binding.rvPopular){
            layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
            setHasFixedSize(true)
            adapter=adapterMain
        }
        adapterMain.setOnClickCallback(object: AdapterMain.OnItemClickCallback {
            override fun onClicked(data: DomainMain) {
                goToDetail(data)
            }

        })
    }

    private fun goToDetail(data: DomainMain) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(Constants.ID_MEAL,data.idMeal)
        startActivity(intent)
    }

}