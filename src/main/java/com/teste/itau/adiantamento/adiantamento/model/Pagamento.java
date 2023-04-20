package com.teste.itau.adiantamento.adiantamento.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
@Builder
public class Pagamento {

    private Date dataPagamento;
    private boolean isativo;
    private Integer numContrato;
    private boolean isAtraso;
}
