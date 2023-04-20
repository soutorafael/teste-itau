package com.teste.itau.adiantamento.adiantamento;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.itau.adiantamento.adiantamento.dto.PagamentoDTO;
import com.teste.itau.adiantamento.adiantamento.model.Pagamento;
import com.teste.itau.adiantamento.adiantamento.services.PagamentoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PagamentoServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PagamentoService pagamentoService;

    @Test
    void alterarDataPagamentoTest() throws Exception{
        PagamentoDTO pagamentoDTO = PagamentoDTO.builder().dataPagamento(new Date()).numContrato(1).build();
        mockMvc.perform(post("/adiantamento/pagamento")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(pagamentoDTO)))
                .andExpect(status().isOk());

        Pagamento pagamento = pagamentoService.adiantaPagamento(pagamentoDTO);
        Assertions.assertEquals(pagamento.getDataPagamento(),  pagamentoDTO.getDataPagamento());
    }
}
