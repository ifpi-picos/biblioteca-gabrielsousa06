package com.biblioteca.dominio;

public class Livro {
    private int idLivro;
    private String titulo;
    private String autor;
    private String editora;
    private int ano;
    private boolean emprestimo = false;
    
    
    public Livro(String tituloLivro, String nomeAutor, String nomeEditora, int ano){
        this.titulo = tituloLivro;
        this.autor = nomeAutor;
        this.editora = nomeEditora;
        this.ano = ano;
    }
    public int getIdLivro() {
        return idLivro;
    }
    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }
    
    public void exibirValoresLivro() {
        System.out.printf("%nTítulo do livro: %s %nNome do autor: %s %nEditora: %s %nAno em que foi lançado: %d %n", titulo, autor, editora, ano);
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getEditora() {
        return editora;
    }
    public int getAno() {
        return ano;
    }
    public boolean isEmprestimo() {
        return emprestimo;
    }
    public void setEmprestimo(boolean emprestimo) {
        this.emprestimo = emprestimo;
    }
}
