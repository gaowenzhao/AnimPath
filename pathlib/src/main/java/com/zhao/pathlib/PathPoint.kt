package com.zhao.pathlib

class PathPoint(val type:Int = MOVE,val pointX:Float = 0.0f,val pointY:Float = 0.0f,
                val c0x:Float = 0.0f,val c0y:Float = 0.0f,val c1x:Float = 0.0f,val c1y:Float = 0.0f)  {
     companion object{
         const val MOVE = 0
         const val LINE = 1
         const val  CUBIC = 2 //贝塞尔曲线
     }
}
