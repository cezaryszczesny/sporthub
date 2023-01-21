package pl.studies.sporthub.service.facility;

import pl.studies.sporthub.service.BaseApplicationService;

import java.util.List;


public interface FacilityService extends BaseApplicationService<FacilityDto> {

    List<FacilityDto> findAllFacilities();

}
