package fr.formation.loueunartiste.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.formation.loueunartiste.domain.dtos.ArtistAvailableUpdate;
import fr.formation.loueunartiste.domain.dtos.ArtistView;
import fr.formation.loueunartiste.domain.dtos.MediumAndFormatCreate;
import fr.formation.loueunartiste.domain.entities.ArtFormat;
import fr.formation.loueunartiste.domain.entities.ArtMedium;
import fr.formation.loueunartiste.domain.entities.Artist;
import fr.formation.loueunartiste.repositories.AccountRepository;
import fr.formation.loueunartiste.repositories.ArtFormatRepository;
import fr.formation.loueunartiste.repositories.ArtMediumRepository;
import fr.formation.loueunartiste.repositories.ArtistRepository;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artists;
    private final AccountRepository accounts;
    private final ArtMediumRepository artMediums;
    private final ArtFormatRepository artFormats;

    public ArtistServiceImpl(ArtistRepository artists,
	    AccountRepository accounts, ArtMediumRepository artMediums,
	    ArtFormatRepository artFormats) {
	this.artists = artists;
	this.accounts = accounts;
	this.artMediums = artMediums;
	this.artFormats = artFormats;
    }

    @Override
    public ArtistView getOne(Long accountId) {
	Artist artistEntity = artistByAccount(accountId);
	ArtistView artistDto = new ArtistView();
	artistDto.setArtistName(artistEntity.getArtistName());
	artistDto.setPortfolioUrl(artistEntity.getPortfolioUrl());
	artistDto.setAvailable(artistEntity.isAvailable());

	artistDto.setArtMedium(mediumLabelList(artistEntity.getArtMedium()));
	artistDto.setArtFormat(formatLabelList(artistEntity.getArtFormat()));
	return artistDto;
    }

    @Override
    public void createMediumAndFormat(Long accountId,
	    MediumAndFormatCreate inputs) {
	Artist artistEntity = artistByAccount(accountId);
	List<Long> mediumInputs = inputs.getArtMediumId();
	List<Long> formatInputs = inputs.getArtFormatId();
	artistEntity.setArtMedium(addMedium(mediumInputs));
	artistEntity.setArtFormat(addFormat(formatInputs));
	artists.save(artistEntity);
    }

    @Override
    public void updateMediumAndFormat(Long accountId,
	    MediumAndFormatCreate inputs) {
	Artist artistEntity = artistByAccount(accountId);

//	List<ArtMedium> mediumList = artistEntity.getArtMedium();
//	for (ArtMedium m : mediumList) {
//	    mediumList.remove(m);
//	}
//	artistEntity.getArtMedium().clear();
//	artistEntity.getArtFormat().clear();
    }

    @Override
    public void updateAvailable(Long accountId, ArtistAvailableUpdate input) {
	Artist artistEntity = artistByAccount(accountId);
	if (artistEntity.getArtMedium().size() >= 1
		&& artistEntity.getArtFormat().size() >= 1) {
	    artistEntity.setAvailable(input.isAvailable());
	    artists.save(artistEntity);
	}
    }

    private Artist artistByAccount(Long accountId) {
	return artists.findByAccount(accounts.findById(accountId));
    }

    private List<ArtMedium> addMedium(List<Long> mediumInputs) {
	List<ArtMedium> artMediumList = new ArrayList<ArtMedium>();
	for (Long mediumId : mediumInputs) {
	    ArtMedium medium = artMediums.findById(mediumId).get();
	    artMediumList.add(medium);
	}
	return artMediumList;
    }

    private List<ArtFormat> addFormat(List<Long> formatInputs) {
	List<ArtFormat> artFormatList = new ArrayList<ArtFormat>();
	for (Long formatId : formatInputs) {
	    ArtFormat format = artFormats.findById(formatId).get();
	    artFormatList.add(format);
	}
	return artFormatList;
    }

    private List<String> mediumLabelList(List<ArtMedium> entityList) {
	List<String> dtoList = new ArrayList<String>();
	for (ArtMedium medium : entityList) {
	    String label = medium.getLabel();
	    dtoList.add(label);
	}
	return dtoList;
    }

    private List<String> formatLabelList(List<ArtFormat> entityList) {
	List<String> dtoList = new ArrayList<String>();
	for (ArtFormat format : entityList) {
	    String label = format.getLabel();
	    dtoList.add(label);
	}
	return dtoList;
    }

}
