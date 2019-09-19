package com.example.tcapp

data class ContactInfo (val name: String, val phoneNumber: String){
    override fun toString(): String {
        return name
    }
}