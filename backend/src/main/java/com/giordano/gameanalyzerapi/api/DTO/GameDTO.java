package com.giordano.gameanalyzerapi.api.DTO;

import java.io.Serializable;

import com.giordano.gameanalyzerapi.domain.model.Game;

import lombok.Data;

@Data
public class GameDTO implements Serializable {


	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String title;
	
	private String platform;

	public GameDTO(Game game) {
		this.id = game.getId();
		this.title = game.getTitle();
		this.platform = game.getPlatform().name();
	}
	
	
	
	
}
