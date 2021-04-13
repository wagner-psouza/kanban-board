package br.com.estudos.kanban.response.board;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BucketResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("ordem")
    private Double ordem;

    public BucketResponse(Long id, String nome, Double ordem) {
        this.id = id;
        this.nome = nome;
        this.ordem = ordem;
    }
}
