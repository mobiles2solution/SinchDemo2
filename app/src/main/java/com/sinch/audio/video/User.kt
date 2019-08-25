package com.sinch.audio.video

class User ( name: String,  email: String) {

    private var name: String? = name
    private var email: String? = email

    fun setName(Name: String) {
        this.name = Name
    }
    fun getName(): String? {
        return name
    }
    fun setEmail(Email: String) {
        this.email = Email
    }
    fun getEmail(): String? {
        return email
    }
}