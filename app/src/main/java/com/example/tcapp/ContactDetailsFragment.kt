package com.example.tcapp

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.contact_details_fragment.*
import java.lang.ClassCastException

class ContactDetailsFragment: Fragment() {
    private var notePosition = POSITION_NOT_SET
    private lateinit var textName: EditText
    private lateinit var textPhone: EditText

    companion object {
        fun newInstance(): ContactDetailsFragment {
            return  ContactDetailsFragment()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        arguments?.getInt(EXTRA_CONTACT_POSITION)?.let {
            notePosition = it
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView:View = inflater.inflate(R.layout.contact_details_fragment, container, false)

        if(notePosition !=  POSITION_NOT_SET){
            displayContact(rootView)
        }

        return rootView
    }

    private fun displayContact(view: View) {
        val contact = DataManager.contacts[notePosition]
        textName = view.findViewById(R.id.textName)
        textPhone = view.findViewById(R.id.textPhone)

        textName.setText(contact.name)
        textPhone.setText(contact.phoneNumber)
    }
}