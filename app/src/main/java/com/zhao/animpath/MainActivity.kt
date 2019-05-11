package com.zhao.animpath

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import com.zhao.pathlib.AmimatorPath

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            animation()
        }
    }
    private fun animation(){
        val mPath = AmimatorPath()
        val p=5
        val pStartX=100f
        val pStartY=100f

        val cP1X=pStartX+50*p
        val cP1Y=pStartY+50*p

        val cP2X=cP1X+100*p
        val cP2Y=pStartY-50*p

        val pEndX=cP2X+50*p
        val pEndY=cP2Y+50*p

        mPath.moveTo(pStartX,pStartY)
        //mPath.lineTo(232f,283f)
        mPath.cubicTo(cP1X,cP1Y,cP2X,cP2Y,pEndX,pEndY)
        mPath.startAnimation(tv_animation,5000)
    }
}
