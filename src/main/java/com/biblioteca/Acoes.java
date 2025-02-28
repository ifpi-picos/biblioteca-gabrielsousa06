package com.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biblioteca.dominio.*;


public class Acoes {
    static Scanner scanner = new Scanner(System.in);
    static List<Livro> livrosBiblioteca = new ArrayList<>();
    static List<Livro> livrosDisponíveis = new ArrayList<>();
    static List<Usuario> usuariosCadastrados = new ArrayList<>();
    static List<Emprestimo> emprestimos = new ArrayList<>();
    static Notificacao notificacao = new NotificacaoEmail();



    public static void cadastrarLivro(){
        System.out.println("Digite o nome do livro: ");
        String nomeLivro = scanner.next();
        
        System.out.println("Digite o nome do Autor: ");
        String nomeAutor = scanner.next();
        
        System.out.println("Digite o nome da editora: ");
        String nomeEditora = scanner.next();
    
        System.out.println("Digite o ano em que o livro foi lançado: ");
        int anoLivro = scanner.nextInt();

        Livro novoLivro = new Livro(nomeLivro, nomeAutor, nomeEditora, anoLivro);
        novoLivro.exibirValoresLivro();
        livrosBiblioteca.add(novoLivro);
        livrosDisponíveis.add(novoLivro);

        System.out.println("O livro é -->" + livrosBiblioteca.get(0).getTitulo());
    }

    public static void listaLivros(){
        System.out.println("Escolha uma das opções abaixo:\n 1- Listar todos os livros\n 2- Listar livros emprestados\n 3- Listar livros disponíveis");
        int opção = scanner.nextInt();

        switch(opção){
            case 1:
                for(int i = 0; i < livrosBiblioteca.size(); i++){
                    System.out.println("\nLivro " + (i + 1) + ":");
                    livrosBiblioteca.get(i).exibirValoresLivro();
                }
                break;
            case 2: 
                for(int i = 0; i < emprestimos.size();i++){
                    System.out.println("\nLivro " + (i + 1) + ":");
                    emprestimos.get(i).getLivroEmprestado().exibirValoresLivro();
                    System.out.println("\nEmprestado para o Usuário:");
                    emprestimos.get(i).getUsuarioRetirante().exibirValoresUsuario();
                    System.out.println("Emprestado no dia: " + emprestimos.get(i).getDataEmprestimo() + " Data de devolução: " + emprestimos.get(i).getDataEmprestimo().plusDays(7));
                }
                break;
            case 3:
                for(int i = 0; i < livrosDisponíveis.size();i++){
                    System.out.println("\nLivro " + (i + 1) + ":");
                    livrosDisponíveis.get(i).exibirValoresLivro();
                }
                break;
            default:
                break;
            }
    }

    public static void cadastrarUsuario() {
        System.out.println("Digite o nome do usuário: ");
        String nomeUsuario = scanner.next();

        System.out.println("Digite o CPF do usuário: ");
        String cpf = scanner.next();

        System.out.println("Digite o email do usuário: ");
        String email = scanner.next();

        Usuario novoUsuario = new Usuario(nomeUsuario, cpf, email);
        usuariosCadastrados.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
        
    }

    public static void emprestimoLivro() {
        Usuario userEncontrado = null;
        do {
            System.out.println("Digite o CPF do usuário que deseja realizar o empréstimo do livro: ");
            String cpf = scanner.next();

            for(Usuario user : usuariosCadastrados){
                if(user.getCpf().equals(cpf)){
                    userEncontrado = user;
                    break;
                }
            }
        }while(userEncontrado == null);

        Livro livroEncontrado = null;
        do {
            System.out.println("Digite o nome do livro que deseja realizar o emprestimo: ");
            String nomeLivro = scanner.next();

            for(Livro livro : livrosDisponíveis){
                if(livro.getTitulo().equals(nomeLivro)){
                    livroEncontrado = livro;
                    livrosDisponíveis.remove(livro);
                    break;
                }
            }
        } while (livroEncontrado == null);

        Emprestimo novoEmprestimo = new Emprestimo(livroEncontrado, userEncontrado);
        emprestimos.add(novoEmprestimo);
        userEncontrado.historicoEmprestimos(livroEncontrado);

        notificacao.notificacaoDeConfirmacao("Empréstimo", userEncontrado.getNome(), livroEncontrado.getTitulo());
    }

    public static void devolucaoLivro(){
        Usuario userEncontrado = null;
        do {
            System.out.println("Digite o CPF do usuário que deseja devolver o livro: ");
            String cpf = scanner.next();

            for(Usuario user : usuariosCadastrados){
                if(user.getCpf().equals(cpf)){
                    userEncontrado = user;
                    break;
                }
            }
        }while(userEncontrado == null);

        if(userEncontrado.getHistoricoEmprestimos() != null){
            System.out.println("Qual o titulo do livro que deseja devolver? ");
            String nomeLivro = scanner.next();

            for(Livro livro : userEncontrado.getHistoricoEmprestimos()){
                if(livro.getTitulo().equals(nomeLivro) && livro.isEmprestimo() == true){
                    livro.exibirValoresLivro();
                    livro.setEmprestimo(false);
                    for(int i = 0; i < emprestimos.size(); i++){
                        if(livro == emprestimos.get(i).getLivroEmprestado()){
                            emprestimos.remove(i);
                            livrosDisponíveis.add(livro);
                        } 
                    }      
                }
            }
                notificacao.notificacaoDeConfirmacao("Devolução", userEncontrado.getNome(), nomeLivro);
            }
        
    }

    public static void historicoEmprestimosUsuario(){
        Usuario userEncontrado = null;
        do {
            System.out.println("Digite o CPF do usuário que deseja ver o histórico: ");
            String cpf = scanner.next();

            for(Usuario user : usuariosCadastrados){
                if(user.getCpf().equals(cpf)){
                    userEncontrado = user;
                    break;
                }
            }
        }while(userEncontrado == null);

        System.out.println("Emprestimos realizados para o usuário:" + userEncontrado.getNome());
        for(Livro livroEmprestado : userEncontrado.getHistoricoEmprestimos()){
            livroEmprestado.exibirValoresLivro();
        }

    } 
}