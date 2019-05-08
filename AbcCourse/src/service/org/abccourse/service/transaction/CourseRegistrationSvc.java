package org.abccourse.service.transaction;

import java.util.List;
import org.abccourse.model.transaction.CourseRegistrationModel;

public interface CourseRegistrationSvc {

	List<CourseRegistrationModel> findCourseRegistrationByStudentName(String studentName);
	short saveCourseRegistration(int studentId, int courseId);
}
