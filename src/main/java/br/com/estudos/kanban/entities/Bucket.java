package br.com.estudos.kanban.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bucket")
public class Bucket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "ordem", nullable = false)
    private Double ordem;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Deprecated
    public Bucket() {
    }

    public Bucket(Board board, String nome, Double ordem) {
        this.board = board;
        this.nome = nome;
        this.ordem = ordem;
        this.dataCriacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Board getBoard() {
        return board;
    }

    public String getNome() {
        return nome;
    }

    public Double getOrdem() {
        return ordem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
