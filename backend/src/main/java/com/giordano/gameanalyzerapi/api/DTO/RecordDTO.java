package com.giordano.gameanalyzerapi.api.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.giordano.gameanalyzerapi.domain.model.Record;

import lombok.Data;


@Data
public class RecordDTO implements Serializable {


	private static final long serialVersionUID = 1L;

	private Long id;
	
	private LocalDateTime moment;
	
	private String name;
	
	private Integer age;
	
	private String game;
	
	private String platform;
	
	private String genre;

	public RecordDTO() {
		super();
	}

	public RecordDTO(Record record) {
		this.id = record.getId();
		this.moment = record.getMoment();
		this.name = record.getName();
		this.age = record.getAge();
		this.game = record.getGame().getTitle();
		this.platform = record.getGame().getPlatform().name();
		this.genre = record.getGame().getGenre().getName();
	}
	
	
}
