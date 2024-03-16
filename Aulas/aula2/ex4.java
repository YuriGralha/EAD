package aula2;

import java.util.LinkedList;
import java.util.Scanner;

/*
 Tema livre! Utilizando LinkedList, implemente uma estrutura de nós, lembrando que cada objeto precisa especificar o registro anterior e o próximo.

	Deverá ter as funcionalidades de: cadastro, seleção, alteração e exclusão, dentro de uma estrutura de repetição.

 */
public class ex4 {
    public static void main(String[] args) {
		new ex4().start();
	}
	public void start() {
        LinkedList<AlunoCadastrado> listaAlunos = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        int op;
        do {
            menu();
            op = sc.nextInt();
            sc.nextLine(); 

			switch (op) {
                case 1:
                    cadastrarAluno(sc, listaAlunos);
                    break;
                case 2:
                    exibirTodosAlunos(listaAlunos);
                    break;
                case 3:
                    pesquisarAluno(sc, listaAlunos);
                    break;
                case 4:
                    alterarDadosAluno(sc, listaAlunos);
                    break;
                case 5:
                    excluirAluno(sc, listaAlunos);
                    break;
                case 0:
                    System.out.println("Fechando ");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (op != 0);

        sc.close();
    }

    private static void menu() {
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Exibir todos os alunos");
        System.out.println("3 - Pesquisar aluno");
        System.out.println("4 - Alterar dados do aluno");
        System.out.println("5 - Excluir aluno");
        System.out.println("0 - Sair");
    }

    private static void cadastrarAluno(Scanner sc, LinkedList<AlunoCadastrado> listaAlunos) {
        System.out.print("Digite o nome do aluno: ");
        String nome = sc.nextLine().trim();

		if (nome.isEmpty()) {
            System.out.println("O nome do aluno não pode estar em branco.");
            return;
        }

        AlunoCadastrado novoAluno = new AlunoCadastrado(nome);
        listaAlunos.add(novoAluno);

        System.out.println("Aluno cadastrado com sucesso.");
    }

    private static void exibirTodosAlunos(LinkedList<AlunoCadastrado> listaAlunos) {
        System.out.println("\nAlunos: ");

        if (listaAlunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (AlunoCadastrado aluno : listaAlunos) {
                System.out.println(aluno);
            }
        }
    }

    private static void pesquisarAluno(Scanner sc, LinkedList<AlunoCadastrado> listaAlunos) {
        System.out.print("Digite o nome do aluno: ");
        String nome = sc.nextLine().trim();

		if (nome.isEmpty()) {
            System.out.println("O nome do aluno não pode estar em branco.");
            return;
        }

        boolean encontrado = false;
        for (AlunoCadastrado aluno : listaAlunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + aluno);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void alterarDadosAluno(Scanner sc, LinkedList<AlunoCadastrado> listaAlunos) {
        System.out.print("Digite o nome do aluno a ser alterado: ");
        String nome = sc.nextLine().trim();

		if (nome.isEmpty()) {
            System.out.println("O nome do aluno não pode estar em branco.");
            return;
        }

        boolean encontrado = false;
        for (AlunoCadastrado aluno : listaAlunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.print("Digite o novo nome do aluno: ");
                String novoNome = sc.nextLine().trim();
                aluno.setNome(novoNome);
                System.out.println("Nome do aluno alterado com sucesso.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void excluirAluno(Scanner sc, LinkedList<AlunoCadastrado> listaAlunos) {
        System.out.print("Digite o nome do aluno a ser excluído: ");
        String nome = sc.nextLine().trim();

		if (nome.isEmpty()) {
            System.out.println("O nome do aluno não pode estar em branco.");
            return;
        }

        boolean removido = false;
        for (AlunoCadastrado aluno : listaAlunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                listaAlunos.remove(aluno);
                System.out.println("Aluno removido com sucesso.");
                removido = true;
                break;
            }
        }
        if (!removido) {
            System.out.println("Aluno não encontrado.");
        }
    }
}