package com.ifs21047.whatsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.ifs21047.whatsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupAction()

    }
    private fun setupView() {
        binding.inAppBar.toolbar.overflowIcon =
            ContextCompat.getDrawable(this, R.drawable.ic_more_vert)
        loadFragment(FLAG_FRAGMENT_CHAT)
    }
    private fun setupAction() {
        binding.inAppBar.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.inAppBar.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_search -> {
                    loadFragment(FLAG_FRAGMENT_CHAT, "Memilih menu Add!")
                    true
                }
                R.id.action_camera -> {
                    loadFragment(FLAG_FRAGMENT_CHAT, "Memilih menu Settings!")
                    true
                }
                R.id.grup_baru -> {
                    loadFragment(FLAG_FRAGMENT_CHAT, "Memilih menu Logout!")
                    true
                }
                R.id.siaran_baru -> {
                    loadFragment(FLAG_FRAGMENT_CHAT, "Memilih menu Logout!")
                    true
                }
                R.id.perangkat_tertaut -> {
                    loadFragment(FLAG_FRAGMENT_CHAT, "Memilih menu Logout!")
                    true
                }
                R.id.pesan_berbintang -> {
                    loadFragment(FLAG_FRAGMENT_CHAT, "Memilih menu Logout!")
                    true
                }
                R.id.setelan -> {
                    loadFragment(FLAG_FRAGMENT_CHAT, "Memilih menu Logout!")
                    true
                }
                else -> true
            }
        }
        binding.inAppBar.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_chat -> {
                    loadFragment(FLAG_FRAGMENT_CHAT)
                    true
                }
                R.id.navigation_updates -> {
                    loadFragment(FLAG_FRAGMENT_STATUS)
                    true
                }
                R.id.navigation_comunity -> {
                    loadFragment(FLAG_FRAGMENT_KOMUNITAS)
                    true
                }
                R.id.navigation_call -> {
                    loadFragment(FLAG_FRAGMENT_CALL)
                    true
                }
                else -> true
            }
        }
        binding.inAppBar.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                // kode menu lainnya...
                R.id.detail -> {
                    startActivity(Intent(this, DetailChatActivity::class.java))
                    true
                }
                else -> true
            }
        }

    }

    private fun loadFragment(flag: String, message: String? = null) {
        val fragmentManager = supportFragmentManager
        val fragmentContainerId =
            binding.inAppBar.inContentMain.frameContainer.id
        when (flag) {
            FLAG_FRAGMENT_CHAT -> {
                binding.inAppBar.bottomNavView
                    .menu
                    .findItem(R.id.navigation_chat)
                    .setChecked(true)
                val chatFragment = ChatFragment() // Perubahan di sini
                fragmentManager
                    .beginTransaction()
                    .replace(
                        fragmentContainerId,
                        chatFragment,
                        ChatFragment::class.java.simpleName
                    )
                    .commit()
            }

            FLAG_FRAGMENT_STATUS -> {
                val statusFragment = StatusFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(StatusFragment::class.java.simpleName)
                if (fragment !is StatusFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            statusFragment,
                            StatusFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_KOMUNITAS -> {
                val komunitasFragment = KomunitasFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(KomunitasFragment::class.java.simpleName) // Perubahan di sini
                if (fragment !is KomunitasFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            komunitasFragment,
                            KomunitasFragment::class.java.simpleName
                        )
                        .commit()
                }
            }

            FLAG_FRAGMENT_CALL -> {
                val callFragment = CallFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(CallFragment::class.java.simpleName)
                if (fragment !is CallFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            callFragment,
                            CallFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
        }
    }


    companion object {
        val EXTRA_STATUS = "extra_status"
        const val EXTRA_CALL = "extra_call"
        const val FLAG_FRAGMENT_CHAT = "fragment_chat"
        const val FLAG_FRAGMENT_STATUS = "fragment_status"
        const val FLAG_FRAGMENT_KOMUNITAS = "fragment_komunitas"
        const val FLAG_FRAGMENT_CALL = "fragment_call"
        const val FLAG_FRAGMENT_DETAIL_CHAT = "fragment_detail_chat"
    }
}
