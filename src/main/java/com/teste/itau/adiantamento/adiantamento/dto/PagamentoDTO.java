package com.teste.itau.adiantamento.adiantamento.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Builder
@Data
public class PagamentoDTO implements Serializable {

    private Date dataPagamento;
    private Integer numContrato;
}
