package com.elthobhy.applikasiresep.ui.detail.detailcatagory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.elthobhy.applikasiresep.core.domain.model.DomainCategory
import com.elthobhy.applikasiresep.core.domain.model.DomainMeal
import com.elthobhy.applikasiresep.core.utils.Constants
import com.elthobhy.applikasiresep.core.utils.Status
import com.elthobhy.applikasiresep.databinding.ActivityDetailCategoryBinding
import com.elthobhy.applikasiresep.ui.detail.DetailActivity
import com.elthobhy.applikasiresep.ui.mealcategory.MealActivity
import org.koin.android.ext.android.inject

class DetailCategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailCategoryBinding
    private val detailCategoryViewModel by inject<DetailCategoryViewModel>()
    private val adapterCategoryMeal by inject<DetailCategoryMealAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.getParcelableExtra<DomainCategory>(Constants.DATA_CATEGORY)
        showDetail(data)
        setBar()
        showRV()
    }

    private fun showRV() {
        binding.rvCategoryMeal.apply {
            layoutManager = LinearLayoutManager(
                this@DetailCategoryActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            setHasFixedSize(true)
            adapter = adapterCategoryMeal
        }
        adapterCategoryMeal.setOnClickCallback(object :
            DetailCategoryMealAdapter.OnItemClickCallback {
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

    private fun setBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun getStatus(
        data: DomainCategory?,
        isBeef: Boolean,
        isBreakfast: Boolean,
        isChicken: Boolean,
        isDessert: Boolean,
        isGoat: Boolean,
        isLamb: Boolean,
        isMiscellaneous: Boolean,
        isPasta: Boolean,
        isPork: Boolean,
        isSeafood: Boolean,
        isSide: Boolean,
        isStarter: Boolean,
        isVegan: Boolean,
        isVegetarian: Boolean,
    ) {
        detailCategoryViewModel.getListCategory(
            data?.strCategory.toString(),
            isBeef,
            isBreakfast,
            isChicken,
            isDessert,
            isGoat,
            isLamb,
            isMiscellaneous,
            isPasta,
            isPork,
            isSeafood,
            isSide,
            isStarter,
            isVegan,
            isVegetarian,
        ).observe(this) { list ->
            when (list.status) {
                Status.LOADING -> {}
                Status.SUCCESS -> {
                    adapterCategoryMeal.submitList(list.data)
                    Log.e("datakuuuu", "getStatus: ${list.data}" )
                }

                Status.ERROR -> {
                    Log.e("errrrr", "getStatus: ${list.message}" )
                }
            }
        }
    }

    private fun showDetail(data: DomainCategory?) {
        binding.apply {
            Glide.with(this@DetailCategoryActivity)
                .load(data?.strCategoryThumb)
                .into(ivDetailCategory)
            mealCategory.text = data?.strCategory
            tvDescription.text = data?.strCategoryDescription

            when(data?.strCategory.toString()){
                "Beef"->{
                    getStatus(
                        data,  isBeef=true,
                        isBreakfast=false,
                        isChicken=false,
                        isDessert=false,
                        isGoat=false,
                        isLamb=false,
                        isMiscellaneous=false,
                        isPasta=false,
                        isPork=false,
                        isSeafood=false,
                        isSide=false,
                        isStarter=false,
                        isVegan=false,
                        isVegetarian=false,
                    )
                }
                "Breakfast"->{
                    getStatus(
                        data,  isBeef=false,
                        isBreakfast=true,
                        isChicken=false,
                        isDessert=false,
                        isGoat=false,
                        isLamb=false,
                        isMiscellaneous=false,
                        isPasta=false,
                        isPork=false,
                        isSeafood=false,
                        isSide=false,
                        isStarter=false,
                        isVegan=false,
                        isVegetarian=false,
                    )
                }
                "Chicken"->{
                    getStatus(
                        data,  isBeef=false,
                        isBreakfast=false,
                        isChicken=true,
                        isDessert=false,
                        isGoat=false,
                        isLamb=false,
                        isMiscellaneous=false,
                        isPasta=false,
                        isPork=false,
                        isSeafood=false,
                        isSide=false,
                        isStarter=false,
                        isVegan=false,
                        isVegetarian=false,
                    )
                }
                "Dessert"->{
                    getStatus(
                        data,  isBeef=false,
                        isBreakfast=false,
                        isChicken=false,
                        isDessert=true,
                        isGoat=false,
                        isLamb=false,
                        isMiscellaneous=false,
                        isPasta=false,
                        isPork=false,
                        isSeafood=false,
                        isSide=false,
                        isStarter=false,
                        isVegan=false,
                        isVegetarian=false,
                    )
                }
                "Goat"->{
                    getStatus(
                        data,  isBeef=false,
                        isBreakfast=false,
                        isChicken=false,
                        isDessert=false,
                        isGoat=true,
                        isLamb=false,
                        isMiscellaneous=false,
                        isPasta=false,
                        isPork=false,
                        isSeafood=false,
                        isSide=false,
                        isStarter=false,
                        isVegan=false,
                        isVegetarian=false,
                    )
                }
                "Lamb"->{
                    getStatus(
                        data,  isBeef=false,
                        isBreakfast=false,
                        isChicken=false,
                        isDessert=false,
                        isGoat=false,
                        isLamb=true,
                        isMiscellaneous=false,
                        isPasta=false,
                        isPork=false,
                        isSeafood=false,
                        isSide=false,
                        isStarter=false,
                        isVegan=false,
                        isVegetarian=false,
                    )
                }
                "Miscellaneous"->{
                    getStatus(
                        data,  isBeef=false,
                        isBreakfast=false,
                        isChicken=false,
                        isDessert=false,
                        isGoat=false,
                        isLamb=false,
                        isMiscellaneous=true,
                        isPasta=false,
                        isPork=false,
                        isSeafood=false,
                        isSide=false,
                        isStarter=false,
                        isVegan=false,
                        isVegetarian=false,
                    )
                }
                "Pasta"->{
                    getStatus(
                        data,  isBeef=false,
                        isBreakfast=false,
                        isChicken=false,
                        isDessert=false,
                        isGoat=false,
                        isLamb=false,
                        isMiscellaneous=false,
                        isPasta=true,
                        isPork=false,
                        isSeafood=false,
                        isSide=false,
                        isStarter=false,
                        isVegan=false,
                        isVegetarian=false,
                    )
                }
                "Pork"->{
                    getStatus(
                        data,  isBeef=false,
                        isBreakfast=false,
                        isChicken=false,
                        isDessert=false,
                        isGoat=false,
                        isLamb=false,
                        isMiscellaneous=false,
                        isPasta=false,
                        isPork=true,
                        isSeafood=false,
                        isSide=false,
                        isStarter=false,
                        isVegan=false,
                        isVegetarian=false,
                    )
                }
                "Seafood"->{
                    getStatus(
                        data,  isBeef=false,
                        isBreakfast=false,
                        isChicken=false,
                        isDessert=false,
                        isGoat=false,
                        isLamb=false,
                        isMiscellaneous=false,
                        isPasta=false,
                        isPork=false,
                        isSeafood=true,
                        isSide=false,
                        isStarter=false,
                        isVegan=false,
                        isVegetarian=false,
                    )
                }
                "Side"->{
                    getStatus(
                        data,  isBeef=false,
                        isBreakfast=false,
                        isChicken=false,
                        isDessert=false,
                        isGoat=false,
                        isLamb=false,
                        isMiscellaneous=false,
                        isPasta=false,
                        isPork=false,
                        isSeafood=false,
                        isSide=true,
                        isStarter=false,
                        isVegan=false,
                        isVegetarian=false,
                    )
                }
                "Starter"->{
                    getStatus(
                        data,  isBeef=false,
                        isBreakfast=false,
                        isChicken=false,
                        isDessert=false,
                        isGoat=false,
                        isLamb=false,
                        isMiscellaneous=false,
                        isPasta=false,
                        isPork=false,
                        isSeafood=false,
                        isSide=false,
                        isStarter=true,
                        isVegan=false,
                        isVegetarian=false,
                    )
                }
                "Vegan"->{
                    getStatus(
                        data,  isBeef=false,
                        isBreakfast=false,
                        isChicken=false,
                        isDessert=false,
                        isGoat=false,
                        isLamb=false,
                        isMiscellaneous=false,
                        isPasta=false,
                        isPork=false,
                        isSeafood=false,
                        isSide=false,
                        isStarter=false,
                        isVegan=true,
                        isVegetarian=false,
                    )
                }
                "Vegetarian"->{
                    getStatus(
                        data,  isBeef=false,
                        isBreakfast=false,
                        isChicken=false,
                        isDessert=false,
                        isGoat=false,
                        isLamb=false,
                        isMiscellaneous=false,
                        isPasta=false,
                        isPork=false,
                        isSeafood=false,
                        isSide=false,
                        isStarter=false,
                        isVegan=false,
                        isVegetarian=true,
                    )
                }

            }

        }
    }

}