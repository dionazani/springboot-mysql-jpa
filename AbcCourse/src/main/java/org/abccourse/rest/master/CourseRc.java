package org.abccourse.rest.master;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.abccourse.model.master.CourseModel;
import org.abccourse.service.master.CourseSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseRc {
	
	@Autowired
	private CourseSvc courseService;
	
	@GetMapping("/getCourse")
	public ResponseEntity<?> getCourseByName(@RequestParam String name) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<CourseModel> courseModelList = null;

		String message = "";
		
		try {
			courseModelList = courseService.getCourseByName(name);
			map.put("message", message);
			map.put("contents", courseModelList);
		}
		catch(Exception ex) {
			message = ex.getMessage();
			
			map.put("message", message);
			map.put("contents", courseModelList);
			
			return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Object>(map, HttpStatus.OK);
		
	}


}
