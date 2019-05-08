package org.abccourse.rest.transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.abccourse.model.transaction.CourseRegistrationModel;
import org.abccourse.service.transaction.CourseRegistrationSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("courseRegistration")
public class CourseRegistrationRc {

	@Autowired
	private CourseRegistrationSvc courseRegisrationService;
	
	@GetMapping("/findByStudentName")
	public ResponseEntity<?> findCourseRegistrationByStudentName(@RequestParam String studentName) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<CourseRegistrationModel> courseRegistrationModelList = null;

		String message = "";
		
		try {
			courseRegistrationModelList = courseRegisrationService.findCourseRegistrationByStudentName(studentName);
			map.put("message", message);
			map.put("contents", courseRegistrationModelList);
		}
		catch(Exception ex) {
			message = ex.getMessage();
			
			map.put("message", message);
			map.put("contents", courseRegistrationModelList);
			
			return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Object>(map, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<?> saveCourseRegistration(@RequestParam int studentId,
														@RequestParam int courseId)	{
		Map<String, Object> map = new HashMap<String, Object>();

		short saveResult = 0;
		String message = "";
		
		try {
			saveResult = courseRegisrationService.saveCourseRegistration(studentId, courseId);
			map.put("saveResult", saveResult);
			map.put("message", "");
			
			if (saveResult > 0) {
				return new ResponseEntity<Object>(map, HttpStatus.CREATED);
			}
		}
		catch(Exception ex) {
			map.put("isSuccess", message);
			map.put("message", ex.getMessage());
			
			return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
}
