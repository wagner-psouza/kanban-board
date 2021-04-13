package br.com.estudos.kanban.response.bucket;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class CriarBucketResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("ordem")
    private Double ordem;

    @JsonProperty("data_criacao")
    private LocalDateTime data;

    public CriarBucketResponse(Long id, String nome, Double ordem, LocalDateTime data) {
        this.id = id;
        this.nome = nome;
        this.ordem = ordem;
        this.data = data;
    }

    public Long getId() {
        return id;
    }
}
