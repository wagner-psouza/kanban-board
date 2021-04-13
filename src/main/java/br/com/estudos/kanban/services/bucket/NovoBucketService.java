package br.com.estudos.kanban.services.bucket;

import br.com.estudos.kanban.entities.Bucket;
import br.com.estudos.kanban.repositories.BoardRepository;
import br.com.estudos.kanban.repositories.BucketRepository;
import br.com.estudos.kanban.request.bucket.CriarBucketRequest;
import br.com.estudos.kanban.response.bucket.CriarBucketResponse;
import org.springframework.stereotype.Service;

@Service
public class NovoBucketService {

    private final BoardRepository boardRepository;
    private final BucketRepository bucketRepository;

    public NovoBucketService(BoardRepository boardRepository, BucketRepository bucketRepository) {
        this.boardRepository = boardRepository;
        this.bucketRepository = bucketRepository;
    }

    public CriarBucketResponse execute(Long id, CriarBucketRequest request) {
        var board = boardRepository.findById(id).orElseThrow();
        var bucket = bucketRepository.save(new Bucket(board, request.getNome(), request.getOrdem()));

        return new CriarBucketResponse(bucket.getId(), bucket.getNome(), bucket.getOrdem(), bucket.getDataCriacao());
    }
}
