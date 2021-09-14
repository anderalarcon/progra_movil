package pe.edu.ulima.pm.helloapp.Views

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import pe.edu.ulima.pm.helloapp.R

interface OnFaceClickcListener {
    fun OnClick()


}

class UlFaceView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {//para q sea un view tiene que hererdad


    private val paint: Paint = Paint();
    private var size: Int = 0;
    private var listener: OnFaceClickcListener? = null;


    var moutHeight: Float = 0f;
    var color:Int=Color.YELLOW



    init {/*Si el contexto es nulo estaria bien que se caiga*/
        val a: TypedArray = context!!.theme.obtainStyledAttributes( /*Es de tipo array*/
            attrs,
            R.styleable.UlFaceView,
            0,
            0
        )/*Usaremos los atributes del view*/

        color=a.getColor(R.styleable.UlFaceView_valueColor,Color.YELLOW)
    }

    fun setOnFaceListener(listener: OnFaceClickcListener) {
        this.listener = listener

    }

/*
    clase implementar una interface y va poder setearse como listener por lo tanto cuanto sucenda un evento de ui automaticante vamos a propagar ese evcento al listener que esta inscrito*/

    override fun onTouchEvent(event: MotionEvent?): Boolean {// a penas el usuario toque se va activar
        listener?.OnClick();//cada vez q toque simulamos que hace click y esa func click esta definida en ejemplo activity
        invalidate()//vuelve a pintar este componente
        return super.onTouchEvent(event)
    }

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
        val height = View.MeasureSpec.getSize(heightMeasureSpec)
        size = Math.min(width, height)
        setMeasuredDimension(size, size)
        if (moutHeight == 0f) {
            moutHeight = size / 8f
        }

        //se llama siempre que cambie el tamaño de la vista
    }

    private fun DrawBoca(canvas: Canvas?) {
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        val mouthWidth = size / 2f;
        // val moutHeight = size / 8f;

        val mouthRect = RectF(
            size / 2f - mouthWidth / 2f,
            (3f * size / 4f) - moutHeight / 2f,
            size / 2f + mouthWidth / 2f,
            (3 * size) / 4f + moutHeight / 2f,
        )
        canvas?.drawOval(mouthRect, paint)


    }

    private fun DrawOjos(canvas: Canvas?) {
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        val eyeWidth = size / 8;
        val leftEyeRect = RectF(
            size / 4f - eyeWidth / 2f,
            size / 4f - eyeWidth / 2f,
            size / 4f + eyeWidth / 2f,
            size / 4f + eyeWidth / 2f
        )//1/4TO DEL RADIO - ANCHO DE OJOS
        val rightEyeRect = RectF(
            (3 * size) / 4f - eyeWidth / 2f,
            size / 4f - eyeWidth / 2f,
            (3 * size) / 4f + eyeWidth / 2f,
            size / 4f + eyeWidth / 2f
        )

        canvas?.drawOval(leftEyeRect, paint)
        canvas?.drawOval(rightEyeRect, paint)

        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
    }

    private fun DrawCara(canvas: Canvas?) {
        paint.color = color
        paint.style = Paint.Style.FILL

        val radio = size / 2;
        canvas?.drawCircle(size / 2f, size / 2f, radio.toFloat(), paint)

        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        canvas?.drawCircle(size / 2f, size / 2f, radio.toFloat(), paint)
    }


}