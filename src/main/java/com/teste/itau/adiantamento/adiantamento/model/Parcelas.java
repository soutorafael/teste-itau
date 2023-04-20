package com.teste.itau.adiantamento.adiantamento.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Data
@Setter
@Getter
public class Parcelas {

    private int qtdParcelas;
    private boolean isativo;
    private Integer numContrato;
    private BigDecimal valorParcela;
    private BigDecimal jurosParcela;
}
