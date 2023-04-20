package com.teste.itau.adiantamento.adiantamento.client;

import com.teste.itau.adiantamento.adiantamento.model.Juros;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "Taxasjuros", url = "https://itautestes.juros.com/")
public interface JurosClient {

    @RequestMapping(method = RequestMethod.GET, value = "/juros")
    Juros getPosts(@RequestParam int dias);
}
