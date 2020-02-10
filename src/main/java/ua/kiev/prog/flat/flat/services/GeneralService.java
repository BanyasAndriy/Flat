package ua.kiev.prog.flat.flat.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kiev.prog.flat.flat.model.Flat;
import ua.kiev.prog.flat.flat.repository.CitizenRepository;
import ua.kiev.prog.flat.flat.repository.FlatRepository;
import ua.kiev.prog.flat.flat.model.Citizen;

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
