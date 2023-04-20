package com.teste.itau.adiantamento.adiantamento;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.itau.adiantamento.adiantamento.dto.ParcelaDTO;
import com.teste.itau.adiantamento.adiantamento.model.Parcelas;
import com.teste.itau.adiantamento.adiantamento.services.ParcelaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ParcelaServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ParcelaService parcelaService;

    @Test
    void alteraParcelaTest() throws  Exception{
        ParcelaDTO parcelaDTO = ParcelaDTO.builder().numParcelas(10).numContrato(1).build();
        mockMvc.perform(post("/adiantamento/parcela")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(parcelaDTO)))
            .andExpect(status().isOk());

        Parcelas parcelas = parcelaService.alterarParcelas(parcelaDTO);

        Assertions.assertEquals(parcelas.getQtdParcelas(), 10);
    }
}
