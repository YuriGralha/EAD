package aula2;

//ex3

public class Produto {
    
        private String nome;
        private String segmento;
  
        public Produto(String nome, String segmento) {
           setNome(nome);
            setSegmento(segmento);
        }
  
        public String getNome() {
            return nome;
        }
  
        public void setNome(String nome) {
            this.nome = nome;
        }
  
        public String getSegmento() {
            return segmento;
        }
  
        public void setSegmento(String segmento) {
            this.segmento = segmento;
        }
  
    }
  
