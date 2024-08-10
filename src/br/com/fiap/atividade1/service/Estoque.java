package br.com.fiap.atividade1.service;

import br.com.fiap.atividade1.model.Produto;

public class Estoque {
    private Produto[] produtos;
    private int count;

    // Construtor
    public Estoque(int tamanho) {
        produtos = new Produto[5];
        count = 0;
    }

    // Adicionar produto
    public void adicionar(Produto produto) {
        if (count < produtos.length) {
            produtos[count] = produto;
            count++;
        } else {
            System.out.println("br.com.fiap.atividade1.service.Estoque cheio! Não é possível adicionar o produto.");
        }
    }

    // Buscar produto
    public int buscar(String nome) {
        for (int i = 0; i < count; i++) {
            if (produtos[i].getNome().equals(nome)) {
                return i; // Retorna o índice do produto encontrado
            }
        }
        return -1; // Retorna -1 se não encontrado
    }

    // Atualizar produto
    public void atualizar(int indice, Produto produto) {
        if (indice >= 0 && indice < count) {
            produtos[indice] = produto;
        } else {
            System.out.println("Índice inválido!");
        }
    }

    // Remover produto
    public void remover(int indice) {
        if (indice >= 0 && indice < count) {
            for (int i = indice; i < count - 1; i++) {
                produtos[i] = produtos[i + 1];
            }
            produtos[count - 1] = null; // Remove a referência do último produto
            count--;
        } else {
            System.out.println("Índice inválido! Não é possível remover.");
        }
    }

    // Listar produtos
    public void listar() {
        for (int i = 0; i < count; i++) {
            System.out.println(i + ": " + produtos[i]);
        }
    }
}
