package net.javaguides.springboot.repository;


import net.javaguides.springboot.model.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchemeRepository extends JpaRepository<Scheme, Long> {
}