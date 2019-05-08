package org.abccourse.repository.transaction;

import java.util.List;
import org.abccourse.entity.transaction.CourseRegistration;

public interface CourseRegistrationRpo {

	List<CourseRegistration> findCourseRegistrationByStudentName(String studentName);
	short insertStudentCourse(int studentId, int courseId);
}
