package com.giordano.gameanalyzerapi.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giordano.gameanalyzerapi.api.DTO.GameDTO;
import com.giordano.gameanalyzerapi.domain.model.Game;
import com.giordano.gameanalyzerapi.domain.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameDTO> getAllGames() {
		List<Game> games = gameRepository.findAll();
		return games.stream().map(game -> new GameDTO(game)).collect(Collectors.toList());
	}
}
