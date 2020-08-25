package com.bootcamp.SpringExercise.Util;

import com.bootcamp.SpringExercise.Entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentDAO extends PagingAndSortingRepository<Student, Integer> {
}
