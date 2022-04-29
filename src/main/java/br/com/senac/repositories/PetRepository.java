package br.com.senac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.entities.PetEntity;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Integer> {

}
