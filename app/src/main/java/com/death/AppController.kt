package com.death

import android.app.Application
import android.text.TextUtils
import com.android.volley.Request
import com.android.volley.toolbox.Volley
import com.android.volley.RequestQueue

/**
 * Created by rajora_sd on 12/26/2017.
 */
class AppController : Application() {

    val TAG = AppController::class.java.simpleName
    private var mRequestQueue:RequestQueue? = null

    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }
    companion object {
        private var mInstance: AppController? = null

        @Synchronized
        fun getInstance(): AppController? {
            return mInstance
        }
    }

    fun getRequestQueue(): RequestQueue? {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(applicationContext)
        }
        return mRequestQueue
    }

    fun <T> addToRequestQueue(req: Request<T>, tag: String) {
        // set the default tag if tag is empty
        req.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        getRequestQueue()?.add(req)
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        req.setTag(TAG)
        getRequestQueue()?.add(req)
    }

    fun cancelPendingRequests(tag: Any) {
        if (mRequestQueue != null) {
            mRequestQueue?.cancelAll(tag)
        }
    }

}