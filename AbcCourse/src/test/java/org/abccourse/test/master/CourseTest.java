package org.abccourse.test.master;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.abccourse.model.master.CourseModel;
import org.abccourse.service.master.CourseSvc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseTest {

	@Autowired
	private CourseSvc courseService;
	
	@Test
	public void shouldGetCourseByCode() throws Exception {
		
		String code = "MTK";
		CourseModel courseModel = courseService.getCourseByCode(code);
		assertNotNull(courseModel);
	}
	
	@Test
	public void shouldGetCourseByName() throws Exception {
		
		String name = "Mate";
		List<CourseModel> courseModelList = courseService.getCourseByName(name);
		assertNotNull(courseModelList);
	}
}
