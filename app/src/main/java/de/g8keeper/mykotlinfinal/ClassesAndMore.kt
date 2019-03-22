package de.g8keeper.mykotlinfinal

import android.os.Build
import android.support.annotation.RequiresApi
import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator
import kotlin.text.Typography.greater




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
    override fun bar() {
        super<MyInterface>.bar()
    }

    override val prop1: Int = 42
    override var prop2: Int = 0

    var prop3: Int = 1
        get() = field + 100
        set(value) {
            when{
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