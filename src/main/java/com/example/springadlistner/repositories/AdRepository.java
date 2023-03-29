package com.example.springadlistner.repositories;

import com.example.springadlistner.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findById(long id);
}
