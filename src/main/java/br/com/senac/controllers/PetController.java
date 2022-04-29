package br.com.senac.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.entities.PetEntity;
import br.com.senac.repositories.PetRepository;
import br.com.senac.service.PetService;

@RestController
@RequestMapping(value="pets")
public class PetController {
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private PetService petService;
	
	private static final String[] PETS = new String [] {
			"Floquinho", "Bolinha", "Tulipa"
	};
	
	@GetMapping( value = "{id}")
	public ResponseEntity<PetEntity> getOne(@PathVariable int id){
		if (id >= 0 && id < PETS.length) {
			PetEntity pet = new PetEntity(id, PETS[id]);
			System.out.println(pet);
			return ResponseEntity.ok().body(pet);
		}
		return null;
	};
	
	@GetMapping()
	public ResponseEntity<List<PetEntity>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(petService.getAll());
	};
	
	@PostMapping
	public ResponseEntity<PetEntity> save (@RequestBody PetEntity pet){
		return ResponseEntity.status(HttpStatus.OK).body(petService.save(pet));
		
	}
	
//	@PostMapping()
//	public List<PetEntity> save(@RequestBody PetEntity String [] PETS){
//			List<PetEntity> pets = petRepository.findAll(PETS);
//			List<PetEntity> list = new ArrayList<>();
//			
//			for (PetEntity petEntity : pets) {
//				list.add(petEntity);
//			}
//					
//			return list;
//		}
//	}
}
	

