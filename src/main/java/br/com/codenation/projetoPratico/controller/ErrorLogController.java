package br.com.codenation.projetoPratico.controller;

import br.com.codenation.projetoPratico.entity.ErrorLogs;
import br.com.codenation.projetoPratico.entity.View;
import br.com.codenation.projetoPratico.repository.ErrorLogsRepository;
import br.com.codenation.projetoPratico.service.ErrorLogsServiceInterface;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebFilter;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Long.parseLong;


//@WebFilter("/errorlog/*")
@RestController
@RequestMapping("/errorlog")
public class ErrorLogController {


    @Autowired
    private ErrorLogsServiceInterface errorLogsService;

    @Autowired
    private ErrorLogsRepository repo;

    @PostMapping
    public void create(@Valid @RequestBody ErrorLogs errorLogs){
        this.errorLogsService.save(errorLogs);
    }

    @GetMapping("/{id}")
    @JsonIgnore(false)
    public List<ErrorLogs> findById(@PathVariable("id") Long id){
        return this.errorLogsService.findById(id);
    }

    @JsonView(View.Internal.class)
    @GetMapping("/ByLevel/{level}")
    public List<ErrorLogs> findByLevel(@PathVariable("level") @PathParam("level") String level, Pageable pageable){
        return this.errorLogsService.findByLevel(level, pageable);
    }

    @JsonView(View.Internal.class)
    @GetMapping("/ByDescription/{description}")
    public List<ErrorLogs> findByDescription(@PathVariable("description") @PathParam("description") String description, Pageable pageable){
        if(description!=null){
            return this.errorLogsService.findByDescription(description.toString(), pageable);
        }
        return this.errorLogsService.findByDescription(description, pageable);
    }

    @GetMapping("/ByLog/{log}")
    @JsonView(View.Internal.class)
    public List<ErrorLogs> findByLog(@PathVariable("log") @PathParam("log") String log, Pageable pageable){
        return this.errorLogsService.findByLog(log, pageable);
    }

    @GetMapping("/ByOrigin/{origin}")
    @JsonView(View.Internal.class)
    public List<ErrorLogs> findByOrigin(@PathVariable("origin") @PathParam("origin") String origin, Pageable pageable){
        return this.errorLogsService.findByOrigin(origin, pageable);
    }

    @GetMapping("/ByCreatedAt/{created_at}")
    @JsonView(View.Internal.class)
    public List<ErrorLogs> findByCreatedAt(@PathVariable("created_at") LocalDateTime date, Pageable pageable){
        return this.errorLogsService.findByCreatedAt(date,pageable);
    }

    @GetMapping("/ByQuantity/{quantity}")
    @JsonView(View.Internal.class)
    public List<ErrorLogs> findByQuantity(@PathVariable("quantity") Long quantity, Pageable pageable){
        return this.errorLogsService.findByQuantity(quantity, pageable);
    }


    @GetMapping
    @JsonView(View.Internal.class)
    public Iterable<ErrorLogs> findAll(@PathParam("level") String level,
                                       @PathParam("description") String description,
                                       @PathParam("log") String log,
                                       @PathParam("origin") String origin,
                                       @PathParam("date") LocalDateTime date,
                                       @PathParam("quantity") Long quantity,
                                       Pageable pageable) {
        if(level!=null){
            return this.errorLogsService.findByLevel(level.toString(), pageable);
        }
        if(description!=null){
            return this.errorLogsService.findByDescription(description.toString(), pageable);
        }
        if(origin!=null){
            return this.errorLogsService.findByOrigin(origin.toString(), pageable);
        }
        if(log!=null){
            return this.errorLogsService.findByLog(log.toString(), pageable);
        }
        if(date!=null){
            return this.errorLogsService.findByCreatedAt(date, pageable);
        }
        if(quantity!=null){
            return this.errorLogsService.findByQuantity(quantity, pageable);
        }
        return this.errorLogsService.findAll(pageable);
    }
}
