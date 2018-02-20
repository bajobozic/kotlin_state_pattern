package com.example.bajob.kotlinplayground

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by bajob on 2/4/2018.
 */
class SomeClassTest {
    @Test
    fun testSomeMethode() {

        val newage = 54
        val res=someMethode(newage)
        assertTrue("age is equals newage",res.age == newage )
    }

}