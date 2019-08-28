package com.sinch.audio.video

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties

data class User (

    var name: String? = "",
    var email: String? = "",
    var password: String? = ""




)
