package io.zolthan31.votacaobbbapi.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.zolthan31.votacaobbbapi.model.ParticipanteModel;
import io.zolthan31.votacaobbbapi.repositories.ParticipanteRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/participantes")
public class ParticipanteController {
	
	
	private final ParticipanteRepository repository;
	
	
	@PostMapping("/salvar")
	public ResponseEntity<ParticipanteModel> salvar(@RequestBody ParticipanteModel participante) {
		
		ParticipanteModel entidade = repository.save(participante);
		return ResponseEntity.ok(entidade);
	}
	
	@GetMapping("/consultar")
	public ResponseEntity<ParticipanteModel> consulta(@RequestParam String id) {
		Optional<ParticipanteModel> optParticipante = repository.findById(id);
		
		if(optParticipante.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optParticipante.get());
	}

}
