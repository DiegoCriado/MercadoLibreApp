package com.example.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mercadolibreapp.MainViewModel
import com.example.mercadolibreapp.R
import com.example.models.ProductListWeb
import com.example.networking.RetrofitClient
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SearchFragment : Fragment(){
    val viewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search_btn.setOnClickListener {
            if(searcher_txt.text.isNullOrEmpty()){
                Toast.makeText(context, "Complete el campo de busqueda", Toast.LENGTH_SHORT).show()
            }else{
                var query = searcher_txt.text.toString()
                viewModel.query = query
                findNavController().navigate(R.id.action_searchFragment_to_productsFragment)
            }
        }

    }

}