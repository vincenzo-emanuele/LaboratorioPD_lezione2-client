package esercizio2;

import java.io.Serializable;

public class Registro implements Serializable {

    public Registro(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    private String nome;
    private String indirizzo;
    private final static long serialVersionUID = 1L;
}