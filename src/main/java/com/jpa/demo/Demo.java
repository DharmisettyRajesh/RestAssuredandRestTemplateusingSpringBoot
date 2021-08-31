package com.jpa.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo { 
	@Autowired JdbcTemplate obj;
	@GetMapping("/")
	public String getResult()
	{
		return "hello";
	}
    @GetMapping("/getall")
    public List<Person> getall() 
    {
    	String sql="select * from persons";
    	List<Person> p=obj.query(sql,(rs,rownum)->new Person(
    				rs.getInt(1),
    				rs.getString(2)
    				));
    	return p;
    }
    @PostMapping("/addperson")
    public  String addPerson(@RequestBody Person p)
    {
    	String s="insert into persons values(?,?)";
    	int i=obj.update(s,new Object[] {p.getId(),p.getName()});
    	if(i>0)
    	{
    		return "data inserted successfully";
    	}
    	else 
    	{
    		return "data can not inserted";
    	}
    }
    @PutMapping("/updateperson")
    public String updatPerson(@RequestBody Person p)
    {
    	String s="update persons set name=? where id=?";
    	int i=obj.update(s,new Object[] {p.getName(),p.getId()});
    	if(i>0)
    	{
    		return "data updated successfully...............";
    	}
    	else
    	{
    		return "data not updated sorry ...............";
    	}
    }
    @DeleteMapping("deletebyid")
    public String deleteById(@RequestBody Person p)
    {
    	String s="delete from persons where id =?";
    	int i=obj.update(s,new Object[] {p.getId()});
    	if(i>0)
    	{
    		return "Record with id="+p.getId()+"deleted successfully ................";
    	}
    	else
    	{
    		return "OOPS!!!!     Record with id="+p.getId()+" deosn't deleted ............";
    	}
    }
}
