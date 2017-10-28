package com.hanakusoman.hola

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.Gravity
import android.widget.ArrayAdapter
import com.hanakusoman.hola.models.Category
import com.hanakusoman.hola.services.HoraServiceGenerator
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initTabs()
        initMenuList()

//        setSupportActionBar(toolbar)

//        actionBar.setDisplayHomeAsUpEnabled(true)
//        actionBar.setHomeButtonEnabled(true)
        val drawerToggle = ActionBarDrawerToggle(this, drawer_layout,
                R.string.abc_action_bar_home_description,
                R.string.abc_action_menu_overflow_description)

        drawer_layout.addDrawerListener(drawerToggle)

    }

    override fun onResume() {
        super.onResume()
    }

    private fun initMenuList() {
        val animals = listOf("Rabbit", "Dog", "Cat", "Turtle", "Bear", "Dolphin", "Lion", "Tiger")
        left_drawer.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, animals)
    }

    private fun initTabs() {

        val service = HoraServiceGenerator.createService()
        service.getCategories().enqueue(object : Callback<List<Category>> {
            override fun onFailure(call: Call<List<Category>>?, t: Throwable?) {
                Log.d("" ,"aa")
            }

            override fun onResponse(call: Call<List<Category>>?, response: Response<List<Category>>?) {
                val list = response!!.body()
                list?.let {
                    val adapter = CategoryFragmentPagerAdapter(supportFragmentManager , list!!)
                    pager.adapter = adapter
                    tabs.setupWithViewPager(pager)
                    tabs.tabMode = TabLayout.MODE_SCROLLABLE
                }
            }
        })
    }

    private class CategoryFragmentPagerAdapter(fm: FragmentManager, categories: List<Category>) : FragmentPagerAdapter(fm){

        private val mCategories: List<Category> = categories
        override fun getItem(position: Int): Fragment {
            return ContentFragment.createInstance(mCategories[position])
        }

        override fun getCount(): Int {
            return mCategories.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mCategories[position].name
        }
    }



}
