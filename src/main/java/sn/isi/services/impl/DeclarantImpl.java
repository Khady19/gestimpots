package sn.isi.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.isi.entities.Declarants;
import sn.isi.repository.DeclarantRep;
import sn.isi.services.IDeclarant;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DeclarantImpl implements IDeclarant {

    private DeclarantRep declarantRep;

    @Override
    public Declarants createDeclarants(Declarants declarants) {
        return declarantRep.save(declarants);
    }

    @Override
    public Declarants getDeclarantsById(Long declarantsId) {
        Optional<Declarants> optionalDeclarants =declarantRep.findById(declarantsId);
        return optionalDeclarants.get();
    }

    @Override
    public List<Declarants> getAllDeclarants() {
        return declarantRep.findAll();
    }

    @Override
    public Declarants updateDeclarants(Declarants declarants) {
        Declarants existingDeclarants = declarantRep.findById(declarants.getId()).get();
        existingDeclarants.setRaisonsociable(declarants.getRaisonsociable());
        existingDeclarants.setAdresse(declarants.getAdresse());
        existingDeclarants.setEmail(declarants.getEmail());
        existingDeclarants.setTelephone(declarants.getTelephone());
        Declarants updatedDeclarants = declarantRep.save(existingDeclarants);
        return updatedDeclarants;
    }

    @Override
    public void deleteDeclarants(Long declarantsId) {
        declarantRep.deleteById(declarantsId);

    }
}
