package org.abccourse.service.master.impl;

import java.lang.reflect.Type;
import org.abccourse.entity.Student;
import org.abccourse.model.master.StudentModel;
import org.abccourse.repository.master.StudentRpo;
import org.abccourse.service.master.StudentSvc;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentSvcImpl implements StudentSvc {

	@Autowired
	private StudentRpo studentRpo;
	
	@Override
	public short saveStudent(StudentModel studentModel) {
		
		short isSave = 0;
		
		ModelMapper modelMapper = new ModelMapper();
		Type targetType = new TypeToken<Student>() {}.getType();
		Student student = modelMapper.map(studentModel, targetType);
		isSave = studentRpo.insertStudent(student);
		
		return isSave;
	}

}
