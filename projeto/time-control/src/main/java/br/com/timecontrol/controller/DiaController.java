package br.com.timecontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timecontrol.repository.DiaRepository;

@RestController
@RequestMapping("/dia")
public class DiaController {
 
	@Autowired
	DiaRepository diaRepository;
 
}