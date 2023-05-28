package io.zolthan31.votacaobbbms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.zolthan31.votacaobbbms.model.VotacaoModel;

public interface VotacaoRepository extends MongoRepository<VotacaoModel, String>{

}
