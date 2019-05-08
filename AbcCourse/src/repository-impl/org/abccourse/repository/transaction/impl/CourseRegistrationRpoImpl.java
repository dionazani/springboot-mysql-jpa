package org.abccourse.repository.transaction.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.abccourse.entity.transaction.CourseRegistration;
import org.abccourse.repository.transaction.CourseRegistrationRpo;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRegistrationRpoImpl implements CourseRegistrationRpo {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<CourseRegistration> findCourseRegistrationByStudentName(String studentName) {

		List<CourseRegistration> list = new ArrayList<CourseRegistration>();
		String sql = "select student.id as student_id, " + 
				"course.id as course_id, " + 
				"student.name as student_name, " + 
				"course.name as course_name " + 
				"from student_course inner join student on student_course.student_id = student.id inner join " + 
				"course on student_course.course_id = course.id where student.name like concat ('%', :studentName, '%')";
		
		List<Object[]> courses =  em.createNativeQuery(sql)
				.setParameter("studentName", studentName)
				.getResultList();

		courses.forEach(course -> {
			CourseRegistration entity = new CourseRegistration();
			entity.setStudentId((int) course[0]);
			entity.setCourseId((int) course[1]);
			entity.setStudentName(String.valueOf(course[2]));
			entity.setCourseName(String.valueOf(course[3]));
			
			list.add(entity);
		});
		
		return list;
	}

	@Override
	public short insertStudentCourse(int studentId, int courseId) {
		
		short isInsert = 0;
		
		String sql = "insert into student_course (student_id, course_id) " +
						"values (:studentId, :courseId)";
		
		em.createNativeQuery(sql)
                .setParameter("studentId", studentId)
                .setParameter("courseId", courseId).executeUpdate();
		isInsert = 1;
		
		return isInsert;

	}

}
