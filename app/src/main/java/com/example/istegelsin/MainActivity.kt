package com.example.istegelsin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import com.example.istegelsin.databinding.ActivityMainBinding
import com.example.istegelsin.databinding.HomeCategoryOneBinding
import com.example.istegelsin.databinding.HomeCategoryTwoBinding
import com.example.istegelsin.domain.Categories
import com.example.istegelsin.domain.HomogeneousRecyclerAdapter
import com.example.istegelsin.domain.Product
import com.example.istegelsin.presentation.CategoryViewModel
import com.example.istegelsin.presentation.HomeUIState
import com.example.istegelsin.presentation.product.ProductAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class MainActivity : AppCompatActivity() {


    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding
    private var categoryViewModel: CategoryViewModel = get()

    var pList: List<Product>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchViewHome.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                categoryViewModel.getProducts("","${p0}")
                return false
            }})


        lifecycleScope.launch {


            categoryViewModel.homeState.collect {
                when (it) {
                    is HomeUIState.PageSuccess -> {
                        it.categoryList.let {
                            binding.categoryProductOne.adapter =
                                HomogeneousRecyclerAdapter<HomeCategoryOneBinding,
                                        Categories>(
                                    it,
                                    R.layout.home_category_one,
                                    BR.categoryOne
                                ) {

                                    binding.categoryProductTwo.adapter =
                                        HomogeneousRecyclerAdapter<HomeCategoryTwoBinding,
                                                Categories>(
                                            it.subcategories!!,
                                            R.layout.home_category_two,
                                            BR.categoryTwo
                                        ) {

                                            categoryViewModel.getProducts(it.id!!, "")

                                        }


                                }
                        }

                    }
                    is HomeUIState.ProductSuccess -> {
                        it.productList.let {
                            binding.categoryCard.adapter = ProductAdapter(it)
                            pList = it

                        }
                    }
                }
            }
        }
        categoryViewModel.getLists()

    }
}
