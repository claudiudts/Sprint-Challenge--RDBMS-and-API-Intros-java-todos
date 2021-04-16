package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import javax.persistence.EntityNotFoundException;

@Service(value = "todoService")
public class TodoServiceImp implements TodosService
{
    @Autowired
    private TodosRepository todosRepository;

    @Transactional
    @Override
    public void markComplete(long todoid)
    {
        Todos updateTodo = todosRepository.findById(todoid)
                .orElseThrow(() -> new EntityNotFoundException("Todo id" + todoid + "is not found."));
        updateTodo.setCompleted(true);

        todosRepository.save(updateTodo);
    }
}
