package org.jana.todo.controller;

import org.jana.todo.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.jana.todo.service.TaskService;

import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id){
        taskService.deleteTasks(id);

        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")

    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }

}
