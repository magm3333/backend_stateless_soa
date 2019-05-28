package com.coop.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coop.model.Archivo;

@Repository
public interface ArchivoRepository extends JpaRepository<Archivo, Long> {

	}
