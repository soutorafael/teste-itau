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

    @ExceptionHandler(PagamentoException.class)
    @RequestMapping(value =  "/adiantamento/pagamento", method = RequestMethod.POST)
    public ResponseEntity<Pagamento> pagamento(@RequestBody PagamentoDTO pagamento){
        return ResponseEntity.ok().body(pagamentoService.adiantaPagamento(pagamento));
    }

    @ExceptionHandler(ParcelaException.class)
    @RequestMapping(value =  "/adiantamento/parcela", method = RequestMethod.POST)
    public ResponseEntity<Parcelas> parcela(@RequestBody ParcelaDTO parcelaDTO){
        return ResponseEntity.ok().body(parcelaService.alterarParcelas(parcelaDTO));
    }
}
