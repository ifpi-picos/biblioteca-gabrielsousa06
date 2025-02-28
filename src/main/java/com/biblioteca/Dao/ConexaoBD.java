package com.biblioteca.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    public Connection ConectarBanco(){
        try{
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            
            if(conexao != null){
                System.out.println("Conexao realizada com sucesso!");
                return conexao;
            }

        }
        catch(SQLException e){
            System.out.println("Erro ao fazer a conexão: " + e.getMessage());
        }
        return null;
    }
}
