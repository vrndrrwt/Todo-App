package com.example.TodoList.service;

import com.example.TodoList.model.Task;
import com.example.TodoList.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Task addTask(Task task) {
        return repo.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Task existing = repo.findById(id).orElseThrow();
        existing.setTitle(task.getTitle());
        existing.setCompleted(task.isCompleted());
        return repo.save(existing);
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }
}
