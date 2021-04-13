package br.com.estudos.kanban.response.board;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.List;

public class BuscarBoardResponse {

    @ApiModelProperty(value = "Identificação")
    @JsonProperty("id")
    private Long id;

    @ApiModelProperty(value = "Nome")
    @JsonProperty("nome")
    private String nome;

    @ApiModelProperty(value = "Data hora da criação")
    @JsonProperty("data_criacao")
    private LocalDateTime data;

    @ApiModelProperty(value = "Lista de buckets")
    @JsonProperty("buckets")
    private List<BucketResponse> buckets;

    public BuscarBoardResponse(Long id, String nome, LocalDateTime data, List<BucketResponse> buckets) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.buckets = buckets;
    }
}
