package br.com.codenation.projetoPratico.entity;




import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
//@Table(name = "errorlogs")
public class ErrorLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private Long id;

    @Column
    @NotNull
    @Size(max = 100)
    @JsonView(View.Public.class)
    private String level;

    @Column
    @Email
    @Size(max = 100)
    @NotNull
    @JsonView(View.Public.class)
    private String description;

    @Column
    @NotNull
    @JsonIgnore
    @JsonView(View.Internal.class)
    private String log;

    @Column
    @NotNull
    @Size(max = 255)
    @JsonView(View.Public.class)
    private String origin;

    @Column
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonView(View.Public.class)
    private LocalDateTime createdAt;

    @Column
    @JsonView(View.Public.class)
    private Long quantity;

}
