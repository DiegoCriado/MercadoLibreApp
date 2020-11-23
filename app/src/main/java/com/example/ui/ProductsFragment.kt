package com.example.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.RecyclerAdapter
import com.example.mercadolibreapp.MainViewModel
import com.example.mercadolibreapp.R
import com.example.models.Product
import com.example.models.ProductListWeb
import com.example.networking.MercadoLibreEndpoints
import com.example.networking.RetrofitClient
import kotlinx.android.synthetic.main.fragment_products.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsFragment : Fragment(), RecyclerAdapter.onProductLIstener {

    val viewModel: MainViewModel by activityViewModels()
    lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = RecyclerAdapter(requireContext(), listOf(), this@ProductsFragment)
        setupRecyclerView()

        makeCall()
    }

    /*private fun setupObservers(){
        viewModel.result.observe(viewLifecycleOwner, Observer {
            if(it != null){
                recyclerview_products.visibility = View.VISIBLE
            }
            else {
                recyclerview_products.visibility = View.GONE
                Toast.makeText(requireContext(), "Lista vacia", Toast.LENGTH_SHORT).show()
            }
        })
    }*/

    private fun setupRecyclerView(){
        recyclerview_products.layoutManager = LinearLayoutManager(requireContext())
        recyclerview_products.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        recyclerview_products.adapter = adapter
    }

    private fun makeCall(){
        //viewModel.getSearchResultNotSuspend()

        progress_bar_recycler.visibility = View.VISIBLE
        lifecycleScope.launch {
            val result = viewModel.getSearchResult()
            progress_bar_recycler.visibility = View.GONE
            recyclerview_products.adapter = RecyclerAdapter(requireContext(), result?.result ?: listOf(), this@ProductsFragment)
            if(result != null) {
                recyclerview_products.visibility = View.VISIBLE
            }
            else {
                recyclerview_products.visibility = View.GONE
                Toast.makeText(requireContext(), "Listado vacio", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onProductClick(product: Product) {
        val action = ProductsFragmentDirections.actionProductsFragmentToDetailsFragment(product)
        findNavController().navigate(action)

    }

}

/*
 val listProduct = listOf(
    Product("producto0","https://hipertexta.com/files/2019/04/hipertextual-samsung-galaxy-m20-2019238928.jpg", ""),
    Product("producto1","https://s.fenicio.app/f/muao/productos/s10eblanco_460x460_1552564460_265.jpg", ""),
    Product("producto2","https://s.fenicio.app/f/muao/productos/s10eblanco_460x460_1552564460_265.jpg", ""),
    Product("producto3","https://s.fenicio.app/f/muao/productos/s10eblanco_460x460_1552564460_265.jpg", ""),
    Product("producto4","https://s.fenicio.app/f/muao/productos/s10eblanco_460x460_1552564460_265.jpg", ""),
    Product("producto0","https://hipertextal.com/files/2019/04/hipertextual-samsung-galaxy-m20-2019238928.jpg", ""),
    Product("producto1","https://s.fenicio.app/f/muao/productos/s10eblanco_460x460_1552564460_265.jpg", ""),
    Product("producto2","https://s.fenicio.app/f/muao/productos/s10eblanco_460x460_1552564460_265.jpg", ""),
    Product("producto3","https://s.fenicio.app/f/muao/productos/s10eblanco_460x460_1552564460_265.jpg", ""),
    Product("producto4","https://s.fenicio.app/f/muao/productos/s10eblanco_460x460_1552564460_265.jpg", ""),
    Product("producto5","https://s.fenicio.app/f/muao/productos/s10eblanco_460x460_1552564460_265.jpg", "")
)
*/