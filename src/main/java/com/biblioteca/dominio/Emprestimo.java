package com.biblioteca.dominio;

import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataEmprestimo = LocalDate.now();
    private Livro livroEmprestado;
    private Usuario usuarioRetirante;

    public Emprestimo(Livro livroSolicitado, Usuario usuarioSolicitante) {
        this.livroEmprestado = livroSolicitado;
        this.usuarioRetirante = usuarioSolicitante;
        livroSolicitado.setEmprestimo(true);
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

}
