package org.example.connection

import java.sql.Connection
import java.sql.DriverManager

object ConexaoDB {
    private val url = "jdbc:postgresql://localhost:5432/lojaCarro"
    private val user = "rafaela"
    private val password = "rafa123"

    fun getConnection(): Connection {
        return DriverManager.getConnection(url, user, password)
    }
}