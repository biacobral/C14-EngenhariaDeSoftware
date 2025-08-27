package br.inatel.cdg.teste;

import br.inatel.cdg.model.Fila;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FilaTeste {

    @Test
    public void testeFilaVazia(){
        Fila<Integer> fila = new Fila<Integer>();
        boolean vazia = fila.filaVazia();
        assertTrue(vazia);
    }

    @Test
    public void testeEnfileirar(){
        Fila<Integer> fila = new Fila<Integer>();
        fila.enfileirar(1);
        fila.enfileirar(2);
        int tamanho = fila.size();
        assertEquals(2, tamanho);
    }

    @Test
    public void testeRemoverFila(){
        Fila<Integer> fila = new Fila <Integer>();
        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.removerFila();
        int tamanho = fila.size();
        assertEquals(1, tamanho);
    }
}
