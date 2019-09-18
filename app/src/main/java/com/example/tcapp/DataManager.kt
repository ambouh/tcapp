package com.example.tcapp

object DataManager {
    val contacts = ArrayList<ContactInfo>()

    init {
        initializeContacts()
    }

    private fun initializeContacts() {
        var contact = ContactInfo("Adam Armstrong", "800-111-1111")
        contacts.add(contact)

        contact = ContactInfo("Beatrice Booker", "800-222-2222")
        contacts.add(contact)

    }
}