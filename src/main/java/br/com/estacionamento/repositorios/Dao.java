/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estacionamento.repositorios;

import java.util.List;

/**
 *
 * @author william.rodrigues
 */
public interface Dao<T> {

    // adiciona um obejto ao banco de dados
    void adicionar(T  t);

    // Lista todos os itens do banco de dados
    List<T> listar();

    // Busca um objeto em especifico no banco de dados
    // T buscarUm(int id);
    
    // Atualiza um item no banco de dados;
    // T update(T t);
    
    // Remove um item do banco de dados
    // T remove(T t);
}
