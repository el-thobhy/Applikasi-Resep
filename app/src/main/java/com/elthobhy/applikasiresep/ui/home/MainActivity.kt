package com.elthobhy.applikasiresep.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.elthobhy.applikasiresep.R
import com.elthobhy.applikasiresep.core.domain.model.DomainCategory
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.utils.Constants
import com.elthobhy.applikasiresep.core.utils.Status
import com.elthobhy.applikasiresep.databinding.ActivityMainBinding
import com.elthobhy.applikasiresep.databinding.LayoutDialogBinding
import com.elthobhy.applikasiresep.ui.detail.DetailActivity
import com.elthobhy.applikasiresep.ui.detail.detailcatagory.DetailCategoryActivity
import com.elthobhy.applikasiresep.ui.search.SearchActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.android.inject
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeViewModel by inject<HomeViewModel>()
    private val adapterMain by inject<AdapterMain>()
    private val adapterCategory by inject<AdapterCategory>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onCLick()
        showRv()
        getData()
    }

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
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
        binding.card.setOnClickListener {
            showDialogCategory()
        }
    }

    private fun showDialogCategory() {
        val dialogBinding = LayoutDialogBinding.inflate(layoutInflater)
        val alert = AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .setCancelable(true)
        alert.show().window?.decorView?.setBackgroundResource(android.R.color.transparent)
        showRvCategory(dialogBinding)
        getDataCategory()

    }

    private fun showRvCategory(dialogBinding: LayoutDialogBinding) {
        dialogBinding.rvCategory.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 4,GridLayoutManager.VERTICAL,false)
            setHasFixedSize(true)
            adapter = adapterCategory
        }
        adapterCategory.setOnClickCallback(object : AdapterCategory.OnItemClickCallback{
            override fun onClicked(data: DomainCategory) {
                goToDetailCategory(data)
            }
        })
    }

    private fun goToDetailCategory(data: DomainCategory) {
        val intent = Intent(this,DetailCategoryActivity::class.java)
        intent.putExtra(Constants.DATA_CATEGORY, data)
        startActivity(intent)
    }

    private fun getDataCategory() {
        homeViewModel.getCategory().observe(this){
            when(it.status){
                Status.LOADING -> {}
                Status.SUCCESS -> {
                    adapterCategory.submitList(it.data)
                }
                Status.ERROR -> {}
            }
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