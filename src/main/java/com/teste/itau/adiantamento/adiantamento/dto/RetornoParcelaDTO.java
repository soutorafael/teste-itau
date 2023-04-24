package com.teste.itau.adiantamento.adiantamento.dto;

import com.teste.itau.adiantamento.adiantamento.model.Parcelas;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Builder
@Data
public class RetornoParcelaDTO {

    private Parcelas parcela;
    private String messagem;
    private Integer status;
}
