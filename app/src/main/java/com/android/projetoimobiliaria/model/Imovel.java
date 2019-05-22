package com.android.projetoimobiliaria.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

public class Imovel extends SugarRecord {
    @Unique
    private int codigo;
}
