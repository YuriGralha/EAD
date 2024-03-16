package aula3;

/*
Você foi contratado para desenvolver um sistema de gerenciamento de tarefas para uma equipe de desenvolvimento de software na linguagem Java. 
O sistema deve permitir que os membros da equipe adicionem tarefas, removam tarefas concluídas e visualizem as próximas tarefas a serem realizadas.  
O sistema deve ser capaz de lidar com as seguintes operações:

-Adicionar uma nova tarefa à lista.
-Concluir uma tarefa, removendo-a da lista.
-Visualizar a próxima tarefa a ser realizada.

	Requisitos adicionais: 
-As tarefas devem ser armazenadas em uma estrutura de dados que permita a fácil adição e remoção de elementos. 
-A visualização da próxima tarefa deve ser feita de forma eficiente, sem a necessidade de percorrer toda a lista de tarefas. 
-O sistema deve ser escalável e capaz de lidar com um grande número de tarefas.

Instruções:  
-Projete e implemente o sistema de gerenciamento de tarefas usando uma das seguintes estruturas de dados: lista, fila ou pilha. 
-Ao implementar a estrutura de dados escolhida, forneça uma explicação detalhada do motivo pelo qual você escolheu essa estrutura em particular (crie um README para isso).
-Teste o sistema com diferentes cenários para garantir que ele funcione conforme o esperado. 
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class av1 {
    public static void main(String[] args) {
        new av1().start();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        Queue<Tarefa> filaTarefas = new LinkedList<>();

        int op;
        do {
            menu();
            op = sc.nextInt();
            switch (op) {
                case 1:
                    adicionarTarefa(sc, filaTarefas);
                    break;
                case 2:
                    concluirTarefa(filaTarefas);
                    break;
                case 3:
                    visualizarProximaTarefa(filaTarefas);
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
        System.out.println("1 - Adicionar Tarefa");
        System.out.println("2 - Concluir Tarefa");
        System.out.println("3 - Visualizar Próxima Tarefa");
        System.out.println("0 - Sair");
    }

    private void adicionarTarefa(Scanner sc, Queue<Tarefa> filaTarefas) {
        sc.nextLine().trim(); 
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = sc.nextLine().trim();
        if (!descricao.isEmpty()) {
            Tarefa novaTarefa = new Tarefa(descricao);
            filaTarefas.offer(novaTarefa);
            System.out.println("Tarefa adicionada com sucesso.\n");
        } else {
            System.out.println("A descrição da tarefa não pode estar em branco.\n");
        }
    }

    private void concluirTarefa(Queue<Tarefa> filaTarefas) {
        if (!filaTarefas.isEmpty()) {
            Tarefa tarefaConcluida = filaTarefas.poll();
            System.out.println("Tarefa \"" + tarefaConcluida.getNome() + "\" concluída com sucesso.\n");
        } else {
            System.out.println("Não há tarefas a serem concluídas.\n");
        }
    }

    private void visualizarProximaTarefa(Queue<Tarefa> filaTarefas) {
        if (!filaTarefas.isEmpty()) {
            Tarefa proximaTarefa = filaTarefas.peek();
            System.out.println("Próxima tarefa a ser realizada: " + proximaTarefa.getNome() + "\n");
        } else {
            System.out.println("Não há tarefas disponíveis.\n");
        }
    }
}