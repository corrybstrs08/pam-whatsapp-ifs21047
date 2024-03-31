package com.ifs21047.whatsapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Call(
    var nama: String,
    var gambar: Int,
    var panggilan: Int,
    var panah: Int,
    var waktu: String
) : Parcelable


