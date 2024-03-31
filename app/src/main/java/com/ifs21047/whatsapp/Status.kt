package com.ifs21047.whatsapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Status(
    var nama: String,
    var gambar: Int,
    var jam : String,
) : Parcelable