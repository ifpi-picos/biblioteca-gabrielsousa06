package com.biblioteca;

public interface Notificacao {
    public void notificacaoDeConfirmacao(String operacao, String nomeUsuario, String nomeLivro);

    default void notificacaoDeCancelamento(String operacao){
        System.out.println(operacao + " cancelado!");
    };
}
