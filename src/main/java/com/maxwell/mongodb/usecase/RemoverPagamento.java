package com.maxwell.mongodb.usecase;

public interface RemoverPagamento {

    void removerPagamento(String id);

    void removerTodosPagamentos();
}
