package com.biblioteca.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.biblioteca.dominio.Usuario;

public class UsuarioDao {
    private Connection conexao;

    public UsuarioDao(Connection conexao){
        this.conexao = conexao;
    }

    public void cadastrarUsuario(Usuario usuario){
        String sql = "insert into usuario(nome,cpf,email) values(?,?,?)";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getCpf());
            stm.setString(3, usuario.getEmail());
            stm.executeUpdate();
            System.out.println("Usuário cadastrado!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário" + e.getMessage());
        }
    }

    public Usuario pesquisarUsuarioCpf(String cpf){
        String sql = "SELECT id,nome,cpf,email FROM usuario WHERE cpf = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, cpf);

            ResultSet result =  stm.executeQuery();

            if(result.next()){
                Usuario usuario = new Usuario(result.getString("nome"), result.getString("cpf"), result.getString("email"));

                usuario.setIdUsuario(result.getInt("id"));
                return usuario;
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar procurar o Cpf!" + e.getMessage());
        }
        System.out.println("Erro ao encontrar usuário!");
        return null;
    }

    public Usuario pesquisarUsuarioId(int id){
        String sql = "SELECT id,nome,cpf,email FROM usuario WHERE id = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);

            ResultSet result =  stm.executeQuery();

            if(result.next()){
                Usuario usuario = new Usuario(result.getString("nome"), result.getString("cpf"), result.getString("email"));

                usuario.setIdUsuario(result.getInt("id"));
                return usuario;
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar procurar o Id !" + e.getMessage());
        }
        System.out.println("Erro ao encontrar usuário!");
        return null;
    }


}
