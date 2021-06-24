package fr.formation.loueunartiste.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.formation.loueunartiste.domain.dtos.ArtMediumView;
import fr.formation.loueunartiste.domain.entities.ArtMedium;
import fr.formation.loueunartiste.repositories.ArtMediumRepository;

@Service
public class ArtMediumServiceImpl implements ArtMediumService {

    private final ArtMediumRepository artMediums;

    public ArtMediumServiceImpl(ArtMediumRepository artMediums) {
	this.artMediums = artMediums;
    }

    @Override
    public List<ArtMediumView> getAll() {
	List<ArtMedium> artMediumList = artMediums.findAll();
	List<ArtMediumView> artMediumView = new ArrayList<ArtMediumView>();
	System.out.println(artMediumList);

	for (ArtMedium a : artMediumList) {
	    ArtMediumView artMedium = new ArtMediumView();
	    artMedium.setId(a.getId());
	    artMedium.setLabel(a.getLabel());
	    artMediumView.add(artMedium);
	}
	return artMediumView;
    }

}
