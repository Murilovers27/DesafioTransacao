package com.murilo.transacao.business.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.murilo.transacao.Controller.dtos.TransacaoRequest;
import com.murilo.transacao.infra.exceptions.UnprocessableEntity;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@AllArgsConstructor
public class TransacaoService {
    public final List<TransacaoRequest> listaTransacoes = new ArrayList<>();

    
    public void adicionar(TransacaoRequest dto){
        log.info("Iniciando o processo de gravas transaçoes");
        if(dto.dataHora().isAfter(OffsetDateTime.now())){
            log.error("data e hora maiores que a data atual e hora atual");
            throw new UnprocessableEntity("Data e hora maiores que a data e hora de envio");
        }
        
        if(dto.valor() < 0){
            log.error("O valor não pode ser menor que zero");
            throw new UnprocessableEntity("O valor não pode ser menor que 0");
        }
    }
}
