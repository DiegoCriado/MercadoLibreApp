package com.example.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mercadolibreapp.R
import com.example.models.Product
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    val args: DetailsFragmentArgs by navArgs()

    lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        product = args.product

        product_name_details_txt.text = product.name
        Glide.with(requireContext()).load(product.image).into(product_image_details)
        val price = product.price
        product_price_details_txt.text = "$$price"

        buy_now_btn.setOnClickListener {
            Toast.makeText(requireContext(), "No es posible comprar en este momento", Toast.LENGTH_LONG).show()
        }
    }
}