package br.com.estudos.kanban.request.board;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoBoardRequest {

    @NotBlank
    @Size(min = 5, max = 50)
    @JsonProperty("nome")
    @ApiModelProperty(value = "Nome")
    private String nome;

    public String getNome() {
        return nome;
    }
}
