package com.zhao.pathlib

import android.animation.ObjectAnimator
import android.view.View
import java.util.*

class AmimatorPath {
    private lateinit var mView: View
    private val pathPointList = ArrayList<PathPoint>()
    fun moveTo(pointX: Float, ponitY: Float) {
        val pathPoint = PathPoint(PathPoint.MOVE,pointX,ponitY)
        pathPointList.add(pathPoint)
    }

    fun lineTo(pointX: Float, ponitY: Float) {
        val pathPoint = PathPoint(PathPoint.LINE,pointX,ponitY)
        pathPointList.add(pathPoint)
    }

    fun cubicTo(c0x: Float, c0y: Float, c1x: Float, c1y: Float, pointX: Float, ponitY: Float) {
        val pathPoint = PathPoint(PathPoint.CUBIC,pointX,ponitY,c0x,c0y,c1x,c1y)
        pathPointList.add(pathPoint)
    }

    fun startAnimation(view: View, duration: Long) {
        mView = view
       val objectAnimator =  ObjectAnimator.ofObject(this,"translationXY",PathEvaluator(),*(pathPointList.toArray()))
        objectAnimator.duration = duration
        objectAnimator.start()
    }
    fun setTranslationXY(pathPoint: PathPoint){
        mView.translationX = pathPoint.pointX
        mView.translationY = pathPoint.pointY
    }
}
