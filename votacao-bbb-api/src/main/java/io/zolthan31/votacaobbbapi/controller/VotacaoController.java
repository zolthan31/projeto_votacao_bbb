package io.zolthan31.votacaobbbapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.zolthan31.votacaobbbapi.model.ParticipanteModel;
import io.zolthan31.votacaobbbapi.service.VotacaoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/votacao")
@RequiredArgsConstructor
public class VotacaoController {	
	
	private final VotacaoService service;
	
	@PostMapping
	public ResponseEntity<String> votar(@RequestBody ParticipanteModel participante) {
		service.adicionarEvento(participante);
		return ResponseEntity.ok("voto computado");
	}

}
