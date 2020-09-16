package com.giordano.gameanalyzerapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giordano.gameanalyzerapi.api.DTO.GameDTO;
import com.giordano.gameanalyzerapi.domain.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	private GameService gameService;

	@GetMapping
	public ResponseEntity<List<GameDTO>> getAllGames() {
		return ResponseEntity.ok(gameService.getAllGames());
	}
	
}
