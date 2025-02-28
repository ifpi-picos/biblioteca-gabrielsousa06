package com.biblioteca.Dao;
import java.sql.Connection;
import com.biblioteca.dominio.Emprestimo;

public class EmprestimoDao {
    private Connection conexao;

    public EmprestimoDao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void realizarEmprestimo(Emprestimo emprestimo){
        
    }
}
