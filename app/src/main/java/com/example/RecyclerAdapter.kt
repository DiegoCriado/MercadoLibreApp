package com.example

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.base.BaseViewHolder
import com.example.mercadolibreapp.R
import com.example.models.Product
import kotlinx.android.synthetic.main.item_product.view.*

class RecyclerAdapter(val context: Context, var listProducts: List<Product>, private val itemClickListener: onProductLIstener) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface onProductLIstener {
        fun onProductClick(product: Product)
    }

    fun setProducts(listProducts: List<Product>){
        this.listProducts = listProducts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
    //infla la vista que contiene los datos
        return ProductsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_product, parent, false))
    }

    override fun getItemCount(): Int = listProducts.size
        //retorna la lista de datos, la cantidad de items

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        //agarra la lista y pone a cada uno de los elementos la informacion
        when(holder){
            is ProductsViewHolder -> holder.bind(listProducts[position], position)
            else -> throw IllegalAccessException("viewHolder incorrecto, debe pasar un VH")
        }

    }

    inner class ProductsViewHolder(itemView: View) : BaseViewHolder<Product>(itemView) {
        override fun bind(item: Product, position: Int) {

            itemView.setOnClickListener { itemClickListener.onProductClick(item) }

            Glide.with(context).load(item.image).placeholder(android.R.drawable.ic_menu_gallery).into(itemView.product_image)
            itemView.name_product_txt.text = item.name
            itemView.price_product_txt.text = item.price
        }
    }

    private fun filtrarBusqueda(filtroList: ArrayList<Product>){
        listProducts = filtroList
        notifyDataSetChanged()
    }

}


