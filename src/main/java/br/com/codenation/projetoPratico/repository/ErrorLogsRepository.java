package br.com.codenation.projetoPratico.repository;

import br.com.codenation.projetoPratico.entity.ErrorLogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ErrorLogsRepository extends JpaRepository<ErrorLogs, String> {

    Page<ErrorLogs> findAll(Pageable pageable);

    List <ErrorLogs> findById(Long id);

    List<ErrorLogs> findByLevel(String level);

    List <ErrorLogs> findByDescription(String description);

    List <ErrorLogs> findByLog(String log);

    List <ErrorLogs> findByOrigin(String origin);

    List <ErrorLogs> findByCreatedAt(LocalDateTime date);

    List <ErrorLogs> findByQuantity(Long quantity);

    Page<ErrorLogs> findByLevelContaining(String level, Pageable pageable);


    Page<ErrorLogs> findByDescriptionContaining(String description, Pageable pageable);

    Page<ErrorLogs> findByLogContaining(String log, Pageable pageable);

    Page<ErrorLogs> findByOriginContaining(String origin, Pageable pageable);

    Page<ErrorLogs> findByCreatedAtContaining(LocalDateTime date, Pageable pageable);

    Page<ErrorLogs> findByQuantityContaining(Long quantity, Pageable pageable);

}
