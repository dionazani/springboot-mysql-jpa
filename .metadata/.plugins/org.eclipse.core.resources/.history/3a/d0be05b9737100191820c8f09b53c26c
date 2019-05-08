package org.abccourse.repository;

import java.util.List;

import org.abccourse.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("courseRepository")
public interface CourseRpo extends JpaRepository<Course, Integer>{

	@Query(value = "select * from course crs where crs.code = :code", nativeQuery = true)
	Course findByCode(@Param("code") String code);
	
	@Query(value = "select * from course crs where crs.name like concat('%', :name, '%') order by crs.id desc", nativeQuery = true)
	List<Course> findCourseByName(@Param("name") String name);
	
}
