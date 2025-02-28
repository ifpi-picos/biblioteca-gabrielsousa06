package com.biblioteca.dominio;

import java.time.LocalDate;

public class Emprestimo {
    
    private int idEmprestimo;
    private Livro livroEmprestado;
    private Usuario usuarioRetirante;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido;
    
    
    
    public Emprestimo(Livro livroSolicitado, Usuario usuarioSolicitante) {
        this.livroEmprestado = livroSolicitado;
        this.usuarioRetirante = usuarioSolicitante;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(7);
    }
    
    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }
    
    public Livro getLivroEmprestado() {
        return livroEmprestado;
    }
    
    public void setLivroEmprestado(Livro livroEmprestado) {
        this.livroEmprestado = livroEmprestado;
    }
    
    public Usuario getUsuarioRetirante() {
        return usuarioRetirante;
    }
    
    public void setUsuarioRetirante(Usuario usuarioRetirante) {
        this.usuarioRetirante = usuarioRetirante;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
    
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
}
