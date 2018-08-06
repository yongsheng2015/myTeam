package Test;

import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.scau.myteam.pojo.FileTable;
import cn.scau.myteam.pojo.Message;
import cn.scau.myteam.pojo.ProjectPhase;
import cn.scau.myteam.pojo.ProjectTable;
import cn.scau.myteam.pojo.ProjectUsersKey;
import cn.scau.myteam.pojo.Share;
import cn.scau.myteam.pojo.SubTaskKey;
import cn.scau.myteam.pojo.Task;
import cn.scau.myteam.pojo.TaskUsersKey;
import cn.scau.myteam.pojo.User;
import cn.scau.myteam.service.FileTableService;
import cn.scau.myteam.service.MessageService;
import cn.scau.myteam.service.ProjectPhaseService;
import cn.scau.myteam.service.ProjectTableService;
import cn.scau.myteam.service.ProjectUserService;
import cn.scau.myteam.service.ShareService;
import cn.scau.myteam.service.SubTaskService;
import cn.scau.myteam.service.TaskService;
import cn.scau.myteam.service.TaskUsersService;
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
	@Autowired
	private FileTableService fileTableService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private ProjectUserService projectUserService;
	@Autowired
	private ShareService shareService;
	@Autowired
	private SubTaskService subTaskService;
	@Autowired
	private TaskUsersService taskUsersService;
//	@Test
	public void projectTest(){
		ProjectTable p=new ProjectTable();
		p.setId(3);
		p.setTitle("项目111");
		Date date=new Date();
		p.setEndTime(date);
		projectTableService.update(p);
//		ProjectTable p2=new ProjectTable();
//		p.setCreatorId(3);
//		p.setTitle("项目22");
//		projectTableService.save(p);
//		ProjectTable p3=projectTableService.findById(3);
//		System.out.println(p3.getTitle());
//		
//		ArrayList<ProjectTable> list=projectTableService.findByCreatorId(3);
//		for(ProjectTable pro:list){
//			System.out.println(pro.getTitle());
//		}
		
		
		
	}
	
//	@Test
	public void projectPharseTest(){
		ProjectPhase p=new ProjectPhase();
//		p.setPtid(3);
//		p.setName("需求分析");
//		projectPhaseService.save(p);
//		ProjectPhase p2=new ProjectPhase();
//		p2.setPtid(4);
//		p2.setName("设计分析");
//		projectPhaseService.save(p2);
		p.setId(3);
		p.setName("需求");
		projectPhaseService.update(p);
		ProjectPhase p3=projectPhaseService.findById(3);
		System.out.println(p3.getName());
		ArrayList<ProjectPhase> list=projectPhaseService.findAll();
		for(ProjectPhase pp:list)
	    System.out.println(pp.getName());
		projectPhaseService.delete(4);
	}
	
//	@Test
	public  void UserTest(){
		User u=new User();
		u.setId(1);
		u.setName("kobe");
		u.setPassword("10088");
		userService.update(u);
		System.out.println(userService.findById(1).getName());
		ArrayList<User> list=userService.findAll();
		for(User u1:list){
			System.out.println(u1.getName());
		}
//		userService.delete(3);
		userService.delete(1);
	}
	
//	@Test
	public void TaskTest(){
		Task task=taskService.findById(3);
		System.out.println(task.getLabel());
//		task.setPpid(2);
//		task.setUid(1);
//		task.setLabel("任务二");
		ArrayList<Task> list=taskService.findAll();
		for(Task t:list){
			System.out.println(t.getLabel());
		}
		
		taskService.delete(3);
		
	}
//	@Test
	public void FileTest(){
		FileTable f=new FileTable();
//		f.setPtid(1);
		f.setId(4);
		fileTableService.delete(4);
//		f.setType("test2");
//		f.setTid(3);
//		f.setName("file4");
//		fileTableService.save(f);
//		ArrayList<FileTable> list=fileTableService.findAll();
//		for(FileTable ff:list)
//		System.out.println(ff.getName());
		
	}
//	@Test
	public void MessageTest(){
		Message m=messageService.findById(1);
		System.out.println(m.getCreateTime());
		ArrayList<Message> list=messageService.findAll();
		for(Message mes:list){
			System.out.println(mes.getCreateTime());
		}
		messageService.delete(2);
	}
//	@Test
	public void ProjectUserTest(){
		ProjectUsersKey p=new ProjectUsersKey();
		p.setPtid(4);
		p.setUid(3);
//		boolean flag=projectUserService.save(p);
//		System.out.println(flag);
//		ArrayList<ProjectUsersKey> list1=projectUserService.findByProjectId(4);
//		for(ProjectUsersKey pro1:list1)
//			System.out.println(pro1.getUid());
		ArrayList<ProjectTable> list=projectUserService.findByUserId(3);
		for(ProjectTable pro1:list)
			System.out.println(pro1.getTitle());
//		projectUserService.delete(p);
	}
//	@Test
	public void ShareTest(){
		Share s=new Share();
		s.setId(4);
		s.setContent("share3");
		shareService.update(s);
		ArrayList<Share> list=shareService.findByShareId(2);
		for(Share s1:list)
		System.out.println(s1.getContent());
		System.out.println("id"+shareService.findById(2).getContent());
		ArrayList<Share> list2=shareService.findAll();
		for(Share s1:list2)
		System.out.println(s1.getContent());
	}
//	@Test
	public void SubTaskTest(){
//		SubTaskKey s=new SubTaskKey();
//		s.setSubTaskId(6);
//		s.setTid(5);
//		subTaskService.delete(s);
		ArrayList<Task> list=subTaskService.findByTaskId(7);
		for(Task s:list)
			System.out.println(s.getLabel());
	}
	
	@Test
	public void TaskUsersTest(){
		TaskUsersKey t=new TaskUsersKey();
		t.setTid(5);
		t.setUid(2);
		ArrayList<Task> list = taskUsersService.findByUserId(2);
		for(Task tk:list){
			System.out.println(tk.getLabel());
		}
//		taskUsersService.delete(t);
	}
}
