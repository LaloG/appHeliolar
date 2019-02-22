package com.example.heliolar.tutorial

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.heliolar.R
import com.example.heliolar.principal.PrincipalActivity
import kotlinx.android.synthetic.main.activity_tutorial.*
import kotlinx.android.synthetic.main.activity_tutorial.view.*
import kotlinx.android.synthetic.main.layout_btn_tutorial.*
import kotlinx.android.synthetic.main.layout_btn_tutorial.view.*
import java.util.zip.Inflater

class TutorialActivity : AppCompatActivity(), OneFragment.OnFragmentInteractionListener,
    TwoFragment.OnFragmentInteractionListener, ThreeFragment.OnFragmentInteractionListener, ForthFragment.OnFragmentInteractionListener {

    lateinit var twoFragment    : TwoFragment
    lateinit var oneFragment    : OneFragment
    lateinit var threeFragment  : ThreeFragment
    lateinit var forthFragment  : ForthFragment
    var count = 0
    var listFragment = arrayListOf<Fragment>()
    lateinit var frameLayout: FrameLayout
    lateinit var vista: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        twoFragment     = TwoFragment()
        oneFragment     = OneFragment()
        threeFragment   = ThreeFragment()
        forthFragment   = ForthFragment()
        frameLayout     = framelayout_botones

        listFragment.add(oneFragment)
        listFragment.add(twoFragment)
        listFragment.add(threeFragment)
        listFragment.add(forthFragment)

        vista = layoutInflater.inflate(R.layout.layout_btn_tutorial, null)

        if(count == 0){
            btn_back.visibility = View.INVISIBLE
            supportFragmentManager.beginTransaction().add(R.id.contenedor, listFragment[count]).commit()
        }

        vista.btn_finalizar.setOnClickListener {
            val i = Intent(this, PrincipalActivity::class.java)
            startActivity(i)
        }
    }


    fun onClickSiguinte(v: View){
        count++
        Log.d("Next", count.toString())

        if(count == 1){
            supportFragmentManager.beginTransaction().replace(R.id.contenedor, listFragment[count]).addToBackStack(null).commit()
            btn_back.visibility = View.VISIBLE
        }
        if(count == 3){

            //val view = layoutInflater.inflate(R.layout.layout_btn_tutorial, null)

            frameLayout.removeAllViews()
            frameLayout.addView(vista)

            /*vista.btn_finalizar.setOnClickListener {
                val i = Intent(this, PrincipalActivity::class.java)
                startActivity(i)
            }*/

            supportFragmentManager.beginTransaction().replace(R.id.contenedor, listFragment[count]).addToBackStack(null).commit()

        }
        else{
            supportFragmentManager.beginTransaction().replace(R.id.contenedor, listFragment[count]).addToBackStack(null).commit()

        }



    }

    fun onClickAntes(v: View){
        //Log.d("TUTORIAL", count.toString())
        count--
        Log.d("Back", count.toString())
        if(count == 0){
            onBackPressed()
            btn_back.visibility = View.INVISIBLE
        }else{
            onBackPressed()
        }


    }

    fun onFinalizar(v: View){
        val i = Intent(this, PrincipalActivity::class.java)
        startActivity(i)
    }

    override fun onFragmentInteraction(uri: Uri) {
    }
}
