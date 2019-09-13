package com.example.tcapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import java.lang.ClassCastException


// 1
class LoginFragment: Fragment() {
    private lateinit var btnListener: FragmentChangeListener


    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is FragmentChangeListener) {
            btnListener = context
        } else {
            throw ClassCastException("$context must implement FragmentChangeListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.login_fragment, container,false)
        val goToContactList = rootView.findViewById(R.id.goToContactList) as Button

        goToContactList.setOnClickListener{
            showOtherFragment()
        }
        return rootView
    }

    private fun showOtherFragment() {
        val fr = ContactListFragment.newInstance()
        val fc = btnListener
        fc.replaceFragment(fr)
    }
}



