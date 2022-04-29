package br.com.senac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entities.PetEntity;
import br.com.senac.repositories.PetRepository;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	
	public List<PetEntity> getAll(){
		List<PetEntity> lista = petRepository.findAll();
		List<PetEntity> list = new ArrayList<>();
		
		for (PetEntity petEntity : lista) {
			list.add(petEntity);
		}
		
		return list;
	}
	
	public PetEntity save(PetEntity pet) {
		return petRepository.save(pet);
	}
}
