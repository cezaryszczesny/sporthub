package pl.studies.sporthub.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.studies.sporthub.service.facility.FacilityDto;
import pl.studies.sporthub.service.facility.FacilityService;

import java.util.List;


@RestController
@RequestMapping("facilities")
@AllArgsConstructor
public class FacilityController extends BaseApiController {

    private FacilityService service;


    @GetMapping("/{id}")
    public FacilityDto getFacilityById(@PathVariable Long id) {
        return service.load(id);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public FacilityDto addFacility(@RequestBody FacilityDto dto) {
        Long idSavedFacility = service.add(dto);
        return service.load(idSavedFacility);
    }


    @DeleteMapping("/{id}")
    public String deleteFacility(@PathVariable Long id) {
        service.delete(id);
        return DELETE_SUCCESSFUL_MSG;
    }


    @GetMapping
    public List<FacilityDto> findFacilities() {
        return service.findAllFacilities();
    }


}
