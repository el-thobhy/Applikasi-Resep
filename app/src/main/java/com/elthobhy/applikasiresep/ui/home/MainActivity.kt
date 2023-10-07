package com.elthobhy.applikasiresep.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.elthobhy.applikasiresep.R
import com.elthobhy.applikasiresep.core.domain.model.Domain
import com.elthobhy.applikasiresep.core.domain.model.DomainCategory
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.utils.Constants
import com.elthobhy.applikasiresep.core.utils.Status
import com.elthobhy.applikasiresep.databinding.ActivityMainBinding
import com.elthobhy.applikasiresep.databinding.LayoutDialogAreaBinding
import com.elthobhy.applikasiresep.databinding.LayoutDialogBinding
import com.elthobhy.applikasiresep.ui.area.AreaActivity
import com.elthobhy.applikasiresep.ui.detail.DetailActivity
import com.elthobhy.applikasiresep.ui.detail.detailcatagory.DetailCategoryActivity
import com.elthobhy.applikasiresep.ui.favorite.FavoriteActivity
import com.elthobhy.applikasiresep.ui.search.SearchActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeViewModel by inject<HomeViewModel>()
    private val adapterMain by inject<AdapterMain>()
    private val adapterCategory by inject<AdapterCategory>()
    private val adapterArea by inject<AdapterArea>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
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
                Intent(this, SearchActivity::class.java),
                optionsCompat.toBundle()
            )
        }
        binding.apply {
            card2.setOnClickListener {
                val intent = Intent(this@MainActivity, FavoriteActivity::class.java)
                startActivity(intent)
            }
            card1.setOnClickListener {
                showDialogArea()
            }
            card.setOnClickListener {
                showDialogCategory()
            }
        }
    }

    private fun showDialogArea() {
        val dialogBinding = LayoutDialogAreaBinding.inflate(layoutInflater)
        val alert = AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .setCancelable(true)
        alert.show().window?.decorView?.setBackgroundResource(android.R.color.transparent)
        getDataArea()
        showRvArea(dialogBinding)

    }

    private fun getDataArea() {
        homeViewModel.getArea().observe(this) {
            when (it.status) {
                Status.LOADING -> {
                    Log.e("loding", "getDataArea: " )
                }
                Status.SUCCESS -> {
                    adapterArea.submitList(it.data)
                    Log.e("data", "getDataArea: ${it.data}" )
                }

                Status.ERROR -> {
                    Log.e("oiiiii", "getDataArea: ${it.message}")
                }
            }
        }
    }

    private fun showRvArea(dialogBinding: LayoutDialogAreaBinding) {
        dialogBinding.rvArea.apply {
            layoutManager =
                GridLayoutManager(this@MainActivity, 4, GridLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = adapterArea
        }
        adapterArea.setOnClickCallback(object : AdapterArea.OnItemClickCallback {
            override fun onClicked(data: Domain) {
                goToListArea(data)
            }
        })
    }

    private fun goToListArea(data: Domain) {
        val intent = Intent(this, AreaActivity::class.java)
        intent.putExtra(Constants.AREA, data)
        startActivity(intent)
    }

    private fun showDialogCategory() {
        val dialogBinding = LayoutDialogBinding.inflate(layoutInflater)
        val alert = AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .setCancelable(true)
        alert.show().window?.decorView?.setBackgroundResource(android.R.color.transparent)
        showRvDialog(dialogBinding)
        getDataCategory()

    }

    private fun showRvDialog(dialogBinding: LayoutDialogBinding) {
        dialogBinding.rvCategory.apply {
            layoutManager =
                GridLayoutManager(this@MainActivity, 4, GridLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = adapterCategory
        }
        adapterCategory.setOnClickCallback(object : AdapterCategory.OnItemClickCallback {
            override fun onClicked(data: DomainCategory) {
                goToDetailCategory(data)
            }
        })
    }

    private fun goToDetailCategory(data: DomainCategory) {
        val intent = Intent(this, DetailCategoryActivity::class.java)
        intent.putExtra(Constants.DATA_CATEGORY, data)
        startActivity(intent)
    }

    private fun getDataCategory() {
        homeViewModel.getCategory().observe(this) {
            when (it.status) {
                Status.LOADING -> {
                    Log.e("loding", "getDataCategory: " )
                }
                Status.SUCCESS -> {
                    Log.e("loding", "getDataCategory: ${it.data}" )
                    adapterCategory.submitList(it.data)
                }

                Status.ERROR -> {}
            }
        }
    }

    private fun getData() {
        homeViewModel.getPopular().observe(this) {
            when (it.status) {
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
        with(binding.rvPopular) {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = adapterMain
        }
        adapterMain.setOnClickCallback(object : AdapterMain.OnItemClickCallback {
            override fun onClicked(data: DomainMain) {
                goToDetail(data)
            }

        })
    }

    private fun goToDetail(data: DomainMain) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(Constants.ID_MEAL, data.idMeal)
        startActivity(intent)
    }

}