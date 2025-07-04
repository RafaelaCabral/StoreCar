package org.example

import org.example.model.Carro
import org.example.service.impl.CarroServiceImpl

fun main() {
    val service = CarroServiceImpl()

    val carroTeste = Carro(
        marca = "Toyota",
        modelo = "Corolla",
        anoFabricacao = 2020,
        anoModelo = 2021,
        km = 25000,
        transmissao = "Automática",
        valor = 98000.0,
        cor = "Branco",
        chassis = "oooo132"
    )

//    service.cadastrarCarro(carroTeste)

    println("\nListando carros cadastrados:")
    val lista = service.listarCarros()

    if (lista.isEmpty()) {
        println("Nenhum carro encontrado.")
    } else {
        lista.forEach { println(it) }
    }
//    val id = 1
//    service.deletarCarro(id)
//
//    val carroAtualizado = Carro(
//        marca = "Honda",
//        modelo = "Civic Touring",
//        anoFabricacao = 2021,
//        anoModelo = 2022,
//        km = 15000,
//        transmissao = "Automática",
//        valor = 123000.0,
//        cor = "Cinza",
//        chassis = "CHS999ZZ"
//    )
//
//    val idParaAtualizar = 4
//    service.atualizarCarro(idParaAtualizar, carroAtualizado)
}
