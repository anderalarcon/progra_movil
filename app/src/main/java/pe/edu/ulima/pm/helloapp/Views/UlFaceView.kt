package pe.edu.ulima.pm.helloapp.Views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class UlFaceView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {//para q sea un view tiene que hererdad


    val paint: Paint = Paint();
    var size: Int = 0;

    override fun onDraw(canvas: Canvas?) {
        //Logica de pintado
        super.onDraw(canvas)
        DrawCara(canvas)
        DrawOjos(canvas)
        DrawBoca(canvas)
    }

    override fun onMeasure(//Sirve para recalcular el ancho o algo en base a los cambios de tamñao de la vista
        widthMeasureSpec: Int,
        heightMeasureSpec: Int
    ) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height=View.MeasureSpec.getSize(heightMeasureSpec)
        size= Math.min(width,height)
        setMeasuredDimension(size,size)
    }

    private fun DrawBoca(canvas: Canvas?) {

    }

    private fun DrawOjos(canvas: Canvas?) {

    }

    private fun DrawCara(canvas: Canvas?) {
        paint.color = Color.YELLOW
        paint.style = Paint.Style.FILL

        val radio = size / 2;
        canvas?.drawCircle(size / 2f, size / 2f, radio.toFloat(), paint)

        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        canvas?.drawCircle(size / 2f, size / 2f, radio.toFloat(), paint)
    }


}