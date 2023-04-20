package com.teste.itau.adiantamento.adiantamento.services;

import com.teste.itau.adiantamento.adiantamento.client.JurosClient;
import com.teste.itau.adiantamento.adiantamento.dto.ParcelaDTO;
import com.teste.itau.adiantamento.adiantamento.exceptions.ParcelaException;
import com.teste.itau.adiantamento.adiantamento.model.Juros;
import com.teste.itau.adiantamento.adiantamento.model.Parcelas;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class ParcelaService {

    Map<Integer, Parcelas> map = null;

    public Parcelas alterarParcelas(ParcelaDTO parcelaDTO) throws ParcelaException {
        Parcelas parcelas = getParcela(parcelaDTO.getNumContrato());

        if (parcelas != null) {

            if (parcelaDTO.getNumParcelas() > parcelas.getQtdParcelas()) {
                throw new ParcelaException("Numero de parcelas menor que atual");
            }

            if (!parcelas.isIsativo()) {
                throw new ParcelaException("Contrato inativo ");
            }

            BigDecimal valorParcela = parcelas.getValorParcela();
            Juros juros = getJuros();
            BigDecimal novaParclea = valorParcela.divide(new BigDecimal(100)).multiply(juros.getTaxa());

            map.get(parcelaDTO.getNumContrato()).setValorParcela(novaParclea);

        } else {
            throw new ParcelaException("Contrato não existe ");
        }
        return map.get(parcelaDTO.getNumContrato());
    }

    private Parcelas getParcela(Integer numContrato){
         if (map == null){
             map = new HashMap<>();

             Parcelas parc =
                     Parcelas.builder().qtdParcelas(10).valorParcela(new BigDecimal(100.00)).isativo(true).numContrato(1).build();

             Parcelas parc2 =
                     Parcelas.builder().qtdParcelas(5).valorParcela(new BigDecimal(150.00)).isativo(true).numContrato(2).build();

             Parcelas parc3 =
                     Parcelas.builder().qtdParcelas(6).valorParcela(new BigDecimal(200.00)).isativo(true).numContrato(3).build();

             Parcelas parc4 =
                     Parcelas.builder().qtdParcelas(8).valorParcela(new BigDecimal(50.00)).isativo(true).numContrato(4).build();

             map.put(1, parc);
             map.put(2, parc2);
             map.put(3, parc3);
             map.put(4, parc4);
         }

         if (map.containsKey(numContrato)){
             return  map.get(numContrato);
         }
         return null;
    }

    private Juros getJuros() {
        /**
         *  chama o feing
         */

//        JurosClient

        return Juros.builder().taxa(new BigDecimal(3.5)).build();
    }
}
