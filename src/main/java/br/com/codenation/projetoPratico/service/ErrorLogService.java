package br.com.codenation.projetoPratico.service;

import br.com.codenation.projetoPratico.entity.ErrorLogs;

import br.com.codenation.projetoPratico.repository.ErrorLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ErrorLogService implements ErrorLogsServiceInterface{

    @Autowired
    private ErrorLogsRepository errorLogsRepository;

    @Autowired
    private ErrorLogsServiceInterface errorLogsService;

    @Override
    public List<ErrorLogs> findAll(Pageable pageable) {
        return this.errorLogsRepository.findAll(pageable).getContent();
    }

    @Override
    public List<ErrorLogs> findById(Long id) {
        return this.errorLogsRepository.findById(id);
    }

    @Override
    public List<ErrorLogs> findByLevel(String level, Pageable pageable) {
        return this.errorLogsRepository.findByLevelContaining(level, pageable).getContent();
    }

    @Override
    public List<ErrorLogs> findByDescription(String description, Pageable pageable) {
        return this.errorLogsRepository.findByDescriptionContaining(description,pageable).getContent();
    }

    @Override
    public List<ErrorLogs> findByLog(String log, Pageable pageable) {

        return this.errorLogsRepository.findByLogContaining(log, pageable).getContent();
    }

    @Override
    public List<ErrorLogs> findByOrigin(String origin, Pageable pageable) {
        return this.errorLogsRepository.findByOriginContaining(origin, pageable).getContent();
    }

    @Override
    public List<ErrorLogs> findByCreatedAt(LocalDateTime date, Pageable pageable) {
        return this.errorLogsRepository.findByCreatedAt(date);
    }

    @Override
    public List<ErrorLogs> findByQuantity(Long quantity, Pageable pageable) {
        return this.errorLogsRepository.findByQuantity(quantity);
    }

    @Override
    public ErrorLogs save(ErrorLogs errorlogs) {
        return this.errorLogsRepository.save(errorlogs);
    }


}
