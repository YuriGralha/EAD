package aula3;


 class Tarefa {
    private String nome;

    public Tarefa(String nome){
        setNome(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
