package com.luiz.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luiz.api.domain.Image;

public interface ImageRespository extends JpaRepository<Image, Long> {
	Optional<Image> findByName(String name);
}
