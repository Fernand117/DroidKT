package com.pruebakt.Services

import java.io.DataOutputStream
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class ConfigService {
    private lateinit var url: URL
    private lateinit var subParams: StringBuilder
    private lateinit var connection: HttpURLConnection
    private lateinit var dataOuputStream: DataOutputStream
    private lateinit var paramsString: String
    private lateinit var boundary: String

    private var urlBase: String = "http://dbz-search.com/api/"
    private val charset: String = "UTF-8"

    companion object {
        const val logMessage: String = "RespServer"
    }

    public fun configService(urlComplement: String, params: HashMap<String, String>, method: String): HttpURLConnection? {
        urlBase = urlBase + urlComplement

        if (params != null) {
            subParams = StringBuilder()
            var i: Int = 0
            for (key: String in params.keys) {
                try {
                    if (i !=  0) subParams.append("&")
                    subParams.append(key).append("=").append(URLEncoder.encode(params.get(key), charset))
                } catch (e: UnsupportedEncodingException)  {
                    e.printStackTrace()
                }
                i++
            }
        }

        try {
            url = URL(urlBase)
            connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.setRequestProperty("Accept-Charset", charset)
            connection.connectTimeout = 150000

            if (method.equals("GET")) {
                if (subParams.length != 0) urlBase += "?" + subParams.toString()
                connection.requestMethod = "GET"
                connection.connect()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return null
    }
}