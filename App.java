import dominio.Livro;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    private static ArrayList<Livro> livros = new ArrayList<>();
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        Livro livro1 = new Livro("Thor", 2001, "ramos", "Disney", true);
        Livro livro2 = new Livro("Rota 06", 2009, "santos", "Std X", true);

        System.out.println("Digite o título do livro: ");
        String tituloLivro = scanner.nextLine();

        System.out.println("Digite o ano de publicação do livro: ");
        int anoLivro = scanner.nextInt();

        System.out.println("Digite o autor do livro: ");
        String autorLivro = scanner.nextLine();

        System.out.println("Digite a editora do livro: ");
        String editoraLivro = scanner.nextLine();

        Livro livro = new Livro(tituloLivro, anoLivro, autorLivro, editoraLivro, true);
        System.out.println("\nLivro cadastrado!");
        System.out.println(livro);
        livros.add(livro);
        livros.add(livro1);
        livros.add(livro2);
        scanner.close();
    }

    private static void exibirLivros(){
        System.out.println("--- Livros Disponíveis ---");
        for(Livro livro : livros){
            if(livro.isDisponivel()){
                System.out.println(livro);
            }
        }

        for(Livro livro : livros){
            System.out.println("--- Livros Emprestados ---");
            if(!livro.isDisponivel()){
                System.out.println(livro);
            }
        }
    }

    private static void exibirAllLivros(){
        System.out.println("--- Todos os livros ---");
        for(Livro livro : livros){
            System.out.println(livro);
        }
    }

    private static void pegarLivroEmprestado(){

    }
}
