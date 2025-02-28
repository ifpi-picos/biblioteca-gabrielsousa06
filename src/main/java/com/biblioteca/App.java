package com.biblioteca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App {
    public static void main(String[] args){
        
        try{
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            
            if(conexao != null){
            System.out.println("Banco de dados conectado com sucesso");
            Statement stm = conexao.createStatement();
            insereDados(stm);
            consultaDados(stm);

            }

            else{
                System.out.println("Conexao falhou!");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
        
    public static void consultaDados(Statement stm){
        String sql = "select id,nome from usuario";
        try{
            ResultSet result = stm.executeQuery(sql);
            while(result.next()){
                System.out.println("Id: " + result.getInt("id") + "Nome: " + result.getString("nome"));
            }
        } 
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    
        public static void insereDados(Statement stm){
            String sql = "insert into usuario(nome,cpf,email) values('silva','3245323466','gebas@outlook.com')";
            try{
                stm.executeUpdate(sql);
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
}
// package com.biblioteca;

// public class App {
//     public static void main(String[] args){
//         boolean isRunning = true;
//         while(isRunning){
//             System.out.println("\nEscolha:\n 1- Adicionar livro\n 2- Listar livros\n 3- Realizar empréstimo de livro\n 4- Realizar devolução de livro\n 5- Cadastrar usuário\n 6- Ver histórico de empréstimos do usuário\n 0- Sair do programa");
//             int menu = Acoes.scanner.nextInt();

//             switch (menu) {
//                 case 1: 
//                     Acoes.cadastrarLivro();   
//                     break;
//                 case 2:
//                     if(Acoes.livrosBiblioteca.size() != 0){
//                         Acoes.listaLivros();
//                     }else{
//                         System.out.println("NENHUM LIVRO CADASTRADO");
//                     }
//                     break;
//                 case 3:
//                     Acoes.emprestimoLivro();
//                     break;
//                 case 4:
//                     Acoes.devolucaoLivro();
//                     break;
//                 case 5:
//                     Acoes.cadastrarUsuario();
//                     break;
//                 case 6:
//                     Acoes.historicoEmprestimosUsuario();
//                     break;
//                 default:
//                     System.out.println("Programa encerrado!");
//                     isRunning = false;
//                     break;
//             }
//         }
//         Acoes.scanner.close();
//     }
// }
