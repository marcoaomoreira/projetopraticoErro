package br.com.codenation.projetoPratico.service;

import br.com.codenation.projetoPratico.entity.ErrorLogs;
import br.com.codenation.projetoPratico.repository.ErrorLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class ErrorLogService implements ErrorLogsServiceInterface{

    @Autowired
    private ErrorLogsRepository errorLogsRepository;


    @Override
    public List<ErrorLogs> findAll(org.springframework.data.domain.Pageable pageable) {
        return this.errorLogsRepository.findAll(pageable).getContent();
    }

    @Override
    public List<ErrorLogs> findByLevel(String level) {
        return this.errorLogsRepository.findByLevel(level);
    }

    @Override
    public List<ErrorLogs> findById(Long id) {
        return this.errorLogsRepository.findById(id);
    }

    @Override
    public List<ErrorLogs> findByLog(String log) {
        return this.errorLogsRepository.findByLog(log);
    }
}
