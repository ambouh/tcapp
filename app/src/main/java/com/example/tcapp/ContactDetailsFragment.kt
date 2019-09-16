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
        fun newInstance(): ContactDetailsFragment {
            return  ContactDetailsFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.contact_details_fragment, container, false)
    }
}