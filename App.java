import dominio.Emprestimo;
import dominio.Livro;
import dominio.Usuario;
import java.time.LocalDate;

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
        Scanner scanner = new Scanner(System.in);
      

        // procurar livro pelo nome
        System.out.println("Digite o título do livro que deseja reservar: ");
        String tituloLivroEmprestado = scanner.nextLine();


        Livro livroEscolhido = null;
        for(Livro livro : livros){
            if(livro.getTitulo().equalsIgnoreCase(tituloLivroEmprestado)){
                livroEscolhido = livro;
                break;
            };
            
        }

        if(livroEscolhido == null){
            System.out.println("Livro não encontrado!");
        }

        else if(!livroEscolhido.isDisponivel()){
            System.out.println("O livro não está disponível!");
        }
        else{
            // atributos do usuario
            System.out.println("Digite seu CPF: ");
            String usuarioCpf = scanner.nextLine();

            System.out.println("Digite seu nome de usuário: ");
            String usuarioName = scanner.nextLine();

            System.out.println("Digite seu email: ");
            String usuarioEmail = scanner.nextLine();

            LocalDate dataLivroEmprestado = LocalDate.now();
            LocalDate dataLivroDevolucao = dataLivroEmprestado.plusMonths(1);

            livroEscolhido.setDisponivel(false);

            Usuario usuario = new Usuario(usuarioName, usuarioCpf, usuarioEmail);
            Emprestimo emprestimo = new Emprestimo(usuario, livroEscolhido,dataLivroEmprestado , dataLivroDevolucao);
            System.out.println("Seu livro foi reservado! ");
            System.out.println(emprestimo);
        }

    scanner.close();

    }
}
