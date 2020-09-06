/*
Cenário de Negócio:
Todo dia útil por volta das 6 horas da manhã um colaborador da retaguarda do Sicredi recebe e organiza as informações de contas para enviar ao Banco Central. Todas agencias e cooperativas enviam arquivos Excel à Retaguarda. Hoje o Sicredi já possiu mais de 4 milhões de contas ativas.
Esse usuário da retaguarda exporta manualmente os dados em um arquivo CSV para ser enviada para a Receita Federal, antes as 10:00 da manhã na abertura das agências.

Requisito:
Usar o "serviço da receita" (fake) para processamento automático do arquivo.

Funcionalidade:
0. Criar uma aplicação SprintBoot standalone. Exemplo: java -jar SincronizacaoReceita <input-file>
1. Processa um arquivo CSV de entrada com o formato abaixo.
2. Envia a atualização para a Receita através do serviço (SIMULADO pela classe ReceitaService).
3. Retorna um arquivo com o resultado do envio da atualização da Receita. Mesmo formato adicionando o resultado em uma nova coluna.


Formato CSV:
agencia;conta;saldo;status
0101;12225-6;100,00;A
0101;12226-8;3200,50;A
3202;40011-1;-35,12;I
3202;54001-2;0,00;P
3202;00321-2;34500,00;B
...

*/

package com.vitorgsevero.io.receitaapi;

import com.vitorgsevero.io.receitaapi.auditing.AuditorAwareImpl;
import com.vitorgsevero.io.receitaapi.csv.LeitorCSV;
import com.vitorgsevero.io.receitaapi.model.Receita;
import com.vitorgsevero.io.receitaapi.services.ReceitaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.IOException;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ReceitaApiApplication {

	@Bean
	public AuditorAware<String> auditorAware(){
		return new AuditorAwareImpl();
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		SpringApplication.run(ReceitaApiApplication.class, args);

		Receita receita = new Receita();
		LeitorCSV leitorCSV = new LeitorCSV();

		leitorCSV.readCSV();

		//TODO - Chamar o endpoint criado após o ajuste para utilização do ReceitaService
		ReceitaService receitaService = new ReceitaService();
		receitaService.atualizarConta(receita.getAgencia(), receita.getConta(), receita.getSaldo(), receita.getStatus());

		leitorCSV.readCSV();

	}

}
