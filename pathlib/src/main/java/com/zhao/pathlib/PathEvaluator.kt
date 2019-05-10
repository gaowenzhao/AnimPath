package com.zhao.pathlib

import android.animation.TypeEvaluator
import android.util.Log

class PathEvaluator : TypeEvaluator<PathPoint> {
    override fun evaluate(fraction: Float, startValue: PathPoint, endValue: PathPoint): PathPoint {
        var pointX = 0.0f
        var pointY = 0.0f
        when(endValue.type){
            PathPoint.LINE->{
                pointX =  startValue.pointX+fraction*(endValue.pointX-startValue.pointX)
                pointY =  startValue.pointY+fraction*(endValue.pointY-startValue.pointY)
                Log.i("PathEvaluator","LINE")
            }
            PathPoint.CUBIC->{
               val oneMinusF = 1-fraction
               pointX = oneMinusF*oneMinusF*oneMinusF*startValue.pointX+
                       3*oneMinusF*oneMinusF*fraction*endValue.c0x+
                       3*oneMinusF*fraction*fraction*endValue.c1x+
                       fraction*fraction*fraction*endValue.pointX

               pointY = oneMinusF*oneMinusF*oneMinusF*startValue.pointY+
                        3*oneMinusF*oneMinusF*fraction*endValue.c0y+
                        3*oneMinusF*fraction*fraction*endValue.c1y+
                        fraction*fraction*fraction*endValue.pointY
            }
            else->{
                pointX = endValue.pointX
                pointY = endValue.pointY
                Log.i("PathEvaluator","else")
            }
        }
        return PathPoint(PathPoint.MOVE,pointX,pointY)
    }

}
