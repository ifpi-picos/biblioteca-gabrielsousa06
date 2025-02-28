package com.biblioteca.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.dominio.Livro;

public class LivroDao {
    private Connection conexao;

    public LivroDao(Connection conexao){
        this.conexao = conexao;
    }

    public void cadastrarLivro(Livro livro){
        String sql = "INSERT into livro (titulo, autor, editora, ano, emprestimo) values(?,?,?,?,FALSE)";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, livro.getTitulo());
            stm.setString(2, livro.getAutor());
            stm.setString(3, livro.getEditora());
            stm.setInt(4, livro.getAno());
            stm.executeUpdate();
            System.out.println("Livro cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar livro!" + e.getMessage());
        }
    }

    public List<Livro> listarLivros(){
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT *FROM livro";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                Livro livro = new Livro(result.getString("titulo"), result.getString("autor"), result.getString( "editora"), result.getInt("ano"));

                livro.setEmprestimo(result.getBoolean("emprestimo"));
                livro.setIdLivro(result.getInt("id"));
                livros.add(livro);
            }
        return livros;

        } catch(Exception e){
            System.out.println("Erro ao listar os livros" + e.getMessage());
        }
        return null;
    }

    public Livro pesquisarLivroTitulo(String titulo){
        String sql = "SELECT titulo, autor, editora, ano, emprestimo FROM livro WHERE titulo = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1,titulo);

            ResultSet result = stm.executeQuery();
            if(result.next()){
                Livro livro = new Livro(result.getString("titulo"), result.getString("autor"), result.getString( "editora"), result.getInt("ano"));

                livro.setEmprestimo(result.getBoolean("emprestimo"));
                livro.setIdLivro(result.getInt("id"));
                return livro;
            }

        } catch (Exception e) {
            System.out.println("Erro ao pesquisar livro pelo titulo!" + e.getMessage());
        }
        return null;
    }

    public Livro pesquisarLivroId(int id){
        String sql = "SELECT titulo, autor, editora, ano, emprestimo FROM livro WHERE id = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);

            ResultSet result = stm.executeQuery();
            if(result.next()){
                Livro livro = new Livro(result.getString("titulo"), result.getString("autor"), result.getString( "editora"), result.getInt("ano"));

                livro.setEmprestimo(result.getBoolean("emprestimo"));
                livro.setIdLivro(result.getInt("id"));
                return livro;
            }

        } catch (Exception e) {
            System.out.println("Erro ao pesquisar livro pelo id!" + e.getMessage());
        }
        return null;
    }

    public void atualizarLivro(Livro livro){
        String sql = "UPDATE livro SET titulo = ? autor = ? editora = ? ano = ? emprestimo = ? WHERE id = ?";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, livro.getTitulo());
            stm.setString(2, livro.getAutor());
            stm.setString(3, livro.getEditora());
            stm.setInt(4, livro.getAno());
            stm.setBoolean(5, livro.isEmprestimo());
            stm.setInt(6, livro.getIdLivro());
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar o livro" + e.getMessage());
        }
    }
}
