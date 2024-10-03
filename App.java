import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        App app = new App();
        Livro novoLivro = app.new Livro();
        int pararPrograma = 1;

        while (pararPrograma != 0) {
            System.out.println("CONTROLE DE ESTOQUE - LIVRARIA");
            System.out.println("[1] Novo");
            System.out.println("[2] Listar Produtos");
            System.out.println("[3] Remover Produtos");
            System.out.println("[4] Entrada Estoque");
            System.out.println("[5] Saída Estoque");
            System.out.println("[0] Sair");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            int inputUserInt = Integer.parseInt(input.readLine());

            switch (inputUserInt) {
                case 0: 
                    pararPrograma = 0;
                break;
                
                case 1:
                    novoLivro.novoLivro();
                break;
                
                case 2:
                    novoLivro.listarProdutos();
                break;

                case 3:
                    novoLivro.removerProdutos();
                break;

                case 4:
                    novoLivro.entradaEstoque();
                break;

                case 5:
                    novoLivro.saidaEstoque();
                break;

                default:
                    break;
            }   
        }
    }

    public class Livro {
        ArrayList<String> nomeDoLivro = new ArrayList<>();
        ArrayList<Double> precoLivro = new ArrayList<>();
        ArrayList<String> nomeDoAutor = new ArrayList<>();
        ArrayList<String> generoDoLivro = new ArrayList<>();
        ArrayList<Integer> posicao = new ArrayList<>();
        ArrayList<Integer> estoque = new ArrayList<>();
        ArrayList<Integer> contadorDeLivroLista = new ArrayList<>();

        String inputNomeDoLivro;
        Double inputpreco; 
        String inputAutor;
        String inputGenero; 
        int contadorEstoque = 0;
        int contadorDeLivro = 1;

        void novoLivro() throws IOException {
            contadorDeLivroLista.add(contadorDeLivro);

            System.out.println("Informe o nome do livro: ");
            BufferedReader name = new BufferedReader(new InputStreamReader(System.in));
            inputNomeDoLivro = name.readLine();

            System.out.println("Informe o preço: ");
            BufferedReader preco = new BufferedReader(new InputStreamReader(System.in));
            inputpreco = Double.parseDouble(preco.readLine());

            System.out.println("Informe o autor(a): ");
            BufferedReader autor = new BufferedReader(new InputStreamReader(System.in));
            inputAutor = autor.readLine();

            System.out.println("Informe o Gênero: ");
            BufferedReader genero = new BufferedReader(new InputStreamReader(System.in));
            inputGenero = genero.readLine();


            nomeDoLivro.add(inputNomeDoLivro);
            precoLivro.add(inputpreco);
            nomeDoAutor.add(inputGenero);
            generoDoLivro.add(inputGenero);

            contadorDeLivro ++;
            System.out.println("Livro Adicionado!");
        }

        void listarProdutos() {

            if (nomeDoLivro.size() == 0) {
                System.out.println("Sem produtos listados.");
            } else {
                if (estoque.size() == 0) {
                    for (int i = 0; i < nomeDoLivro.size() ; i++) {
                    System.out.println(contadorDeLivroLista.get(i)+"."+nomeDoLivro.get(i)+"("+ precoLivro.get(i) +") - 0 no estoque\n");
                    }
                } else {
                    for (int i = 0; i < nomeDoLivro.size() ; i++) {
                    System.out.println(contadorDeLivroLista.get(i)+"."+nomeDoLivro.get(i)+"("+ precoLivro.get(i) +") - " +estoque.get(i)+ " no estoque\n");
                    }
                }
            }
            
        }

        void removerProdutos() throws NumberFormatException, IOException {
            System.out.println("Informe a posição do livro a ser removido: ");
            BufferedReader posicaoRemocao = new BufferedReader(new InputStreamReader(System.in));
            int indiceRemocao = Integer.parseInt(posicaoRemocao.readLine());

            for (int i = 0; i < posicao.size() ; i++) {
                if (posicao.get(i) == indiceRemocao) {
                    posicao.remove(i);
                    nomeDoLivro.remove(i);
                    precoLivro.remove(i);
                    estoque.remove(i);
                } else {
                    System.out.println("Posição não encontrada para remoção!");
                }
            } 
        }

        void entradaEstoque() throws NumberFormatException, IOException {
            System.out.println("Informe a posição do livro.");
            BufferedReader indice = new BufferedReader(new InputStreamReader(System.in));
            posicao.add(Integer.parseInt(indice.readLine()));

            System.out.println("Informe a quantidade de Entrada: ");
            BufferedReader quantidade = new BufferedReader(new InputStreamReader(System.in));

            contadorEstoque = Integer.parseInt(quantidade.readLine());

            estoque.add(contadorEstoque);
        }

        void saidaEstoque() throws NumberFormatException, IOException {
            System.out.println("Informe a posição do livro: ");
            BufferedReader indice = new BufferedReader(new InputStreamReader(System.in));
            int posicaoRemover = Integer.parseInt(indice.readLine());

            System.out.println("Informe a quantidade de Saída:");
            BufferedReader quantidade = new BufferedReader(new InputStreamReader(System.in));
            int quantidadeParaRemover = Integer.parseInt(quantidade.readLine());

            for (int i= 0; i < posicao.size(); i++) {
                 
                    if (posicao.get(i) == posicaoRemover) {
                        estoque.set(i, estoque.get(i) - quantidadeParaRemover);
                    } else {
                        System.out.println("Essa posição nao foi encontrada!");
                    }
                
            }
        }
    }
}


