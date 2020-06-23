package br.com.codenation.projetoPratico.service;

import br.com.codenation.projetoPratico.entity.ErrorLogs;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ErrorLogsServiceInterface {

    List <ErrorLogs> findAll(Pageable pageable);

    List<ErrorLogs> findByLevel(String level);

    List <ErrorLogs> findById(Long id);

    List <ErrorLogs> findByLog(String log);
}
