package org.example.repository

import org.example.connection.ConexaoDB
import org.example.model.Carro

class CarroRepository {

    fun inserirCarro(carro: Carro) {
        val sql = """
            INSERT INTO carro 
                (marca, modelo, ano_fabricacao, ano_modelo, km, transmissao, valor, cor, chassis)
            VALUES 
                (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.trimIndent()

        ConexaoDB.getConnection().use { conn ->
            conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS).use { stmt ->
                stmt.setString(1, carro.marca)
                stmt.setString(2, carro.modelo)
                stmt.setInt(3, carro.anoFabricacao)
                stmt.setInt(4, carro.anoModelo)
                stmt.setInt(5, carro.km)
                stmt.setString(6, carro.transmissao)
                stmt.setDouble(7, carro.valor)
                stmt.setString(8, carro.cor)
                stmt.setString(9, carro.chassis)
                stmt.executeUpdate()

                val pegaId = stmt.generatedKeys
                if (pegaId.next()) {
                    val id = pegaId.getInt(1)
                    println("ID gerado: $id")

                }
            }

            println("Carro inserido com sucesso.")
        }
    }

    fun listarCarros(): List<Carro> {
        val lista = mutableListOf<Carro>()
        val sql = "SELECT * FROM carro"

        ConexaoDB.getConnection().use { conn ->
            conn.prepareStatement(sql).use { stmt ->
                val resultado = stmt.executeQuery()

                while (resultado.next()) {
                    val carro = Carro(
                        id = resultado.getInt("id"),
                        marca = resultado.getString("marca"),
                        modelo = resultado.getString("modelo"),
                        anoFabricacao = resultado.getInt("ano_fabricacao"),
                        anoModelo = resultado.getInt("ano_modelo"),
                        km = resultado.getInt("km"),
                        transmissao = resultado.getString("transmissao"),
                        valor = resultado.getDouble("valor"),
                        cor = resultado.getString("cor"),
                        chassis = resultado.getString("chassis")
                    )
                    lista.add(carro)
                }
            }
        }

        return lista
    }

    fun deletarCarro(id: Int) {
        val sql = "DELETE FROM carro WHERE id = ?"

        ConexaoDB.getConnection().use { conn ->
            conn.prepareStatement(sql).use { stmt ->
                stmt.setInt(1, id)
                val carroApagado = stmt.executeUpdate()

                if (carroApagado > 0) {
                    println("Carro com o ID $id deletado com sucesso!")
                } else {
                    println("⚠Nenhum carro com ID $id encontrado.")
                }
            }
        }
    }

    fun atualizarCarro(id: Int, carro: Carro): Boolean {
        val sql = """
        UPDATE carro SET 
            marca = ?, modelo = ?, ano_fabricacao = ?, ano_modelo = ?, 
            km = ?, transmissao = ?, valor = ?, cor = ?, chassis = ?
        WHERE id = ?
    """.trimIndent()

        ConexaoDB.getConnection().use { conn ->
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, carro.marca)
                stmt.setString(2, carro.modelo)
                stmt.setInt(3, carro.anoFabricacao)
                stmt.setInt(4, carro.anoModelo)
                stmt.setInt(5, carro.km)
                stmt.setString(6, carro.transmissao)
                stmt.setDouble(7, carro.valor)
                stmt.setString(8, carro.cor)
                stmt.setString(9, carro.chassis)
                stmt.setInt(10, id)

                val linhasAfetadas = stmt.executeUpdate()
                return linhasAfetadas > 0
            }
        }
    }



}
