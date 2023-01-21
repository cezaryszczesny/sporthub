package pl.studies.sporthub.service.facility;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.studies.sporthub.exception.ObjectNotFoundException;
import pl.studies.sporthub.model.Facility;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private static final String FACILITY_NOT_FOUND = "Nie znaleziono placówki treningowej";

    private FacilityRepository repo;


    @Override
    public Long add(FacilityDto dto) {
        Facility facility = new Facility();
        facility.apply(dto);
        Facility savedFacility = repo.save(facility);
        return savedFacility.getId();
    }


    @Override
    public FacilityDto load(Long id) {
        Optional<Facility> possibleFacility = repo.findById(id);
        if (possibleFacility.isPresent()) {
            Facility facility = possibleFacility.get();
            FacilityDto dto = facility.createDto();
            return dto;
        } else {
            throw new ObjectNotFoundException(FACILITY_NOT_FOUND);
        }
    }


    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }


    @Override
    public void update(FacilityDto dto) {
        Optional<Facility> possibleFacility = repo.findById(dto.getId());
        if (possibleFacility.isPresent()) {
            Facility facility = possibleFacility.get();
            facility.apply(dto);
            repo.save(facility);
        } else {
            throw new ObjectNotFoundException(FACILITY_NOT_FOUND);
        }
    }


    @Override
    public List<FacilityDto> findAllFacilities() {
        Iterable<Facility> allFacilities = repo.findAll();
        List<FacilityDto> facilities = new ArrayList<>();
        allFacilities.forEach(facility -> facilities.add(facility.createDto()));
        return facilities;
    }
}
