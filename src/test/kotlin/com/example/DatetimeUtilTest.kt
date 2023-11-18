package com.example

import com.example.plugins.configureRouting
import com.example.utils.DatetimeUtil
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import java.text.SimpleDateFormat
import kotlin.test.Test
import kotlin.test.assertEquals

class DatetimeUtilTest {

    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }

        client.get("/").apply {
            println()
            println()
            println(DatetimeUtil(SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).longToDate(1700256))
            println(DatetimeUtil(SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).dateToLong("1970-01-20 13:17:36.000"))
            println(DatetimeUtil().longToDate(DatetimeUtil().dateToLong("1970-01-20 13:17:36")))
            println()
            println()
            println(DatetimeUtil().dateToLong("2020-12-01 00:00:01"))
            println(DatetimeUtil().currentDatetimeToLong())
            println(DatetimeUtil().currentDatetimeToString())
            println()
            println()

//          Todo: convert the tests above to assert models
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
}