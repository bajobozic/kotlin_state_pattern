package com.example.bajob.kotlinplayground

import com.example.bajob.kotlinplayground.EnumPlay.TWO
import com.example.bajob.kotlinplayground.EnumPlay.values
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

/**
 * Created by bajob on 2/8/2018.
 */
class EnumPlayTest {
    @Test
    fun testEnumPlay() {
        val t = TWO.temp
        print(t)
        val find: EnumPlay? = values().find { it.temp == t }
        assertEquals(find?.temp, t)
//        val file: File? = null//return from func with no print
        val file: File? = File("C:\\Users\\bajob\\Pictures\\Saved Pictures\\nature1.jpg")//exist
//        val file: File? = File("C:\\Users\\bajob\\Pictures\\Saved Pictures\\nature1")//not exis
        val result = file?.let { it ->
            if (it.exists()) {
                "-exist"
            } else {
                "-not exist"
            }
        } ?: return

        print(result)
    }
}