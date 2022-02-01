package com.revature.course_college.daos;

import java.io.File;
import java.io.FileWriter;

import com.revature.course_college.models.FacultyAccount;
import com.revature.course_college.util.LinkedList;

public class FacultyDAO implements CrudDAO<FacultyAccount>{

	@Override
	public FacultyAccount creat(FacultyAccount newFaculty) {
		File facultyFile = new File("C:\\Users\\Christian\\Desktop\\220124-JavaReactAzure\\Christian_Mains_p0\\src\\com\\revature\\course_college\\daos\\resources\\facultyData.txt");
		
		try(FileWriter facultyWriter = new FileWriter(facultyFile)){
			facultyWriter.write(newFaculty.toFileString() + "\n");
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public LinkedList<FacultyAccount> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacultyAccount findByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(FacultyAccount updateObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(FacultyAccount oldObject) {
		// TODO Auto-generated method stub
		return false;
	}

}
