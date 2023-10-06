package com.elthobhy.applikasiresep.ui.mealcategory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.elthobhy.applikasiresep.core.domain.model.DomainMeal
import com.elthobhy.applikasiresep.core.utils.Constants
import com.elthobhy.applikasiresep.databinding.ActivityMealBinding
import com.elthobhy.applikasiresep.ui.detail.DetailActivity
import com.elthobhy.applikasiresep.ui.detail.detailcatagory.DetailCategoryMealAdapter
import com.elthobhy.applikasiresep.ui.detail.detailcatagory.DetailCategoryViewModel
import org.koin.android.ext.android.inject

class MealActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMealBinding
    private val adapterCategoryMeal by inject<DetailCategoryMealAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.getStringExtra(Constants.DATA_CATEGORY)

        showRV()
    }

    private fun showRV() {
        binding.rvCategoryMeal.apply {
            layoutManager = LinearLayoutManager(this@MealActivity, LinearLayoutManager.VERTICAL,false)
            setHasFixedSize(true)
            adapter = adapterCategoryMeal
        }
        adapterCategoryMeal.setOnClickCallback(object : DetailCategoryMealAdapter.OnItemClickCallback{
            override fun onClicked(data: DomainMeal) {
                goToDetailCategory(data)
            }
        })
    }

    private fun goToDetailCategory(data: DomainMeal) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(Constants.DATA_CATEGORY, data.idMeal)
        startActivity(intent)
    }
}