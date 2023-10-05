package com.elthobhy.applikasiresep.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.elthobhy.applikasiresep.ui.area.AreaActivity
import com.elthobhy.applikasiresep.core.domain.model.DomainPopular
import com.elthobhy.applikasiresep.core.utils.Constants
import com.elthobhy.applikasiresep.core.utils.Status
import com.elthobhy.applikasiresep.databinding.ActivityMainBinding
import com.elthobhy.applikasiresep.ui.detail.DetailActivity
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeViewModel by inject<HomeViewModel>()
    private val adapterPopular by inject<AdapterPopular>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goToArea()
        showRv()
        getData()
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
                    adapterPopular.submitList(it.data)
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
            adapter=adapterPopular
        }
        adapterPopular.setOnClickCallback(object: AdapterPopular.OnItemClickCallback {
            override fun onClicked(data: DomainPopular) {
                goToDetail(data)
            }

        })
    }

    private fun goToDetail(data: DomainPopular) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(Constants.ID_MEAL,data.idMeal)
        startActivity(intent)
    }

    private fun goToArea() {
        binding.root.setOnClickListener {
            startActivity(Intent(this, AreaActivity::class.java))
        }
    }
}