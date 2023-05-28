package io.zolthan31.votacaobbbms.service;

import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.zolthan31.votacaobbbms.model.ParticipanteModel;
import io.zolthan31.votacaobbbms.model.VotacaoModel;
import io.zolthan31.votacaobbbms.repositories.VotacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class VotacaoService {
	
	private final VotacaoRepository repository;
	
	@KafkaListener(topics = "votacao", groupId = "MicroServiceVotacao")
	private void executar(ConsumerRecord<String, String> registro) {
		
		String participanteStr  = registro.value();		
		log.info("Voto recebido = {}", participanteStr);
		
		ObjectMapper mapper = new ObjectMapper();
		ParticipanteModel participante = null;
		
		try {
			participante = mapper.readValue(participanteStr, ParticipanteModel.class);
		} catch (JsonProcessingException ex) {
			
			log.error("Falha ao converter voto [{}]", participanteStr, ex);
			return;
		} 
		
		
		VotacaoModel votacao = new VotacaoModel(null, participante, new Date());		
		VotacaoModel entity = repository.save(votacao);
		
		log.info("Voto registrado com sucesso [id={}, dataHora={}]", entity.getId(), entity.getDataHora());
		
	}	
	

}
