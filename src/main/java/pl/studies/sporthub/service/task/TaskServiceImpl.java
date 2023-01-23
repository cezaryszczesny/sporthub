package pl.studies.sporthub.service.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.studies.sporthub.exception.ObjectNotFoundException;
import pl.studies.sporthub.model.Facility;
import pl.studies.sporthub.model.Operator;
import pl.studies.sporthub.model.Task;
import pl.studies.sporthub.service.facility.FacilityRepository;
import pl.studies.sporthub.service.operator.OperatorRepository;

import java.util.Optional;


@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository repo;
    private OperatorRepository operatorRepository;
    private FacilityRepository facilityRepository;


    @Override
    public Long add(TaskDto dto) {
        Task task = new Task();
        task.apply(dto);
        assignOperators(dto, task);
        assignFacility(dto, task);
        Task save = repo.save(task);
        return save.getId();
    }


    private void assignFacility(TaskDto dto, Task task) {
        Optional<Facility> possibleFacility = facilityRepository.findById(dto.getIdFacility());
        if (possibleFacility.isPresent()) {
            task.setFacility(possibleFacility.get());
        }
    }


    private void assignOperators(TaskDto dto, Task task) {
        assignPlayerOperator(dto.getIdPlayer(), task);
        assignCoachOperator(dto.getIdCoach(), task);
        assignCreatorOperator(dto.getIdOperatorCreator(), task);
    }


    private void assignCreatorOperator(Long idOperatorCreator, Task task) {
        Optional<Operator> possibleOperatorCreator = operatorRepository.findById(idOperatorCreator);
        if (possibleOperatorCreator.isPresent()) {
            task.setOperatorCreator(possibleOperatorCreator.get());
        } else {
            throw new ObjectNotFoundException("Nie znaleziono operatora");
        }
    }


    private void assignCoachOperator(Long idCoach, Task task) {
        Operator coachOperator = operatorRepository.findByCoachId(idCoach);
        if (coachOperator != null) {
            task.setOperatorCoach(coachOperator);
        } else {
            throw new ObjectNotFoundException("Nie znaleziono trenera");
        }
    }


    private void assignPlayerOperator(Long idPlayer, Task task) {
        Operator playerOperator = operatorRepository.findByPlayerId(idPlayer);
        if (playerOperator != null) {
            task.setOperatorPlayer(playerOperator);
        } else {
            throw new ObjectNotFoundException("Nie znaleziono zawodnika");
        }
    }


    @Override
    public TaskDto load(Long id) {
        Optional<Task> possibleTask = repo.findById(id);
        if (possibleTask.isPresent()) {
            Task task = possibleTask.get();
            return task.createDto();
        } else {
            throw new ObjectNotFoundException("Nie znaleziono zadania");
        }
    }


    @Override
    public void delete(Long id) {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Błąd podczas usuwania zadania");
        }
    }


    @Override
    public void update(TaskDto dto) {

    }
}
