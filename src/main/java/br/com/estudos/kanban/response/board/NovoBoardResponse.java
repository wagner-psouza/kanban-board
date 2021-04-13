package br.com.estudos.kanban.response.board;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class NovoBoardResponse {

    @ApiModelProperty(value = "Identificação")
    @JsonProperty("id")
    private Long id;

    @ApiModelProperty(value = "Nome")
    @JsonProperty("nome")
    private String nome;

    @ApiModelProperty(value = "Data hora da criação")
    @JsonProperty("data_criacao")
    private LocalDateTime data;

    public NovoBoardResponse(Long id, String nome, LocalDateTime data) {
        this.id = id;
        this.nome = nome;
        this.data = data;
    }

    public Long getId() {
        return id;
    }
}
