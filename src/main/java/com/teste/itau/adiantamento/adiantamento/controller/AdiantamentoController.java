package com.teste.itau.adiantamento.adiantamento.controller;

import com.teste.itau.adiantamento.adiantamento.dto.PagamentoDTO;
import com.teste.itau.adiantamento.adiantamento.dto.ParcelaDTO;
import com.teste.itau.adiantamento.adiantamento.dto.RetornoPagamentoDTO;
import com.teste.itau.adiantamento.adiantamento.dto.RetornoParcelaDTO;
import com.teste.itau.adiantamento.adiantamento.exceptions.PagamentoException;
import com.teste.itau.adiantamento.adiantamento.exceptions.ParcelaException;
import com.teste.itau.adiantamento.adiantamento.model.Pagamento;
import com.teste.itau.adiantamento.adiantamento.model.Parcelas;
import com.teste.itau.adiantamento.adiantamento.services.PagamentoService;
import com.teste.itau.adiantamento.adiantamento.services.ParcelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdiantamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private ParcelaService parcelaService;

    @RequestMapping(value =  "/adiantamento/pagamento", method = RequestMethod.POST)
    public ResponseEntity<RetornoPagamentoDTO> pagamento(@RequestBody PagamentoDTO pagamento){
        ResponseEntity<RetornoPagamentoDTO> responseEntity = null;
        RetornoPagamentoDTO retornoPagamentoDTO = null;
        try {
            Pagamento pagamentoRetorno  = pagamentoService.adiantaPagamento(pagamento);
            retornoPagamentoDTO = RetornoPagamentoDTO.builder().pagamento(pagamentoRetorno).status(200).build();
            responseEntity = new ResponseEntity<>(retornoPagamentoDTO, HttpStatus.OK);
        } catch (PagamentoException e) {
            retornoPagamentoDTO = RetornoPagamentoDTO.builder().messagem(e.getMessage()).build();
            responseEntity = new ResponseEntity<>(retornoPagamentoDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value =  "/adiantamento/parcela", method = RequestMethod.POST)
    public ResponseEntity<RetornoParcelaDTO> parcela(@RequestBody ParcelaDTO parcelaDTO){
        ResponseEntity<RetornoParcelaDTO> responseEntity = null;
        RetornoParcelaDTO retornoParcelaDTO = null;
        try {
            Parcelas parcelas = parcelaService.alterarParcelas(parcelaDTO);
            retornoParcelaDTO = RetornoParcelaDTO.builder().parcela(parcelas).status(200).build();
            responseEntity = new ResponseEntity<RetornoParcelaDTO>(retornoParcelaDTO, HttpStatus.OK);
        } catch (ParcelaException e){
            retornoParcelaDTO = RetornoParcelaDTO.builder().messagem(e.getMessage()).build();
            responseEntity = new ResponseEntity<RetornoParcelaDTO>( retornoParcelaDTO ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
