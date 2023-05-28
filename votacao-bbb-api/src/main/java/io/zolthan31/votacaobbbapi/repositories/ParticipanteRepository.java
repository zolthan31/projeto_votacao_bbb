package io.zolthan31.votacaobbbapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.zolthan31.votacaobbbapi.model.ParticipanteModel;

public interface ParticipanteRepository extends MongoRepository<ParticipanteModel, String>{

}
