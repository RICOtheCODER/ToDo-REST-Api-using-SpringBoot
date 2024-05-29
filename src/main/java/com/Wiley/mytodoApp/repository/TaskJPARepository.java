package com.Wiley.mytodoApp.repository;

import com.Wiley.mytodoApp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJPARepository extends JpaRepository<Task,Integer> {


}
