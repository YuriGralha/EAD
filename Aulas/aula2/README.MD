 Citar os quatro tipos de armazenamentos (Vector, ArrayList, LinkedList e HashMap).
Faça um breve resumo de cada um.
Descreva as características.
Exemplifique cada um (o exemplo não precisa ser código, apenas um texto).

R: 
Vector:

- Armazena uma quantidade pré-definida de dados, similar a um array.
- É ideal para quando se tem um número fixo ou pequeno de elementos.
- Os elementos são acessados por meio de seus índices, começando a partir de 0.
- Exemplo: int[] num = new int[10];

ArrayList:

- Implementa uma lista redimensionável, permitindo adicionar ou remover elementos dinamicamente.
- É uma estrutura de dados flexível e eficiente para armazenar uma coleção de elementos.
- Permite acessar os elementos por meio de índices, assim como um array.
- Exemplo: ArrayList<String> nomes = new ArrayList<>();

LinkedList:

- Implementa uma lista duplamente encadeada, em que cada elemento possui uma referência para o próximo e o anterior na lista.
- É eficiente para adicionar ou remover elementos no início ou no final da lista.
- O acesso aos elementos é mais lento do que em um ArrayList, mas é mais rápido para operações de adição e remoção.
- Exemplo: LinkedList<Integer> numeros = new LinkedList<>();

HashMap:

- Implementa uma tabela de dispersão (hash table), que armazena pares de chave-valor.
- É eficiente para recuperar valores com base em uma chave, permitindo acesso rápido aos elementos.
- As chaves devem ser únicas, mas os valores podem ser repetidos.
- Exemplo: HashMap<String, Integer> idadePorNome = new HashMap<>();