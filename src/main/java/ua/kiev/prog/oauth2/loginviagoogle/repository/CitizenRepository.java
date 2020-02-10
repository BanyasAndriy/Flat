package ua.kiev.prog.oauth2.loginviagoogle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.prog.oauth2.loginviagoogle.model.Citizen;
import ua.kiev.prog.oauth2.loginviagoogle.model.Flat;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {


    List<Citizen> findAllByFlatId(Long id);

}
