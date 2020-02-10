package ua.kiev.prog.flat.flat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.prog.flat.flat.model.Citizen;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {


    List<Citizen> findAllByFlatId(Long id);

}
