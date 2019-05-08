package org.abccourse.service.master;

import java.util.List;
import org.abccourse.model.master.CourseModel;

public interface CourseSvc {

	CourseModel getCourseByCode(String code);
	List<CourseModel> getCourseByName(String name);
}
