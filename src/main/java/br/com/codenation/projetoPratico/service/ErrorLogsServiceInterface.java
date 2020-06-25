package br.com.codenation.projetoPratico.service;

import br.com.codenation.projetoPratico.entity.ErrorLogs;
import org.springframework.data.domain.Pageable;


import java.time.LocalDateTime;
import java.util.List;

public interface ErrorLogsServiceInterface {

    List<ErrorLogs> findAll(Pageable pageable);

    List<ErrorLogs> findById(Long id);

    List<ErrorLogs> findByLevel(String level, Pageable pageable);

    List<ErrorLogs> findByDescription(String description,  Pageable pageable);

    List <ErrorLogs> findByLog(String log, Pageable pageable);

    List<ErrorLogs> findByOrigin(String origin,  Pageable pageable);

    List <ErrorLogs> findByCreatedAt(LocalDateTime date, Pageable pageable);

    List <ErrorLogs> findByQuantity(Long quantity, Pageable pageable);

    ErrorLogs save(ErrorLogs errorlogs);

}
