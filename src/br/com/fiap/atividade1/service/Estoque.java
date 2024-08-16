package br.com.fiap.atividade1.service;

import br.com.fiap.atividade1.model.Produto;

public class Estoque {
    private Produto[] produtos;
    private int count;

    // Construtor
    public Estoque(int tamanho) {
        produtos = new Produto[tamanho];
        count = 0;
    }

    // Adicionar produto
    public void adicionar(Produto produto) {
        if (count >= produtos.length) {
            redimensionar();
        }
        produtos[count] = produto;
        count++;
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
            System.out.println("Produto atualizado com sucesso!");
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
            System.out.println("Produto removido com Sucesso!");
            pularLinha();
        } else {
            System.out.println("Índice inválido! Não é possível remover.");
        }
    }

    public void listar() {
        if (count == 0) {
            System.out.println("Estoque Vazio");
            pularLinha();
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(i + " - " + produtos[i]);
            }
        }
    }

    private void redimensionar() {
        Produto[] novoArray = new Produto[produtos.length * 2];
        for (int i = 0; i < count; i++) {
            novoArray[i] = produtos[i];
        }
        produtos = novoArray;
        pularLinha();
        System.out.println("Estoque redimensionado para " + produtos.length + " itens.");
    }

    private static void pularLinha() {
        // Imprime 3 quebras de linha para "limpar" a tela
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }
}
