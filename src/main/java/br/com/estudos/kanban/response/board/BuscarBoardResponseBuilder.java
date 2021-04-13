package br.com.estudos.kanban.response.board;

import br.com.estudos.kanban.entities.Bucket;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public final class BuscarBoardResponseBuilder {

    private Long id;
    private String nome;
    private LocalDateTime data;
    private List<BucketResponse> buckets;

    private BuscarBoardResponseBuilder() {
    }

    public static BuscarBoardResponseBuilder builder() {
        return new BuscarBoardResponseBuilder();
    }

    public BuscarBoardResponseBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public BuscarBoardResponseBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public BuscarBoardResponseBuilder data(LocalDateTime data) {
        this.data = data;
        return this;
    }

    public BuscarBoardResponseBuilder buckets(List<Bucket> buckets){
        this.buckets = buckets.stream()
                .map(bucket -> new BucketResponse(bucket.getId(), bucket.getNome(), bucket.getOrdem()))
                .collect(Collectors.toList());
        return this;
    }

    public BuscarBoardResponse build() {
        return new BuscarBoardResponse(id, nome, data, buckets);
    }

}
