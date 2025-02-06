package com.murilo.transacao.Controller.dtos;

import java.time.OffsetDateTime;


public record TransacaoRequest(Double valor, OffsetDateTime dataHora) {
    
}
