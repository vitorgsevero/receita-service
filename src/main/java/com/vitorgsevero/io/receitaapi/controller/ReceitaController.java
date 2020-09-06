package com.vitorgsevero.io.receitaapi.controller;

import com.vitorgsevero.io.receitaapi.model.Receita;
import com.vitorgsevero.io.receitaapi.repository.ReceitaRepository;
import com.vitorgsevero.io.receitaapi.services.ReceitaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/receita")
@Api(value = "All Receita operations", tags = "Receita Controller")
public class ReceitaController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @PutMapping
    @ApiOperation(value = "It creates a new Receita", response = Receita[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Receita UPDATED"),
            @ApiResponse(code = 403, message = "You don't have permission to access this resource"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "An exception occurred")
    })
    public Receita update(@RequestBody Receita receita) throws InterruptedException {
        ReceitaService receitaService = new ReceitaService();
        receitaService.atualizarConta(receita.getAgencia(), receita.getConta(), receita.getSaldo(), receita.getStatus());
        //TODO - Passar o valor alterado do serviço ao invés do novo criado no corpo da requisição
        return receitaRepository.save(receita);
    }


}
