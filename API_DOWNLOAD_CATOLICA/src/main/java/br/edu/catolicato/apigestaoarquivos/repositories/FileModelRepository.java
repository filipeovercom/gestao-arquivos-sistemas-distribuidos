package br.edu.catolicato.apigestaoarquivos.repositories;

import br.edu.catolicato.apigestaoarquivos.entities.FileModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileModelRepository extends MongoRepository<FileModel, String> {
}
