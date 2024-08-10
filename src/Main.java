import br.com.fiap.atividade1.model.Produto;
import br.com.fiap.atividade1.service.Estoque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        Estoque produtos = null;

        while (true){
            System.out.println("Menu");
            System.out.println("1. Adicionar Item");
            System.out.println("2. Buscar Item");
            System.out.println("3. Atualizar Item");
            System.out.println("4. Remover Item");
            System.out.println("5. Listar Estoque");
            System.out.println("6. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Dígite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o valor do produto: ");
                    double valor = scanner.nextDouble();

                    Produto produto = new Produto(nome, valor);
                    assert false;
                    produtos.adicionar(produto);

            }

        }

            System.out.println("Listando produtos:");
            estoque.listar();

            int indice = estoque.buscar("br.com.fiap.atividade1.model.Produto A");
            if (indice != -1) {
                System.out.println("br.com.fiap.atividade1.model.Produto A encontrado no índice: " + indice);
            } else {
                System.out.println("br.com.fiap.atividade1.model.Produto A não encontrado.");
            }

            Produto produtoAtualizado = new Produto("br.com.fiap.atividade1.model.Produto A Atualizado", 15.0);
            estoque.atualizar(indice, produtoAtualizado);

            System.out.println("\nApós atualização:");
            estoque.listar();

            estoque.remover(0);

            System.out.println("\nApós remoção do produto no índice 0:");
            estoque.listar();
        }
}
