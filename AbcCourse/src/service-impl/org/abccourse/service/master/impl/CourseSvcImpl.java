package org.abccourse.service.master.impl;

import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.abccourse.entity.Course;
import org.abccourse.model.master.CourseModel;
import org.abccourse.repository.master.CourseRpo;
import org.abccourse.service.master.CourseSvc;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseSvcImpl implements CourseSvc {

	@Autowired
	private CourseRpo courseRpo;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public CourseModel getCourseByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseModel> getCourseByName(String name) {
		List<Course> courseList = courseRpo.findCourseByName(name);

		List<CourseModel> courseModelList = null;
		if (!courseList.isEmpty()) {
			
			ModelMapper modelMapper = new ModelMapper();
			Type targetType = new TypeToken<List<CourseModel>>() {}.getType();
			courseModelList = modelMapper.map(courseList, targetType);
		}
		
		return courseModelList;
	
	}

}
