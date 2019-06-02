package com.android.projetoimobiliaria.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

public class Corretor extends SugarRecord {
    @Unique
    private int codigo;
    private String nome;
    private String telefone;
    private int creci;

    public Corretor() {

    }

    public Corretor(int codigo, String nome, String telefone, Endereco endereco, int creci) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.creci = creci;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCreci() {
        return creci;
    }

    public void setCreci(int creci) {
        this.creci = creci;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome;
    }
}
