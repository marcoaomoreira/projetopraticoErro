package br.com.codenation.projetoPratico.controller;

import br.com.codenation.projetoPratico.entity.ErrorLogs;
import br.com.codenation.projetoPratico.service.ErrorLogsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/errorlog")
public class ErrorLogController {

    @Autowired
    private ErrorLogsServiceInterface errorLogsService;

    @GetMapping
    public List<ErrorLogs> findAll(Pageable pageable){
        return this.errorLogsService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public List<ErrorLogs> findById(@PathVariable("id") Long id){
        return this.errorLogsService.findById(id);
    }


}
