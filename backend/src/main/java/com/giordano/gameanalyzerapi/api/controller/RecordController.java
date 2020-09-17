package com.giordano.gameanalyzerapi.api.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.giordano.gameanalyzerapi.api.DTO.RecordDTO;
import com.giordano.gameanalyzerapi.api.DTO.RecordInputDTO;
import com.giordano.gameanalyzerapi.domain.services.RecordService;

@RestController
@RequestMapping("/records")
public class RecordController {

	@Autowired
	private RecordService recordService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RecordDTO saveRecord(@RequestBody RecordInputDTO recordInDTO) {
		return recordService.insert(recordInDTO);
	}

	@GetMapping
	public ResponseEntity<Page<RecordDTO>> getAllRecords(
			@RequestParam(value = "min", defaultValue = "") String dateIni,
			@RequestParam(value = "max", defaultValue = "") String dateEnd,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {
		
		LocalDateTime iniDate = "".equals(dateIni) ? null : LocalDate.parse(dateIni, DateTimeFormatter.ofPattern("dd-MM-yyyy")).atStartOfDay();
		LocalDateTime endDate = "".equals(dateEnd) ? null : LocalDate.parse(dateEnd, DateTimeFormatter.ofPattern("dd-MM-yyyy")).atTime(LocalTime.MAX);
		
		if (linesPerPage == 0 ) {
			linesPerPage = Integer.MAX_VALUE;
		}
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return ResponseEntity.ok(recordService.getRecordsByMoments(iniDate,endDate,pageRequest));
	}

}
