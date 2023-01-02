
package ca.sheridancollege.bajajak.assignment2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.sheridancollege.bajajak.assignment2.beans.Cheese;
import ca.sheridancollege.bajajak.assignment2.repositories.MainRepository;

@Service
public class MainService {
    
    @Autowired
    private MainRepository mainRepository;

    public MainService() {
        super();
    }

    public void saveCheese(Cheese cheese) {
        this.mainRepository.saveCheese(cheese);
    }

    public List<Cheese> findAllCheeses() {
        return this.mainRepository.findAllCheeses();
    }
}
