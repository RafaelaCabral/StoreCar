package org.example.model

data class Carro(
    val id: Int? = null,
    val marca: String,
    val modelo: String,
    val anoFabricacao: Int,
    val anoModelo: Int,
    val km: Int,
    val transmissao: String,
    val valor: Double,
    val cor: String,
    val chassis: String
)
