package com.example.taller_4.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.taller_4.R

class ItemDetailFragment : Fragment() {

    companion object {
        private const val ARG_ITEM_NAME = "item_name"
        private const val ARG_ITEM_DESCRIPTION = "item_description"

        fun newInstance(item: ItemListFragment.Item): ItemDetailFragment {
            val fragment = ItemDetailFragment()
            val args = Bundle()
            args.putString(ARG_ITEM_NAME, item.name)
            args.putString(ARG_ITEM_DESCRIPTION, item.description)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_detail, container, false)
        val itemName = view.findViewById<TextView>(R.id.item_name)
        val itemDescription = view.findViewById<TextView>(R.id.item_description)

        arguments?.let {
            itemName.text = it.getString(ARG_ITEM_NAME)
            itemDescription.text = it.getString(ARG_ITEM_DESCRIPTION)
        }

        return view
    }
}