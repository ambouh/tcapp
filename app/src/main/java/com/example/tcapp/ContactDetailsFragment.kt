package com.example.tcapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import java.lang.ClassCastException

class ContactDetailsFragment: Fragment() {
    companion object {
        fun newInstance(): ContactListFragment {
            return  ContactListFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.contact_details_fragment, container, false)
        return rootView
    }
}