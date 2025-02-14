package com.biblioteca.dominio;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String cpf;
    private String email;
    private List<Livro> historicoEmprestimos = new ArrayList<>();
    
        public Usuario(String nomeUsuario, String cpf, String email){
            this.nome = nomeUsuario;
            this.cpf = cpf;
            this.email = email;
        }
    
        public void exibirValoresUsuario() {
            System.out.printf("%nNome: %s %nCpf: %s %nEmail: %s %n", nome, cpf, email);
        }
    
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        public String getCpf() {
            return cpf;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    
        public void historicoEmprestimos(Livro livroRetirado){
            historicoEmprestimos.add(livroRetirado);
    }

    public List<Livro> getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }
    
    
}
