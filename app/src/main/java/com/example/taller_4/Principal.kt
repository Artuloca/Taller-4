// Principal.kt
package com.example.taller_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taller_4.ui.ItemDetailFragment
import com.example.taller_4.ui.ItemListFragment

class Principal : AppCompatActivity(), ItemListFragment.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ItemListFragment())
                .commit()
        }
    }

    override fun onItemSelected(item: ItemListFragment.Item) {
        val detailFragment = ItemDetailFragment.newInstance(item)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailFragment)
            .addToBackStack(null)
            .commit()
    }
}