package com.pruebakt.Services

import com.pruebakt.Models.UsuariosModel
import org.json.JSONObject
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStream
import java.lang.StringBuilder
import java.net.HttpURLConnection
import kotlin.properties.Delegates

class UsuariosService {
    private lateinit var line: String
    private var responseCode by Delegates.notNull<Int>()
    private lateinit var jsonObject: JSONObject
    private lateinit var inputStream: InputStream
    private lateinit var stringBuilder: StringBuilder
    private lateinit var httpURLConnection: HttpURLConnection
    private lateinit var bufferedReader: BufferedReader
    private lateinit var usuariosModel: UsuariosModel
    private lateinit var configService: ConfigService
    private lateinit var params: HashMap<String, String>
    private lateinit var dataOutputStream: DataOutputStream
    private lateinit var boundary: String

    public fun UsuariosService() {
        configService = ConfigService()
    }

    public fun loginUsuario(getUsuariosModel: UsuariosModel): JSONObject? {
        usuariosModel = getUsuariosModel
        params = HashMap<String, String>()
        params.put("usuario", usuariosModel.usuario)
        params.put("password", usuariosModel.password)

        try {
            httpURLConnection = configService.configService("login/usuario", params, "POST")!!



            return jsonObject
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }
}