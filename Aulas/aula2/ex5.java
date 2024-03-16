package aula2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
  Tema livre, utilizando HashMap. Além das funcionalidades padrões de um CRUD:

Cadastro.
Seleção.
Alteração.
Exclusão.

	Implemente uma opção de estatísticas, retornando alguns contadores, exemplo:
30 alunos registros
20 aprovados
10 reprovados

 */
public class ex5 {

    public static void main(String[] args) throws Exception {
        new ex5().start();
    }

    private Map<AlunoCadastrado, Character> mapaAlunos = new HashMap<>();
    private int totalAlunos = 0;
    private int totalAprovados = 0;
    private int totalReprovados = 0;

    public void start() {
        Scanner sc = new Scanner(System.in);

        int op;
        do {
            menu();
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    cadastrarAluno(sc);
                    break;
                case 2:
                    exibirTodosAlunos();
                    break;
                case 3:
                    pesquisarAluno(sc);
                    break;
                case 4:
                    alterarDadosAluno(sc);
                    break;
                case 5:
                    excluirAluno(sc);
                    break;
                case 6:
                    aprovarOuReprovarAluno(sc);
                    break;
                case 7:
                    exibirEstatisticas();
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

    private void menu() {
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Exibir todos os alunos");
        System.out.println("3 - Pesquisar aluno");
        System.out.println("4 - Alterar nome do aluno");
        System.out.println("5 - Excluir aluno");
        System.out.println("6 - Aprovar ou Reprovar aluno");
        System.out.println("7 - Exibir estatísticas");
        System.out.println("0 - Sair");
    }

    private void cadastrarAluno(Scanner sc) {
        System.out.print("Digite o nome do aluno: \n");
        String nome = sc.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("O nome do aluno não pode estar em branco.\n");
            return;
        }

        AlunoCadastrado novoAluno = new AlunoCadastrado(nome);
        mapaAlunos.put(novoAluno, null);

        totalAlunos++;
        System.out.println("Aluno cadastrado com sucesso.\n");
    }

    private void exibirTodosAlunos() {
        System.out.println("\nAlunos: \n");
        if (mapaAlunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.\n");
        } else {
            for (Map.Entry<AlunoCadastrado, Character> entry : mapaAlunos.entrySet()) {
                AlunoCadastrado aluno = entry.getKey();
                Character status = entry.getValue();
                String statusStr = (status != null) ? ((status == 'A') ? "Aprovado" : "Reprovado") : "Não avaliado";
                System.out.println("Nome: " + aluno.getNome() + ", Status: " + statusStr + "\n");
            }
        }
    }

    private void pesquisarAluno(Scanner sc) {
        System.out.print("Digite o nome do aluno: \n");
        String nome = sc.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("O nome do aluno não pode estar em branco.\n");
            return;
        }

        AlunoCadastrado alunoPesquisado = null;
        for (AlunoCadastrado aluno : mapaAlunos.keySet()) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                alunoPesquisado = aluno;
                break;
            }
        }

        if (alunoPesquisado != null) {
            Character status = mapaAlunos.get(alunoPesquisado);
            String statusStr = (status != null) ? ((status == 'A') ? "Aprovado" : "Reprovado") : "Não avaliado";
            System.out.println("Aluno encontrado: Nome: " + alunoPesquisado.getNome() + ", Status: " + statusStr);
        } else {
            System.out.println("Aluno não encontrado.\n");
        }
    }

    private void alterarDadosAluno(Scanner sc) {
        System.out.print("Digite o nome do aluno a ser alterado: \n");
        String nome = sc.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("O nome do aluno não pode estar em branco.\n");
            return;
        }

        AlunoCadastrado alunoPesquisado = null;
        for (AlunoCadastrado aluno : mapaAlunos.keySet()) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                alunoPesquisado = aluno;
                break;
            }
        }

        if (alunoPesquisado != null) {
            System.out.print("Digite o novo nome do aluno: \n");
            String novoNome = sc.nextLine().trim();
       
            mapaAlunos.remove(alunoPesquisado);
            AlunoCadastrado novoAluno = new AlunoCadastrado(novoNome);
            mapaAlunos.put(novoAluno, mapaAlunos.remove(alunoPesquisado));
            System.out.println("Nome do aluno alterado com sucesso.\n");
        } else {
            System.out.println("Aluno não encontrado.\n");
        }
    }

    private void excluirAluno(Scanner sc) {
        System.out.print("Digite o nome do aluno a ser excluído: \n");
        String nome = sc.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("O nome do aluno não pode estar em branco.\n");
            return;
        }

        AlunoCadastrado alunoPesquisado = null;
        for (AlunoCadastrado aluno : mapaAlunos.keySet()) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                alunoPesquisado = aluno;
                break;
            }
        }

        if (alunoPesquisado != null) {
            mapaAlunos.remove(alunoPesquisado);
            System.out.println("Aluno removido com sucesso.\n");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private void aprovarOuReprovarAluno(Scanner sc) {
        System.out.print("Digite o nome do aluno: ");
        String nome = sc.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("O nome do aluno não pode estar em branco.\n");
            return;
        }

        AlunoCadastrado alunoSelecionado = null;
        for (AlunoCadastrado aluno : mapaAlunos.keySet()) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                alunoSelecionado = aluno;
                break;
            }
        }

        if (alunoSelecionado != null) {
            System.out.print("Digite 'A' para aprovar ou 'R' para reprovar o aluno: ");
            char status = sc.nextLine().toUpperCase().charAt(0);
            if (status == 'A' || status == 'R') {
                mapaAlunos.put(alunoSelecionado, status);
                if (status == 'A') {
                    totalAprovados++;
                } else {
                    totalReprovados++;
                }
                System.out.println("Status do aluno atualizado com sucesso.");
            } else {
                System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private void exibirEstatisticas() {
        System.out.println("\nEstatísticas:");
        System.out.println("Total de alunos cadastrados: " + totalAlunos + "\n");
        System.out.println("Total de alunos aprovados: " + totalAprovados + "\n");
        System.out.println("Total de alunos reprovados: " + totalReprovados + "\n");
    }
}
