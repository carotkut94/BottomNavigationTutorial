package com.death

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.android.volley.Response
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson
import org.json.JSONArray
import com.android.volley.toolbox.JsonArrayRequest
import com.example.rajora_sd.bottonnaviagtionbartutorial.R


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [StoreFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [StoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StoreFragment : Fragment() {
    private lateinit var recyclerView:RecyclerView
    private val TAG = StoreFragment::class.java.simpleName
    private val URL = "https://api.androidhive.info/json/movies_2017.json"
    private var movieList: ArrayList<MoviesPojo> = arrayListOf()
    private var mAdapter: StoreAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view =  inflater?.inflate(R.layout.fragment_store, container, false)
        recyclerView = view!!.findViewById(R.id.recycler_view)
        val mLayoutManager = GridLayoutManager(activity, 3)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.addItemDecoration(GridItemDecorator(20))
        recyclerView.itemAnimator = DefaultItemAnimator()
        mAdapter = StoreAdapter(context, movieList)
        recyclerView.adapter = mAdapter
        recyclerView.isNestedScrollingEnabled = false
        fetchStoreItems()
        return  view
    }
    private fun fetchStoreItems() {
        val request = JsonArrayRequest(URL, Response.Listener<JSONArray> { response ->
            if (response!=null){
                Log.e(TAG, response.toString())
                val items:ArrayList<MoviesPojo> = Gson().fromJson(response.toString(), object : TypeToken<List<MoviesPojo>>() {}.type)
                movieList.clear()
                movieList.addAll(items)
                mAdapter?.notifyDataSetChanged()
            }
        }, Response.ErrorListener { error ->
            if (error!=null){
                Log.e(TAG, error.toString())
            }
        })
        AppController.getInstance()?.addToRequestQueue(request)
    }
}
