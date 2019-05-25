package com.android.projetoimobiliaria.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

public class Imovel extends SugarRecord {
    @Unique
    private int codigo;
    private String descricao;
    private Endereco endereco;
    private Double tamanho;
    private Double valorVenda;
    private Double valorAluguel;
    private Locatario locatario;
    private Corretor corretor;
    private boolean alugada;

    public Imovel() {
    }

    public Imovel(int codigo, String descricao, Endereco endereco, Double tamanho,
                  Double valorVenda, Double valorAluguel, Locatario locatario, Corretor corretor, boolean alugada) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.endereco = endereco;
        this.tamanho = tamanho;
        this.valorVenda = valorVenda;
        this.valorAluguel = valorAluguel;
        this.locatario = locatario;
        this.corretor = corretor;
        this.alugada = alugada;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public boolean isAlugada() {
        return alugada;
    }

    public void setAlugada(boolean alugada) {
        this.alugada = alugada;
    }

    @Override
    public String toString() {
        return "Imovel{}";
    }
}
