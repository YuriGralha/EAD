package aula2;

import java.util.Scanner;

/*
  Utilizando um Vector, crie um algoritmo com as seguintes funcionalidades:

Cadastrar (Não poderá haver registros iguais).
Selecionar todos os registros.
Realizar uma pesquisa através de um termo (Se o nome possui A, por exemplo).
Alterar dados (Realize uma validação para garantir que será alterado).
Remoção (Realize uma validação para garantir que será removido).

	Essa estrutura ficará em uma estrutura de repetição e poderão ser registradas inúmeras informações.

 */
public class ex2 {
    public static void main(String[] args) throws Exception {
        new ex2().start();
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        String[] vetor = new String[15];
        int qt = 0;
        int op;
        do {
            menu();
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    qt = Cadastrar(sc, vetor, qt);
                    break;
                case 2:
                    Registro(vetor, qt);
                    break;
                case 3:
                    Pesquisar(sc, vetor, qt);
                    break;
                case 4:
                    Alterar(sc, vetor, qt);
                    break;
                case 5:
                    qt = Excluir(sc, vetor, qt);
                    break;
                case 0:
                    System.out.println("Fechando");
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
        System.out.println("3 - Realizar uma pesquisa através de um termo");
        System.out.println("4 - Alterar dados");
        System.out.println("5 - Remoção");
        System.out.println("0 - Sair");
    }

    private int Cadastrar(Scanner sc, String[] vetor, int qt) {
        System.out.print("Digite o registro a ser cadastrado: ");
        String novoRegistro = sc.nextLine().trim(); 
        
        if (!novoRegistro.isEmpty()) {
            boolean registroExiste = false;
            for (int i = 0; i < qt; i++) {
                if (vetor[i].equals(novoRegistro)) {
                    registroExiste = true;
                    break;
                }
            }
            
            if (!registroExiste) {
                vetor[qt++] = novoRegistro;
                System.out.println("Registro cadastrado com sucesso.");
            } else {
                System.out.println("Este registro já existe.");
            }
        } else {
            System.out.println("O registro não pode estar em branco.");
        }
    
        return qt;
    }

    private void Registro(String[] vetor, int qt) {
        System.out.println("Registros:");
        for (int i = 0; i < qt; i++) {
            System.out.println(vetor[i]);
        }
    }

    private void Pesquisar(Scanner sc, String[] vetor, int qt) {
        System.out.print("Digite o termo de pesquisa: ");
        String termo = sc.nextLine().toLowerCase().trim(); 
        
        if (!termo.isEmpty()) { 
            System.out.println("Resultados da pesquisa:");
            for (int i = 0; i < qt; i++) {
                if (vetor[i].toLowerCase().contains(termo)) {
                    System.out.println(vetor[i]);
                }
            }
        } else {
            System.out.println("A pesquisa não pode estar em branco.");
        }
    }

    private void Alterar(Scanner sc, String[] vetor, int qt) {
        System.out.print("Digite o registro a ser alterado: ");
        String registroAntigo = sc.nextLine().trim().toLowerCase(); 
        
        if (!registroAntigo.isEmpty()) { 
            System.out.print("Digite o novo registro: ");
            String novoRegistro = sc.nextLine().trim(); 
    
            if (!novoRegistro.isEmpty()) { 
                for (int i = 0; i < qt; i++) {
                    if (vetor[i].toLowerCase().equals(registroAntigo)) {
                        vetor[i] = novoRegistro;
                        System.out.println("Registro alterado com sucesso.");
                        return;
                    }
                }
                System.out.println("Registro não encontrado.");
            } else {
                System.out.println("O novo registro não pode estar em branco.");
            }
        } else {
            System.out.println("O registro a ser alterado não pode estar em branco.");
        }
    }

    private int Excluir(Scanner sc, String[] vetor, int qt) {
        System.out.print("Digite o registro a ser removido: ");
        String registroRemover = sc.nextLine().trim().toLowerCase(); 
        
        if (!registroRemover.isEmpty()) { 
            boolean registroEncontrado = false;
            for (int i = 0; i < qt; i++) {
                if (vetor[i].toLowerCase().equals(registroRemover)) {
                    registroEncontrado = true;
                    for (int j = i; j < qt - 1; j++) {
                        vetor[j] = vetor[j + 1];
                    }
                    qt--;
                    System.out.println("Registro removido com sucesso.");
                    break;
                }
            }
            if (!registroEncontrado) {
                System.out.println("Registro não encontrado.");
            }
        } else {
            System.out.println("O registro a ser removido não pode estar em branco.");
        }
        return qt;
    }
}