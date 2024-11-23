package com.example.taller_4.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.taller_4.R

class ItemListFragment : Fragment() {

    private var listener: OnItemSelectedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnItemSelectedListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnItemSelectedListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        val listView: ListView = view.findViewById(R.id.item_list)
        val items = listOf(
            Item("Item 1", "Description for Item 1"),
            Item("Item 2", "Description for Item 2"),
            Item("Item 3", "Description for Item 3")
        )
        val adapter = ItemAdapter(requireActivity(), items)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            listener?.onItemSelected(items[position])
        }
        return view
    }

    interface OnItemSelectedListener {
        fun onItemSelected(item: Item)
    }

    data class Item(val name: String, val description: String)

    class ItemAdapter(context: Context, private val items: List<Item>) :
        ArrayAdapter<Item>(context, 0, items) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context).inflate(
                R.layout.item_list, parent, false
            )
            val item = items[position]
            val itemName = view.findViewById<TextView>(R.id.item_name)
            itemName.text = item.name
            return view
        }
    }
}