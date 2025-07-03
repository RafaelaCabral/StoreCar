package org.example.service

import org.example.model.Carro
import org.example.repository.CarroRepository

class CarroService {
    private val repository = CarroRepository()
    fun cadastrarCarro(carro: Carro){
        if (carro.modelo.isBlank() && carro.marca.isBlank() && carro.valor <= 0.0){
            println("Campos obrigatórios vazios ou inválidos (modelo, marca e valor)")
            return
        }
        repository.inserirCarro(carro)
    }
    fun listarCarros(): List<Carro>{
        return repository.listarCarros()
    }
}