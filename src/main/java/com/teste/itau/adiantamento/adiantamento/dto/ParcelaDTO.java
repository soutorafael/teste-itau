package com.teste.itau.adiantamento.adiantamento.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Data
public class ParcelaDTO implements Serializable {

    private int numParcelas;
    private Integer numContrato;
}
