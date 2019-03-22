package de.g8keeper.mykotlinfinal

import android.os.Build
import android.support.annotation.RequiresApi
import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator
import kotlin.text.Typography.greater

val name: String = "Hallo"
private val name_global: String = "Welt"


@RequiresApi(Build.VERSION_CODES.N)
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },

    MINUS {
        override fun apply(t: Int, u: Int): Int = t - u
    },

    MAL {
        override fun apply(t: Int, u: Int): Int = t * u
    },

    GETEILT {
        override fun apply(t: Int, u: Int): Int = t / u
    };

    override fun applyAsInt(left: Int, right: Int): Int = apply(left, right)
}


interface MyInterface {
    val prop1: Int
        get() = prop1

    var prop2: Int


    fun bar() {
        print("MyInterface")
    }

    fun foo()

}

interface MyInterface2 {
    val prop1: Int
        get() = 100
    var prop2: Int

    fun bar() {
        print("MyInterface2")
    }

    fun foo()

}

class Parent1() : MyInterface, MyInterface2 {
    protected val name2: String = "Hallo"


    override fun bar() {
        super<MyInterface>.bar()
    }

    override val prop1: Int = 42
    override var prop2: Int = 0

    var prop3: Int = 1
        get() = field + 100
        set(value) {
            when {
                value > 100 -> field = value
                value in 0..99 -> value

                else -> field = value
            }

//            when(value){
//                in 0..99 -> value
//                in 100..Int.MAX_VALUE -> field = value - 10
//
//                else -> field = value
//            }
        }


    override fun foo() {
        super<MyInterface2>.prop1 + prop1
    }
}

open class A {
    open fun doIt(value: String = "Default String") {
        print(value)
    }

    fun setParams(b1: Boolean = true, b2: Boolean = true, str: String) {

    }
}

class B : A() {
    override fun doIt(value: String) {
        print(value + "...")
        A().doIt()
        A().setParams(b2 = false, str = "Hallo")
    }
}