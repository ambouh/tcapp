package com.example.tcapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.contact_list_fragment.*
import java.lang.ClassCastException

class ContactListFragment: Fragment() {
    private lateinit var btnListener: FragmentChangeListener

    companion object {
        fun newInstance(): ContactListFragment {
            return ContactListFragment()
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
        val rootView = inflater.inflate(R.layout.contact_list_fragment, container,false)
        val fragmentActivity = rootView.context
        val listContacts: ListView = rootView.findViewById(R.id.listContacts)

        listContacts.adapter = ArrayAdapter(fragmentActivity, android.R.layout.simple_list_item_1, DataManager.contacts)

        listContacts.setOnItemClickListener{parent, view, position, id ->
            showOtherFragment(position)
        }

        return rootView
    }

    private fun showOtherFragment(contactPosition: Int) {
        val fr = ContactDetailsFragment.newInstance()
        val bundle = Bundle()

        bundle.putInt(EXTRA_CONTACT_POSITION, contactPosition)
        Log.d("AAA", bundle.getInt(EXTRA_CONTACT_POSITION).toString())
        fr.arguments = bundle

        val fc = btnListener
        fc.replaceFragment(fr)
    }
}
