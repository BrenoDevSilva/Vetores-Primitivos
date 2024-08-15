import br.com.fiap.atividade1.model.Produto;
import br.com.fiap.atividade1.service.Estoque;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tamanho inicial do estoque:");
        int tamanho = scanner.nextInt();
        pularLinha();
        scanner.nextLine();  // Limpar buffer
        Estoque estoque = new Estoque(tamanho);

        while (true) {
            int opcao;
            while (true) {
                try {
                    System.out.println("Menu");
                    System.out.println("1. Adicionar Item");
                    System.out.println("2. Buscar Item");
                    System.out.println("3. Atualizar Item");
                    System.out.println("4. Remover Item");
                    System.out.println("5. Listar Estoque");
                    System.out.println("6. Sair");
                    System.out.println("Digite a opção desejada (1 a 6): ");
                    opcao = scanner.nextInt();
                    scanner.nextLine();  // Limpar buffer
                    pularLinha();

                    if (opcao >= 1 && opcao <= 6) {
                        break; // Opção válida, saia do loop
                    } else {
                        System.out.println("Opção inválida. Por favor, escolha um número entre 1 e 6.");
                        pularLinha();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número.");
                    scanner.nextLine(); // Limpar o buffer do scanner
                    pularLinha();
                }
            }

            switch (opcao) {
                case 1:
                    String nome;
                    double valor;

                    while (true) {
                        System.out.println("Digite o nome do produto (apenas letras): ");
                        nome = scanner.nextLine();
                        if (nome.matches("[a-zA-Z]+")) {
                            break;
                        } else {
                            pularLinha();
                            System.out.println("Nome inválido. O nome deve conter apenas letras.");
                        }
                    }

                    while (true) {
                        System.out.println("Digite o valor do produto (número positivo): ");
                        String valorStr = scanner.nextLine();
                        try {
                            valor = Double.parseDouble(valorStr);
                            if (valor >= 0) {
                                break;
                            } else {
                                pularLinha();
                                System.out.println("Valor inválido. O valor deve ser um número positivo.");
                            }
                        } catch (NumberFormatException e) {
                            pularLinha();
                            System.out.println("Valor inválido. Por favor, insira um número.");
                        }
                    }

                    Produto produto = new Produto(nome, valor);
                    estoque.adicionar(produto);
                    pularLinha();
                    break;

                case 2:
                    System.out.println("Listando produtos:");
                    estoque.listar();
                    pularLinha();

                    System.out.println("Digite o nome do produto a buscar: ");
                    String nomeBuscar = scanner.nextLine();
                    int indice = estoque.buscar(nomeBuscar);
                    if (indice != -1) {
                        System.out.println("Produto encontrado no índice: " + indice);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    pularLinha();
                    break;

                case 3:
                    System.out.println("Digite o índice do produto a atualizar: ");
                    int indiceAtualizar = scanner.nextInt();
                    scanner.nextLine();  // Limpar buffer
                    System.out.println("Digite o novo nome do produto: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.println("Digite o novo valor do produto: ");
                    double valorAtualizar = scanner.nextDouble();
                    scanner.nextLine();  // Limpar buffer

                    Produto produtoAtualizado = new Produto(nomeAtualizar, valorAtualizar);
                    estoque.atualizar(indiceAtualizar, produtoAtualizado);
                    pularLinha();
                    break;

                case 4:
                    System.out.println("Digite o índice do produto a remover: ");
                    int indiceRemover = scanner.nextInt();
                    scanner.nextLine();  // Limpar buffer
                    estoque.remover(indiceRemover);
                    pularLinha();
                    break;

                case 5:
                    System.out.println("Listando produtos:");
                    estoque.listar();
                    pularLinha();
                    break;

                case 6:
                    System.out.println("Saindo...");
                    return;
            }
        }
    }

    private static void pularLinha() {
        // Imprime 3 quebras de linha
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }
}
