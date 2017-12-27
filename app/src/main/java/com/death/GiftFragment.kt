package com.death

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rajora_sd.bottonnaviagtionbartutorial.R


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [GiftFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [GiftFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GiftFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_gift, container, false)
    }

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"
        fun newInstance(param1: String, param2: String): GiftFragment {
            val fragment = GiftFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}
