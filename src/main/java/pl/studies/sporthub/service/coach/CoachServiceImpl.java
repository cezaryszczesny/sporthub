package pl.studies.sporthub.service.coach;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.studies.sporthub.exception.ObjectNotFoundException;
import pl.studies.sporthub.model.Coach;
import pl.studies.sporthub.model.CoachSpecialty;
import pl.studies.sporthub.model.Operator;
import pl.studies.sporthub.service.operator.OperatorRepository;

import java.util.Optional;


@Service
@AllArgsConstructor
public class CoachServiceImpl implements CoachService {

    private CoachRepository repo;
    private OperatorRepository operatorRepository;
    private CoachSpecialtyRepository coachSpecialtyRepository;


    @Override
    public Long add(CoachDto dto) {
        Coach coach = new Coach();
        coach.apply(dto);
        assignOperator(coach, dto);
        assignSpecialty(coach, dto);
        Coach savedCoach = repo.save(coach);
        manageOperator(savedCoach);
        return coach.getId();
    }


    private void manageOperator(Coach coach) {
        Operator operator = coach.getOperator();
        operator.setCoach(coach);
        operatorRepository.save(operator);
    }


    private void assignSpecialty(Coach coach, CoachDto dto) {
        Optional<CoachSpecialty> possibleSpecialty = coachSpecialtyRepository.findById(dto.getIdSpecialty());
        if (possibleSpecialty.isPresent()) {
            coach.setSpecialty(possibleSpecialty.get());
        } else {
            throw new ObjectNotFoundException("Nie znaleziono specjalizacji trenera");
        }
    }


    private void assignOperator(Coach coach, CoachDto dto) {
        Optional<Operator> possibleOperator = operatorRepository.findById(dto.getIdOperator());
        if (possibleOperator.isPresent()) {
            coach.setOperator(possibleOperator.get());
        } else {
            throw new ObjectNotFoundException("Nie znaleziono operatora");
        }
    }


    @Override
    public CoachDto load(Long id) {
        Optional<Coach> possibleCoach = repo.findById(id);
        if (possibleCoach.isPresent()) {
            Coach coach = possibleCoach.get();
            return coach.createDto();
        } else {
            throw new ObjectNotFoundException("Nie znaleziono trenera");
        }
    }


    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }


    @Override
    public void update(CoachDto dto) {
        Optional<Coach> possibleCoach = repo.findById(dto.getId());
        if (possibleCoach.isPresent()) {
            Coach coach = possibleCoach.get();
            coach.apply(dto);
            assignSpecialty(coach, dto);
        }

    }
}
