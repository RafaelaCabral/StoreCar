package org.example

import org.example.model.Carro
import org.example.service.CarroService

fun main() {
    val service = CarroService()

    val carroTeste = Carro(
        marca = "Toyota",
        modelo = "Corolla",
        anoFabricacao = 2020,
        anoModelo = 2021,
        km = 25000,
        transmissao = "Automática",
        valor = 98000.0,
        cor = "Branco",
        chassis = "skaeoeo"
    )

    service.cadastrarCarro(carroTeste)

    println("\nListando carros cadastrados:")
    val lista = service.listarCarros()

    if (lista.isEmpty()) {
        println("Nenhum carro encontrado.")
    } else {
        lista.forEach { println(it) }
    }
}
