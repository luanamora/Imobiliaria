package com.android.projetoimobiliaria.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

public class Locatario extends SugarRecord {
    @Unique
    private int codigo;
    private String nome;
    private int telefone;


    public Locatario() {
    }

    public Locatario(int codigo, String nome, int telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return nome + " - " + telefone;
    }
}
