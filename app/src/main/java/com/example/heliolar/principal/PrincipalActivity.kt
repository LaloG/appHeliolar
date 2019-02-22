package com.example.heliolar.principal

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.heliolar.R
import kotlinx.android.synthetic.main.fragment_battery.*

class PrincipalActivity : AppCompatActivity(), BatteryFragment.OnFragmentInteractionListener, CeldasFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val celdasFragment      = CeldasFragment()
        val heliolarFragment    = HeliolarFragment()
        val batteryFragment     = BatteryFragment()

        supportFragmentManager.beginTransaction().add(R.id.container_principal_fragments, batteryFragment).commit()




    }

    override fun onFragmentInteraction(uri: Uri) {
    }
}
