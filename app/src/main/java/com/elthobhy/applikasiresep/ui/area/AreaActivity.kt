package com.elthobhy.applikasiresep.ui.area

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.elthobhy.applikasiresep.core.domain.model.Domain
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.utils.Constants
import com.elthobhy.applikasiresep.core.utils.Status
import com.elthobhy.applikasiresep.databinding.ActivityAreaBinding
import com.elthobhy.applikasiresep.ui.detail.DetailActivity
import com.elthobhy.applikasiresep.ui.home.AdapterMain
import org.koin.android.ext.android.inject

class AreaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAreaBinding
    private val areaViewModel by inject<AreaViewModel>()
    private val adapterMain by inject<AdapterMain>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAreaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.getParcelableExtra<Domain>(Constants.AREA)
        showRv()
        getData(data)

    }

    private fun getData(data: Domain?) {
        areaViewModel.getAreaList(data?.strArea.toString()).observe(this){
            when(it.status){
                Status.LOADING -> {
                    Log.e("loding", "getDataArea: " )
                }
                Status.SUCCESS -> {
                    adapterMain.submitList(it.data)
                    Log.e("data", "getDataArea: ${it.data}" )
                }

                Status.ERROR -> {
                    Log.e("oiiiii", "getDataArea: ${it.message}")
                }
            }
        }
    }

    private fun showRv() {
        with(binding.rvArea) {
            layoutManager =
                LinearLayoutManager(this@AreaActivity, androidx.recyclerview.widget.LinearLayoutManager.VERTICAL, false)
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
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra(Constants.ID_MEAL_AREA,data.idMeal)
        startActivity(intent)
    }

}