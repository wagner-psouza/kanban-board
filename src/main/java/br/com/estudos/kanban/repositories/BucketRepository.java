package br.com.estudos.kanban.repositories;

import br.com.estudos.kanban.entities.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepository extends JpaRepository<Bucket, Long> {
}
