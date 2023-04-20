package com.teste.itau.adiantamento.adiantamento.dto;

import com.teste.itau.adiantamento.adiantamento.model.Pagamento;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Data
public class RetornoPagamentoDTO {

    private Pagamento pagamento;
    private String messagem;
    private Integer status;
}
