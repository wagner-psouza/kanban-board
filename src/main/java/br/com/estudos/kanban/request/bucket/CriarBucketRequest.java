package br.com.estudos.kanban.request.bucket;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Validated
public class CriarBucketRequest {

    @NotBlank
    @Size(min = 5, max = 50)
    @JsonProperty("nome")
    private String nome;

    @Min(1)
    @Max(100000)
    @JsonProperty("ordem")
    private Double ordem;

    public String getNome() {
        return nome;
    }

    public Double getOrdem() {
        return ordem;
    }
}
