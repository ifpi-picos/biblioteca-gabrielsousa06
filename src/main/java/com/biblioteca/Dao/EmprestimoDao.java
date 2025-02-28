package com.biblioteca.Dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.biblioteca.dominio.Emprestimo;
import com.biblioteca.dominio.Livro;

public class EmprestimoDao {
    private Connection conexao;

    public EmprestimoDao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void realizarEmprestimo(Emprestimo emprestimo){
        Livro livro = new LivroDao(conexao).pesquisarLivroId(emprestimo.getLivroEmprestado().getIdLivro());
        if(livro.isEmprestimo()){
            System.out.println("O livro já está emprestado");
            return;
        }
        String sql = "INSERT into emprestimo(idLivro, idUsuario, dataEmprestimo, dataDevolucao) values(?,?,?,?)";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, emprestimo.getLivroEmprestado().getIdLivro());
            stm.setInt(2, emprestimo.getUsuarioRetirante().getIdUsuario());
            stm.setDate(3, Date.valueOf(emprestimo.getDataEmprestimo()));
            stm.setDate(4,  Date.valueOf(emprestimo.getDataDevolucao()));
            stm.executeUpdate();

            Livro livroAtualizado = new LivroDao(conexao).pesquisarLivroId(emprestimo.getLivroEmprestado().getIdLivro());
            livroAtualizado.setEmprestimo(true);
            LivroDao livroDao = new LivroDao(conexao);
            livroDao.atualizarLivro(livroAtualizado);
            System.out.println("Emprestimo cadastrado!");
        } catch (Exception e) {
            System.out.println("Erro ao realizar o empréstimo" + e.getMessage());
        }

    }

    public void realizarDevolucao(Emprestimo emprestimo){
        
    }
}
