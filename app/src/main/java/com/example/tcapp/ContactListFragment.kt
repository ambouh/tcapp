package com.example.tcapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.lang.ClassCastException

class ContactListFragment: Fragment() {

    companion object {
        fun newInstance(): ContactListFragment {
            return ContactListFragment()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return (inflater.inflate(R.layout.contact_list_fragment, container, false))
    }
}