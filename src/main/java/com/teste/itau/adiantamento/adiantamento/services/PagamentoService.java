package com.teste.itau.adiantamento.adiantamento.services;

import com.teste.itau.adiantamento.adiantamento.dto.PagamentoDTO;
import com.teste.itau.adiantamento.adiantamento.exceptions.PagamentoException;
import com.teste.itau.adiantamento.adiantamento.model.Pagamento;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class PagamentoService {

    Map<Integer, Pagamento> mapPagamentos = null;

    public Pagamento adiantaPagamento(PagamentoDTO pagDto) throws PagamentoException {

        try {
            LocalDate currentDate = LocalDate.now();
            LocalDate currentDateMinus30Days = currentDate.plusDays(10);
            LocalDate dataPagamento = pagDto.getDataPagamento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            validaPagamento(dataPagamento, currentDateMinus30Days, pagDto);
            alteraParcela(pagDto);
        } catch (PagamentoException e){
            throw new PagamentoException(e.getMessage());
        }
        return mapPagamentos.get(pagDto.getNumContrato());
    }

    private void validaPagamento(LocalDate dataPagamento, LocalDate currentDateMinus30Days, PagamentoDTO pagDto)
            throws PagamentoException{
        if (dataPagamento.isAfter(currentDateMinus30Days)){
            throw new PagamentoException("Data pagamento após 10 dias de hoje");
        }
        Pagamento pagFind = getPagamentos(pagDto.getNumContrato());
        if (!pagFind.isIsativo()){
            throw new PagamentoException("Contrato inátivo");
        }
        if (pagFind.isAtraso()){
            throw new PagamentoException("Contrato atrasado");
        }
        if (!mapPagamentos.containsKey(pagDto.getNumContrato())){
            throw new PagamentoException("Contrato não existe");
        }
    }

    /**
     * Altera a parcela
     * @param pagDto
     */
    private void alteraParcela(PagamentoDTO pagDto) {
        mapPagamentos.get(pagDto.getNumContrato()).setDataPagamento(pagDto.getDataPagamento());
    }

    /**
     * Mock dos pagamentos
     * @param numContrato
     * @return
     */
    private Pagamento getPagamentos(Integer numContrato){
        if (mapPagamentos == null) {
            mapPagamentos = new HashMap<>();
            Pagamento pag = Pagamento.builder().dataPagamento(new Date()).isativo(true).numContrato(1).isAtraso(false).build();
            mapPagamentos.put(1, pag);
            Pagamento pag2 = Pagamento.builder().dataPagamento(new Date()).isativo(false).numContrato(2).isAtraso(false).build();
            mapPagamentos.put(2, pag2);
            Pagamento pag3 = Pagamento.builder().dataPagamento(new Date()).isativo(true).numContrato(2).isAtraso(true).build();
            mapPagamentos.put(3, pag3);
        }

        if (mapPagamentos.containsKey(numContrato)){
            return mapPagamentos.get(numContrato);
        }
        return  null;
    }
}
