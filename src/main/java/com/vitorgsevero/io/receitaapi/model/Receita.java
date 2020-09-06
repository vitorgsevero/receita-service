package com.vitorgsevero.io.receitaapi.model;

import com.vitorgsevero.io.receitaapi.auditing.ReceitaAudit;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author vitorgsevero<vitorgsevero@gmail.com>
 */
@Data
@Entity
public class Receita extends ReceitaAudit {

    @Id
    private Long id;

    private String agencia;

    private String conta;

    private double saldo;

    private String status;


}
