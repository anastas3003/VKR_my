package com.example.nir

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class PlacePage : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var imButton: ImageButton
    private lateinit var addProduct: Button
    private lateinit var productList: RecyclerView
    private lateinit var productName: TextView
    private lateinit var mProductListAdapter: ProductListAdapter

    private var modelToBeUpdated: Stack<ProductModel> = Stack()

    private val mOnProductClickListener = object : OnProductClickListener {
        override fun onUpdate(position: Int, model: ProductModel) {

            // we want to update
            modelToBeUpdated.add(model)
            productName.text = model.name
        }

        override fun onDelete(model: ProductModel) {

            mProductListAdapter.removeProduct(model)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_page)

        val inflater = LayoutInflater.from(this)
        val layout: View = inflater.inflate(R.layout.activity_attr_page, null, false)

        val buttonClicked21 = intent.getStringExtra("buttonClicked21")
        imButton = findViewById(R.id.imageButton3)

        productList = findViewById(R.id.product_list_recycler_view)
        productName = layout.findViewById(R.id.textView16)


        productList.layoutManager = LinearLayoutManager(this)
        productList.setHasFixedSize(true)

        mProductListAdapter = ProductListAdapter(this, mOnProductClickListener)
        productList.adapter = mProductListAdapter

        button = findViewById(R.id.button4)
        button.setOnClickListener()
        {
            finish()
        }

        imButton.setOnClickListener {
        }


        addProduct = findViewById(R.id.add_product)
        addProduct.setOnClickListener {

            val name = intent.getStringExtra("text")
            // set the value of the clicked item in the edit text

            // prepare id on incremental basis
            val id = mProductListAdapter.getNextItemId()

            // prepare model for use
            val model = ProductModel(id, name)

            // add model to the adapter
            mProductListAdapter.addProduct(model)

        }
    }



}

class ProductListAdapter(
    private val mContext: Context,
    private val mOnProductClickListener: OnProductClickListener,
    private val mProductList: ArrayList<ProductModel> = ArrayList(),
) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.item, parent, false)
        val holder = ProductViewHolder(view)

        // item view is the root view for each row
        holder.itemView.setOnClickListener {

            // adapterPosition give the actual position of the item in the RecyclerView
            val position = holder.adapterPosition
            val model = mProductList[position]

            // remove the Rs. prefix before sending the model for editing
            mOnProductClickListener.onUpdate(position, model)
        }

        // to delete the item in recycler view
        holder.productDelete.setOnClickListener {
            val position = holder.adapterPosition
            val model = mProductList[position]
            mOnProductClickListener.onDelete(model)
        }

        return holder
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        // data will be set here whenever the system thinks it's required

        // get the product at position
        val product = mProductList[position]

        holder.productName.text = product.name
    }

    /**
     * Returns the total number of items in the list to be displayed.
     * this will refresh when we call notifyDataSetChanged() or other related methods.
     */
    override fun getItemCount(): Int {
        return mProductList.size
    }

    /**
     * Adds each item to list for recycler view.
     */
    fun addProduct(model: ProductModel) {
        mProductList.add(model)
        // notifyDataSetChanged() // this method is costly I avoid it whenever possible
        notifyItemInserted(mProductList.size)
    }


    /**
     * Removes the specified product from the list.
     *
     * @param model to be removed
     */
    fun removeProduct(model: ProductModel) {
        val position = mProductList.indexOf(model)
        mProductList.remove(model)
        notifyItemRemoved(position)
    }

    fun getNextItemId(): Int {
        var id = 1
        if (mProductList.isNotEmpty()) {
            // .last is equivalent to .size() - 1
            // we want to add 1 to that id and return it
            id = mProductList.last().id + 1
        }
        return id
    }

    /**
     * ViewHolder implementation for holding the mapped views.
     */
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.item_name)
        val productDelete: ImageView = itemView.findViewById(R.id.delete)
    }

}

data class ProductModel(
    var id: Int = 0,
    var name: String? = " ",
)

interface OnProductClickListener {

    /**
     * When the user clicks on each row this method will be invoked.
     */
    fun onUpdate(position: Int, model: ProductModel)

    /**
     * when the user clicks on delete icon this method will be invoked to remove item at position.
     */
    fun onDelete(model: ProductModel)

}