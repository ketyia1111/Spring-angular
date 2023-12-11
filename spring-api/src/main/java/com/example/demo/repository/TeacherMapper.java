package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.Teacher;

@Mapper
public interface TeacherMapper {

	@Select("select * from teacher")
	List<Teacher> selectAll();
	
	@Select({
		"select * from teacher",
		"where id = #{id}"
	})
	Teacher selectByPrimaryKey(Long id);
	
	@Insert({
		"insert into teacher(user_name,email)",
		"values(#{userName},#{email})"
	})
	int insert(Teacher record);
	
	@Update({
		"update teacher",
		"set user_name = #{userName},email = #{email}",
		"where id = #{id}"
	})
	int updateByPrimaryKey(Teacher record);
	
	@Delete({
		"delete from teacher",
		"where id = #{id}"
	})
	int deleteByPrimaryKey(Long id);
}
	
