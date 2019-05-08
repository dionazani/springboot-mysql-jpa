package org.abccourse.repository.master;

import org.abccourse.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StudentRpo {

	short insertStudent(Student entity);
}
