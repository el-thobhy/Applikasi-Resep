package com.elthobhy.applikasiresep.ui.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.DomainSearch
import com.elthobhy.applikasiresep.core.utils.Constants
import com.elthobhy.applikasiresep.core.utils.Status
import com.elthobhy.applikasiresep.databinding.ActivitySearchBinding
import com.elthobhy.applikasiresep.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var adapterSearch: AdapterSearch
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySearchBinding.inflate(layoutInflater)
        adapterSearch = AdapterSearch()
        setContentView(binding.root)
        searchView=binding.search
        searchList()
        showRv()
    }

    private fun showRv() {
        binding.rvSearch.apply {
            layoutManager=LinearLayoutManager(this@SearchActivity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = adapterSearch
        }
        adapterSearch.setOnClickCallback(object : AdapterSearch.OnItemClickCallback{
            override fun onClicked(data: DomainSearch) {
                goDetail(data)
            }
        })
    }

    private fun goDetail(data: DomainSearch) {
        val intent = Intent(this@SearchActivity, DetailActivity::class.java)
        intent.putExtra(Constants.ID_MEAL,data.idMeal)
        startActivity(intent)
    }

    private fun searchList() {
        searchViewModel.searchResult.observe(this@SearchActivity, observerSearch)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return if(!newText.isNullOrEmpty()){
                    searchViewModel.queryChannel.value = newText
                    true
                }else {
                    true
                }
            }
        })
    }
    private val observerSearch = Observer<Resource<List<DomainSearch>>> {data ->
        binding.apply {
            when(data.status){
                Status.LOADING -> {}
                Status.SUCCESS -> {
                    adapterSearch.submitList(data.data)
                    Log.e("data", ": ${data.data}" )
                }
                Status.ERROR -> {
                    Toast.makeText(this@SearchActivity,"Error: ${data.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}