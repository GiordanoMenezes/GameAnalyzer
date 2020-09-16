package com.giordano.gameanalyzerapi.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.giordano.gameanalyzerapi.domain.model.enums.Platform;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Game implements Serializable {


	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private Platform platform;
	
	@ManyToOne
	@JoinColumn(name="genre_id")
	private Genre genre;
	
	@OneToMany(mappedBy = "game")
	private List<Record> records = new ArrayList<>();

	public Game() {
		super();
	}
	
	
	
	
}
