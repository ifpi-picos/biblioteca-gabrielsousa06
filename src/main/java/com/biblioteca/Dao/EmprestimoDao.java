package com.biblioteca.Dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        LivroDao livroDao = new LivroDao(conexao);
        Livro livro = livroDao.pesquisarLivroId(emprestimo.getLivroEmprestado().getIdLivro());
        if(!livro.isEmprestimo()){
            System.out.println("O livro está disponivel! ");
            return;
        }
        String sql = "UPDATE emprestimo SET devolvido = TRUE WHERE idEmprestimo AND devolvido = FALSE";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setInt(1, emprestimo.getIdEmprestimo());
            stm.executeUpdate();
            Livro livroAtualizado = new LivroDao(conexao).pesquisarLivroId(emprestimo.getLivroEmprestado().getIdLivro());
            livroAtualizado.setEmprestimo(false);
            livroDao.atualizarLivro(livroAtualizado);

            System.out.println("Devolução registrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao registrar a devolução" + e.getMessage());
        }
    }

    public List<Emprestimo> historicoEmprestimosPorUsuario(Usuario usuario){
    String sql = "SELECT id, idUsuario, idLivro, dataEmprestimo, dataDevolucao, devolvido FROM emprestimo WHERE idUsuario = ?";
    List<Emprestimo> historico = new ArrayList<>();
    
    try {
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, usuario.getIdUsuario());
        ResultSet result = stm.executeQuery();

        while(result.next()){
            Livro livro = new LivroDao(conexao).pesquisarLivroId(emprestimo.getLivroEmprestado().getIdLivro());
            Usuario usuario = new UsuarioDao(conexao).pesquisarUsuarioId(emprestimo.getUsuarioRetirante().getIdUsuario());
            

            
        }
        return historico
    } catch( Exception e){
        System.out.println("Erro ao listar o historico de emprestimos" + e.getMessage());
    }
    
    }

}
