package Test;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.scau.myteam.pojo.ProjectPhase;
import cn.scau.myteam.pojo.ProjectTable;
import cn.scau.myteam.pojo.Task;
import cn.scau.myteam.pojo.User;
import cn.scau.myteam.service.ProjectPhaseService;
import cn.scau.myteam.service.ProjectTableService;
import cn.scau.myteam.service.TaskService;
import cn.scau.myteam.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:applicationContext.xml")
public class MainTest {

	@Autowired
	private ProjectTableService projectTableService;
	@Autowired
	private ProjectPhaseService projectPhaseService;
	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;
//	@Test
//	public void projectTest(){
//		ProjectTable p=new ProjectTable();
//		p.setId(2);
//		p.setTitle("hh");
//		projectTableService.save(p);
//		ArrayList<ProjectTable> list=projectTableService.findAll();
//		for(ProjectTable pro:list){
//			System.out.println(pro.getTitle());
//		}
//		projectTableService.delete(2);
//	}
	
//	@Test
//	public void projectPharseTest(){
//		ProjectPhase p=new ProjectPhase();
//		p.setId(1);
//		p.setName("艾迪");
//		ArrayList<ProjectPhase> list=projectPhaseService.findAll();
//		for(ProjectPhase pp:list)
//	    System.out.println(pp.getName());
//		projectPhaseService.delete(1);
//	}
	
//	@Test
//	public  void UserTest(){
//		User u=new User();
//		u.setId(1);
//		u.setName("kobe");
//		u.setPhone("10086");
//		userService.update(u);
//		System.out.println(userService.findById(1).getName());
//		ArrayList<User> list=userService.findAll();
//		for(User u:list){
//			System.out.println(u.getName());
//		}
//		userService.delete(3);
//	}
	
//	@Test
	public void TaskTest(){
		Task t=taskService.findById(1);
		System.out.println(t.getLabel());
		
		
		
	}
}
