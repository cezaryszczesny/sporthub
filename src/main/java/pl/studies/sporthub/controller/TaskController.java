package pl.studies.sporthub.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.studies.sporthub.service.task.TaskDto;
import pl.studies.sporthub.service.task.TaskService;


@RestController
@RequestMapping("task")
@AllArgsConstructor
public class TaskController extends BaseApiController {


    private TaskService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskDto addTask(@RequestBody TaskDto dto) {
        loginBasic64();
        Long idSavedTask = service.add(dto);
        return service.load(idSavedTask);
    }


    @GetMapping(path = "/{id}")
    public TaskDto getTask(@PathVariable Long id) {
        return service.load(id);
    }


    @DeleteMapping(path = "/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.delete(id);
        return DELETE_SUCCESSFUL_MSG;
    }
}
