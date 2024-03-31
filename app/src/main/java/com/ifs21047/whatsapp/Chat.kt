package com.ifs21047.whatsapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Chat (
    var nama: String,
    var gambar: Int,
    var pesan : String,
    val tanggal : String,
) : Parcelable