package org.example;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Beatriz", 20);

        Gson gson = new Gson();
        String json = gson.toJson(pessoa);

        System.out.println("Objeto em JSON: " + json);

        // Converte de volta JSON → objeto
        Pessoa novaPessoa = gson.fromJson(json, Pessoa.class);
        System.out.println("Nome: " + novaPessoa.getNome() + ", Idade: " + novaPessoa.getIdade());
    }
}
