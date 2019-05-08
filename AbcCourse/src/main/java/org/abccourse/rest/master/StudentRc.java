package org.abccourse.rest.master;

import java.util.HashMap;
import java.util.Map;
import org.abccourse.model.master.StudentModel;
import org.abccourse.service.master.StudentSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentRc {

	@Autowired
	private StudentSvc studentService;
	
	@PostMapping(produces="application/json")
	public ResponseEntity<?> saveStudent(@RequestBody StudentModel studentModel) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		short isSave = 0;
		String message = "";
		
		try {
			isSave = studentService.saveStudent(studentModel);
			map.put("save", isSave);
			map.put("message", message);
		}
		catch(Exception ex) {
			message = ex.getMessage();
			
			map.put("save", isSave);
			map.put("message", message);

			return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
}