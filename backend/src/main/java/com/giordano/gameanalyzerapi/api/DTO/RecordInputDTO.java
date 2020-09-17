package com.giordano.gameanalyzerapi.api.DTO;

import java.io.Serializable;

import lombok.Data;

@Data
public class RecordInputDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private Integer age;
	
	private Long gameId;

	public RecordInputDTO(String name, Integer age, Long gameId) {
		super();
		this.name = name;
		this.age = age;
		this.gameId = gameId;
	}
	
	
}
