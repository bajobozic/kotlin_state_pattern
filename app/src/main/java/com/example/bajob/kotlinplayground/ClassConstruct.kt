package com.example.bajob.kotlinplayground

/**
 * Created by bajob on 2/4/2018.
 */
class SomeClass {
    var age: Int
    val name: String

    init {
        age = 0
        name = "savo"
    }

}

fun someMethode(newage: Int): SomeClass {
    return SomeClass().apply { age = newage }

}