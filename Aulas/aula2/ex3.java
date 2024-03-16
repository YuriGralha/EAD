package aula2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
  Utilizando um ArrayList, crie um algoritmo com as seguintes funcionalidades:

Cadastrar (Deverá cadastrar o nome de um produto e o segmento, pode adicionar mais características, caso queira).
Selecionar todos os registros.
Quantidade de segmentos: Exiba o nome e a quantidade de produtos em cada segmento.
Alterar dados (Realize uma validação para garantir que será alterado).
Remoção (Realize uma validação para garantir que será removido).

	Essa estrutura ficará em uma estrutura de repetição e poderão ser registradas inúmeras informações.

 */

public class ex3 {
  public static void main(String[] args) {
      new ex3().start();
  }

  public void start() {
      Scanner sc = new Scanner(System.in);
      ArrayList<Produto> listaProdutos = new ArrayList<>();

      int op;
      do {
          menu();
          op = sc.nextInt();
          sc.nextLine(); 

          switch (op) {
              case 1:
                  cadastrarProduto(sc, listaProdutos);
                  break;
              case 2:
                  listarProdutos(listaProdutos);
                  break;
              case 3:
                  quantidadeSegmentos(listaProdutos);
                  break;
              case 4:
                  alterarProduto(sc, listaProdutos);
                  break;
              case 5:
                  removerProduto(sc, listaProdutos);
                  break;
              case 0:
                  System.out.println("Saindo...");
                  break;
              default:
                  System.out.println("Opção inválida.\n");
          }
      } while (op != 0);

      sc.close();
  }

  private void menu() {
      System.out.println("1 - Cadastrar");
      System.out.println("2 - Selecionar todos os registros");
      System.out.println("3 - Quantidade de segmentos");
      System.out.println("4 - Alterar dados");
      System.out.println("5 - Remoção");
      System.out.println("0 - Sair");
      System.out.print("Escolha uma opção: ");
  }

  private void cadastrarProduto(Scanner sc, ArrayList<Produto> listaProdutos) {
    System.out.print("Digite o nome do produto: ");
    String nome = sc.nextLine().trim();

    while (nome.isEmpty()) {
        System.out.println("O nome do produto não pode estar vazio.");
        System.out.print("Digite o nome do produto: ");
        nome = sc.nextLine().trim();
    }

    System.out.print("Digite o segmento do produto: ");
    String segmento = sc.nextLine().trim();

    while (segmento.isEmpty()) {
        System.out.println("O segmento do produto não pode estar vazio.");
        System.out.print("Digite o segmento do produto: ");
        segmento = sc.nextLine().trim();
    }

    Produto produto = new Produto(nome, segmento);
    listaProdutos.add(produto);
    System.out.println("Produto cadastrado com sucesso.");
}

private void listarProdutos(ArrayList<Produto> listaProdutos) {
    System.out.println("Registros:");
    for (Produto produto : listaProdutos) {
        System.out.println(produto);
    }
}

private void quantidadeSegmentos(ArrayList<Produto> listaProdutos) {
    Map<String, Integer> segmentosQuantidade = new HashMap<>();

    for (Produto produto : listaProdutos) {
        String segmento = produto.getSegmento();
        segmentosQuantidade.put(segmento, segmentosQuantidade.getOrDefault(segmento, 0) + 1);
    }

    System.out.println("Quantidade de segmentos:");
    for (Map.Entry<String, Integer> entry : segmentosQuantidade.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue() + " produtos");
    }
}

private void alterarProduto(Scanner sc, ArrayList<Produto> listaProdutos) {
    System.out.print("Digite o nome do produto a ser alterado: ");
    String nomeProduto = sc.nextLine().trim();

    boolean encontrado = false;
    for (Produto produto : listaProdutos) {
        if (produto.getNome().equals(nomeProduto)) {
            System.out.print("Digite o novo nome do produto: ");
            String novoNome = sc.nextLine().trim();
            while (novoNome.isEmpty()) {
                System.out.println("O nome do produto não pode estar vazio.");
                System.out.print("Digite o novo nome do produto: ");
                novoNome = sc.nextLine().trim();
            }
            produto.setNome(novoNome);
            System.out.println("Produto alterado com sucesso.");
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("Produto não encontrado.");
    }
}

private void removerProduto(Scanner sc, ArrayList<Produto> listaProdutos) {
    System.out.print("Digite o nome do produto a ser removido: ");
    String nomeProduto = sc.nextLine().trim();

    boolean removido = listaProdutos.removeIf(produto -> produto.getNome().equals(nomeProduto));

    if (removido) {
        System.out.println("Produto removido com sucesso.");
    } else {
        System.out.println("Produto não encontrado.");
    }
}
}
