package br.com.estudos.kanban.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "board")
    @OrderBy("ordem")
    private List<Bucket> buckets;

    @Deprecated
    public Board() {
    }

    public Board(String nome) {
        this.nome = nome;
        this.dataCriacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public List<Bucket> getBuckets() {
        return buckets;
    }
}
