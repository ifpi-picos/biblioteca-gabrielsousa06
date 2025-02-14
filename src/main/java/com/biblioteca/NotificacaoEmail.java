package com.biblioteca;

public class NotificacaoEmail implements Notificacao{

    @Override
    public void notificacaoDeConfirmacao(String operacao, String nomeUsuario, String nomeLivro) {
            System.out.println(operacao + " do livro: " + nomeLivro + " para " + nomeUsuario + " foi realizado com sucesso!");
    }

    @Override
    public void notificacaoDeCancelamento(String operacao) {
        Notificacao.super.notificacaoDeCancelamento(operacao);
        
    }
}
