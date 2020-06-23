package br.com.codenation.projetoPratico.repository;

import br.com.codenation.projetoPratico.entity.ErrorLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ErrorLogsRepository extends JpaRepository<ErrorLogs, String> {

    List<ErrorLogs> findByLevel(String level);

    List <ErrorLogs> findById(Long id);

    List <ErrorLogs> findByLog(String log);


}
