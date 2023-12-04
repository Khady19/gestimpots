package sn.isi.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.isi.entities.Paiement;
import sn.isi.repository.PaiementRep;
import sn.isi.services.IPaiement;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaiementImpl implements IPaiement {
    private PaiementRep paiementRep;

    @Override
    public Paiement CreatePaiement(Paiement paiement) {return  paiementRep.save(paiement);

    }

    @Override
    public Paiement getPaiementById(Long paiementId) {
        Optional<Paiement> optionalPaiement =paiementRep.findById(paiementId);
        return optionalPaiement.get();
    }

    @Override
    public List<Paiement> getAllPaiement() {
        return paiementRep.findAll();
    }

    @Override
    public Paiement updatePaiement(Paiement paiement) {
        Paiement existingPaiement = paiementRep.findById(paiement.getId()).get();
        existingPaiement.setDatePaiement(paiement.getDatePaiement());
        existingPaiement.setMontantPaiement(paiement.getMontantPaiement());
        existingPaiement.setDeclaration(paiement.getDeclaration());
        Paiement updatedPaiement = paiementRep.save(existingPaiement);
        return updatedPaiement;
    }

    @Override
    public void deletePaiement(Long paiementId) {
        paiementRep.deleteById(paiementId);

    }
}
