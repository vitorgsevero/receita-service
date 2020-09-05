package com.vitorgsevero.io.receitaapi.model;

import com.vitorgsevero.io.receitaapi.auditing.ReceitaAudit;
import lombok.Data;

/**
 * @author vitorgsevero<vitorgsevero@gmail.com>
 */
@Data
public class Receita extends ReceitaAudit {

    private String agencia;

    private String conta;

    private double saldo;

    private String status;


}
