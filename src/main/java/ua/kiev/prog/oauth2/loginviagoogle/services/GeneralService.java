package ua.kiev.prog.oauth2.loginviagoogle.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kiev.prog.oauth2.loginviagoogle.model.Citizen;
import ua.kiev.prog.oauth2.loginviagoogle.model.Flat;
import ua.kiev.prog.oauth2.loginviagoogle.repository.CitizenRepository;
import ua.kiev.prog.oauth2.loginviagoogle.repository.FlatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GeneralService {

@Autowired
    FlatRepository flatRepository;
@Autowired
    CitizenRepository citizenRepository;

public Flat getFlatById(Long id){

    Optional<Flat> flat = flatRepository.findById(id);

    return flat.get();
}

public void saveFlat(Flat flat){
    flatRepository.save(flat);
}

public List<Citizen> getCitizenByFlatId(Long id){

    return citizenRepository.findAllByFlatId(id);
}


public  void saveCitizen(Citizen citizen){
    citizenRepository.save(citizen);

}


}
