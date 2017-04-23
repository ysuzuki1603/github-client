package ysuzuki.databinding_recyclerview.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ysuzuki.databinding_recyclerview.R
import ysuzuki.databinding_recyclerview.databinding.ActivityMainBinding
import ysuzuki.databinding_recyclerview.util.SharedPreference
import ysuzuki.databinding_recyclerview.view.search.SearchFragment


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initToolbar()
        initFragment()
    }

    fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_home_black_24dp)
    }

    fun initFragment() {
        val tag = SearchFragment.TAG
        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, SearchFragment.newInstance(), tag)
                    .commit()
        }
    }

}