package br.com.uniexpress.logismart.apiLog.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@ToString
public class ApiLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    @NotNull
    private LocalDateTime horarioDaConsulta;
    @Lob
    @NotBlank
    private String response;

    public ApiLog(String response) {
        this.horarioDaConsulta = LocalDateTime.now();
        this.response = response;
    }
}
