package cn.edu.lingnan.test;
import java.util.*;

import cn.edu.lingnan.dao.IlikeDAO;
import cn.edu.lingnan.dao.KindDAO;
import cn.edu.lingnan.dao.LmusicDAO;
import cn.edu.lingnan.dao.UserDAO;
import cn.edu.lingnan.dto.Kind;
import cn.edu.lingnan.dto.Lmusic;
import cn.edu.lingnan.dto.User;
import cn.edu.lingnan.dto.ilike;
import cn.edu.lingnan.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Test {	
	
	
	Scanner reader=new Scanner(System.in);
	public static void main(String[] args){
		Scanner reader=new Scanner(System.in);		
		System.out.println("欢迎来到音乐后台管理系统，请选择你要操作的表：");
		System.out.println("1：用户表");
		System.out.println("2：Kind表");
		System.out.println("3：Ilike表");
		System.out.println("4：Lmusic表");	
		int x;int y;
		while(true)
		{		
			x=reader.nextInt();///选择需要操作的表
			if(x==1)y=1;
			else if(x==2)y=2;
			else if(x==3)y=3;
			else if(x==4)y=4;
			else y=5;
			switch(y)
			{
			case 1://///////////////////////////////////////////////////////////////用户表
			{
				
				System.out.println("欢迎来到用户表后台管理，请选择你要操作的方法");
				System.out.println("1.查");
				System.out.println("2.增");
				System.out.println("3.删");
				System.out.println("4.改");
				int u0;
				u0=reader.nextInt();
				     switch(u0) {
				   case 1://////查询用户表
					 System.out.println("请选择要查询的方法：");
				     System.out.println("1.查找所有用户");
				     System.out.println("2.按用户名和密码查找该用户是否存在");
				     int methodOfFindUser=reader.nextInt();
				     switch(methodOfFindUser) {
				     case 1:Test fau=new Test();
				            fau.findAllUser();
				            break;    
				     case 2:Test akak=new Test();
				            akak.findbyUseridAndPassword();
				            break;	     
				     }	     
				     break;
				     
				  case 2:///////增加用户表
				    System.out.println("请输入要增加的数据：");
				    Test insu=new Test();
				    insu.insertus();	     
				     break;
				  case 3:///////删除用户表					 
					 Test onepu=new Test();
					 onepu.onepieceofuser();
					 break;
				  case 4:///////修改用户表
					 Test changeus=new Test();
					 changeus.changeuser();
					 break;			     
				     }
			
			
			break;
			}//用户表结束!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			
			
			
			case 2:///////////////////////////////////kind表
//				System.out.println("Kind表");
{
				
				System.out.println("欢迎来到kind表后台管理，请选择你要操作的方法");
				System.out.println("1.查");
				System.out.println("2.增");
				System.out.println("3.删");
				System.out.println("4.改");
				int u1;
				u1=reader.nextInt();
				     switch(u1) {
				   case 1://////查询kind表
					 System.out.println("请选择要查询的方法：");
				     System.out.println("1.查找所有类别");
				     System.out.println("2.按类别id和类别名查找该用户是否存在");
				     int methodOfFindKind=reader.nextInt();
				     switch(methodOfFindKind) {
				     case 1:Test fak=new Test();
				            fak.findAllKinds();
				            break;    
				     case 2:Test akak=new Test();
				            akak.findbyKindidAndKname();
				            break;	     
				     }	     
				     break;
				     
				  case 2:///////增加kind表
				    System.out.println("请输入要增加的数据：");
				    Test insk=new Test();
				    insk.insertkind();	     
				     break;
				  case 3:///////删除kind表					 
					 Test onepk=new Test();
					 onepk.onepieceofkind();
					 break;
				  case 4:///////修改kind表
					 Test changekin=new Test();
					 changekin.changekind();
					 break;			     
				     }
			
			
			break;
			}//kind表结束!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			
				
				
				
				
				

			case 3:System.out.println("Ilike表");//////////////////////////////////////////////////////ilike表
			
			{
				
				System.out.println("欢迎来到ilike表后台管理，请选择你要操作的方法");
				System.out.println("1.查");
				System.out.println("2.增");
				System.out.println("3.删");
				System.out.println("4.改");
				int u2;
				u2=reader.nextInt();
				     switch(u2) {
				   case 1://////查询ilike表
					 System.out.println("请选择要查询的方法：");
				     System.out.println("1.查找所有用户的记录");
				     System.out.println("2.按用户id和类别id查看该用户是否有收藏该歌单");
				     int methodOfFindilike=reader.nextInt();
				     switch(methodOfFindilike) {
				     case 1:Test fai=new Test();
				            fai.findAllIlike();
				            break;    
				     case 2:Test aiai=new Test();
				            aiai.findUseridAndKide();
				            break;	     
				     }	     
				     break;
				     
				  case 2:///////增加ilike表
				    System.out.println("请输入要增加的数据：");
				    Test insi=new Test();
				    insi.insertilike();	     
				     break;
				  case 3:///////删除ilke表					 
					 Test onepi=new Test();
					 onepi.onepieceofilikek();
					 break;
				  case 4:///////修改ilike表
					 Test changeilike=new Test();
					 changeilike.changeilike();
					 break;			     
				     }
			
			
			break;
			}//ilike表结束!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			
			
			
			
			
			
			
			
			
			
			
			
	
			case 4:System.out.println("Lmusic表");
{
				
				System.out.println("欢迎来到Lmusic表后台管理，请选择你要操作的方法");
				System.out.println("1.查");
				System.out.println("2.增");
				System.out.println("3.删");
				System.out.println("4.改");
				int u3;
				u3=reader.nextInt();
				     switch(u3) {
				   case 1://////查询Lmusic表
					 System.out.println("请选择要查询的方法：");
				     System.out.println("1.查找所有歌曲名");
				     System.out.println("2.按歌名和用户id查找该用户是否收藏该歌曲");
				     int methodOfFindLmusic=reader.nextInt();
				     switch(methodOfFindLmusic) {
				     case 1:Test fal=new Test();
				            fal.findAllLmusics();
				            break;    
				     case 2:Test alal=new Test();
				            alal.findLmusicByKidAndUidd();
				            break;	     
				     }	     
				     break;
				     
				  case 2:///////增加Lmusic表
				    System.out.println("请输入要增加的数据：");
				    Test insl=new Test();
				    insl.insertlmusic();	     
				     break;
				  case 3:///////删除Lmusic表					 
					 Test onepl=new Test();
					 onepl.onepieceoflmusic();
					 break;
				  case 4:///////修改Lmusic表
					 Test changelm=new Test();
					 changelm.changelmusic();
					 break;			     
				     }
			
			
			break;
			}//Lmusic表结束!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			case 5:System.out.println("输入有误，请重新输入");break;
			}
		}

		
		
		
	}
		
		
		
		
		//增	******************************************************************************************************************************
		//(1)PreparedStatement添加用户行.一行数据
		public void insertus() {
		UserDAO udao =new UserDAO();
		String _uid1;
		String _uname1;
		String _upassword1;
		int _superuser1;
		_uid1=reader.next();_uname1=reader.next();_upassword1=reader.next();_superuser1=reader.nextInt();
		udao.PrepInsertUser(_uid1, _uname1, _upassword1, _superuser1);
		System.out.println("插入成功");
		}
		//////////查查查******************************************************************************************************************
		//(1)查找所有用户
	public void findAllUser() {
		UserDAO udao =new UserDAO();
		Vector<User> v=new Vector<User>();
		v=udao.findAllUser();
		for(User u:v)
			System.out.println(u.getUname());
	}
		//(2)按用户名和密码查找该用户是否存在
	
		public void findbyUseridAndPassword() {
		System.out.println("按用户名和密码查找该用户是否存在?");
		UserDAO udao1 =new UserDAO();
		String find1;String find2;
		find1=reader.next();find2=reader.next();
		int temp=0;
        temp=udao1.findUserByNameAndPassWord(find1, find2);
        if(temp==1)
        	System.out.println("用户存在");
        else
        	System.out.println("用户不存在");
		
		}	
		////////////删删删****************************************************************************************************************
		//删除一条用户记录
		public void onepieceofuser() {
		System.out.println("请输入要删除的用户名：");
		UserDAO udao =new UserDAO();
		String del;
		del=reader.next();
		udao.deleteUser(del);
		System.out.println("删除成功");
		}  
		////////////改***************************************************************************************************************************
		public void changeuser() {
		String uuid;
		System.out.println("请输入要修改的用户的用户名");
		uuid=reader.next();
        int uu;
        UserDAO upudao =new UserDAO();
        System.out.println("请选择要修改的属性");
        System.out.println("1.用户账号");
        System.out.println("2.用户名");
        System.out.println("3.密码");
        System.out.println("4.用户权限级别");
        System.out.println("5.自定义修改属性");
        
        uu=reader.nextInt();
        switch(uu) {
        
        case 1:System.out.println("请输入要更改的属性值");String upu1=reader.next();
                      upudao.PrepUpdateUserid(uuid, upu1);
                      System.out.println("修改成功");
                      break;
        	
        case 2:System.out.println("请输入要更改的属性值");String upu2=reader.next();
        upudao.PrepUpdateUsername(uuid, upu2);System.out.println("修改成功");break;
        	
        case 3:System.out.println("请输入要更改的属性值");String upu3=reader.next();
        upudao.PrepUpdateUserPassword(uuid, upu3);
        System.out.println("修改成功");
        break;
        	
        case 4:System.out.println("请输入要更改的属性值");int upu4=reader.nextInt();
        upudao.PrepUpdateUserSuperuser(uuid, upu4);
        System.out.println("修改成功");
        break;
        
        case 5:System.out.println("请输入所有属性值以修改自定义数据");
        String upu5=reader.next();
        String upu6=reader.next();
        String upu7=reader.next();
        int upu8=reader.nextInt();
        upudao.PrepUpdate(uuid, upu5, upu6, upu7, upu8);
        System.out.println("修改成功");
        break;
        
        }
		
		}
		
		

		
		
		//////////////////////////***************************************************************************kind表
		

		
		
		
		
		
		
		//增	******************************************************************************************************************************
		//(1)PreparedStatement添加用户行.一行数据
		public void insertkind() {
		KindDAO kdao =new KindDAO();
		String _kid1;
		String _kname1;
		_kid1=reader.next();_kname1=reader.next();
		kdao.PrepInsertKind(_kid1, _kname1);
		System.out.println("插入成功");
		}
		//////////查查查******************************************************************************************************************
		//(1)查找所有用户
	public void findAllKinds() {
		KindDAO kdao =new KindDAO();
		Vector<Kind> v=new Vector<Kind>();
		v=kdao.findAllKind();
		for(Kind u:v)
			System.out.println(u.getKname());
	}
		//(2)按用户名和密码查找该用户是否存在
	
		public void findbyKindidAndKname() {
		System.out.println("按类别id和类别名查找该类别是否存在?");
		KindDAO kdao1 =new KindDAO();
		String find1;String find2;
		find1=reader.next();find2=reader.next();
		boolean temp=false;
        temp=kdao1.findKindByKidAndKname(find1, find2);
        if(temp)
        	System.out.println("类别存在");
        else
        	System.out.println("类别不存在");
		
		}	
		////////////删删删****************************************************************************************************************
		//删除一条用户记录
		public void onepieceofkind() {
		System.out.println("请输入要删除的类别名：");
		KindDAO kdao =new KindDAO();
		String del;
		del=reader.next();
		kdao.deleteKind(del);
		System.out.println("删除成功");
		}  
		////////////改***************************************************************************************************************************
		public void changekind() {
		String kkid;
		System.out.println("请输入要修改的类别的id");
		kkid=reader.next();
        int kk;
        KindDAO upudao =new KindDAO();
        System.out.println("请选择要修改的属性");
        System.out.println("1.类别id");
        System.out.println("2.类别名");
        System.out.println("3.自定义修改属性");
        kk=reader.nextInt();
        switch(kk) {
        
        case 1:System.out.println("请输入要更改的属性值");String kpu1=reader.next();
                      upudao.PrepUpdateKindid(kkid, kpu1);
                      System.out.println("修改成功");
                      break;
        	
        case 2:System.out.println("请输入要更改的属性值");String kpu2=reader.next();
        upudao.PrepUpdateKindname(kkid, kpu2);System.out.println("修改成功");break;
        	
        
        case 3:System.out.println("请输入所有属性值以修改自定义数据");
        String kpu3=reader.next();
        String kpu4=reader.next();
        upudao.PrepUpdate(kkid, kpu3, kpu4);
        System.out.println("修改成功");
        break;
        
        }
		
		}
		
		
		
		
		
		
		//////////////////////////***************************************************************************ilike表
		

		//增	******************************************************************************************************************************
		//(1)PreparedStatement添加用户行.一行数据
		public void insertilike() {
		IlikeDAO idao =new IlikeDAO();
		String _uid;
		String _kid;
		int _playtimes;
		_uid=reader.next();_kid=reader.next();_playtimes=reader.nextInt();
		idao.PrepInsertIlike(_uid, _kid, _playtimes);
		System.out.println("插入成功");
		}
		//////////查查查******************************************************************************************************************
		//(1)查找所有ilike
	public void findAllIlike() {
		IlikeDAO idao =new IlikeDAO();
		Vector<ilike> v=new Vector<ilike>();
		v=idao.findAllIlike();
		for(ilike i:v)
			System.out.println(i.getUid()+"   "+i.getKid()+"   "+i.getPlaytimes());
		
	}
		//(2)按用户id和类别id查看该用户是否有收藏该歌单
	
		public void findUseridAndKide() {
		System.out.println("按用户id和类别id查看该用户是否有收藏该歌单");
		IlikeDAO idao1 =new IlikeDAO();
		String find1;String find2;
		find1=reader.next();find2=reader.next();
		boolean temp=false;
        temp=idao1.findUseridAndKid(find1, find2);
        if(temp)
        	System.out.println("用户已收藏");
        else
        	System.out.println("用户未收藏");
		
		}	
		////////////删删删****************************************************************************************************************
		//删除一条用户记录
		public void onepieceofilikek() {
		System.out.println("请输入要删除的用户id和类别id：");
		IlikeDAO idao =new IlikeDAO();
		String del,del1;
		del=reader.next();del1=reader.next();
		idao.deleteIlike(del,del1);
		System.out.println("删除成功");
		}  
		////////////改***************************************************************************************************************************
		public void changeilike() {
		String uuid;
		System.out.println("请输入要修改的用户id和类别id");
		uuid=reader.next();String upu1=reader.next();
        IlikeDAO ipudao =new IlikeDAO();
        System.out.println("由于该表特殊，只可修改听歌次数");

        int playtimes=reader.nextInt();
        
        
                      ipudao.PrepUpdateIlikeid(uuid, upu1,playtimes);
                      System.out.println("修改成功");
                    
        
        }
		
		
		
		
		/////////////////////////////////////////////////////*******************************************Lmusic表！！！！！！！
		//增	******************************************************************************************************************************
				//(1)PreparedStatement添加用户行.一行数据
				public void insertlmusic() {
				LmusicDAO udao =new LmusicDAO();
				String _mname;
				String _kid;String _uid;
				_mname=reader.next();_kid=reader.next();_uid=reader.next();
				udao.PrepInsertLmusic(_mname, _kid, _uid);
				System.out.println("插入成功");
				}
				//////////查查查******************************************************************************************************************
				//(1)查找所有Lmusic记录
			public void findAllLmusics() {
				LmusicDAO ldao =new LmusicDAO();
				Vector<Lmusic> v=new Vector<Lmusic>();
				v=ldao.findAllLmusic();
				for(Lmusic l:v)
					System.out.println(l.getMname());
			}
				//(2)按用户名和密码查找该用户是否存在
			
				public void findLmusicByKidAndUidd() {
				System.out.println("按歌名和用户id查找该用户是否收藏该歌曲");
				LmusicDAO udao1 =new LmusicDAO();
				String find1;String find2;
				find1=reader.next();find2=reader.next();
				boolean temp=false;
		        temp=udao1.findLmusicByKidAndUid(find1, find2);
		        if(temp)
		        	System.out.println("用户已经收藏");
		        else
		        	System.out.println("用户未收藏");
				
				}	
				////////////删删删****************************************************************************************************************
				//删除一条Lmusic记录
				public void onepieceoflmusic() {
				System.out.println("请输入要删除的歌名和用户id：");
				LmusicDAO ldao =new LmusicDAO();
				String del,del2;
				del=reader.next();del2=reader.next();
				ldao.deleteLmusic(del,del2);
				System.out.println("删除成功");
				}  
				////////////改***************************************************************************************************************************
				public void changelmusic() {
				String llname1;String llid;
				System.out.println("由于本表特殊性，仅可修改歌名");
				System.out.println("请输入当前数据的歌名和用户id");
				llname1=reader.next();llid=reader.next();
		        LmusicDAO lpudao =new LmusicDAO();		        
		        
                System.out.println("请输入要更改的属性值");String llmname =reader.next();
		                      lpudao.PrepUpdateLmusicMname(llname1, llid,llmname);
		                      System.out.println("修改成功");
		        
				
				}
				
				
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
//		StudentDAO sdao =new StudentDAO();
//		Vector<Student> v = new Vector<Student>();
//		sdao.findAllStu();
//		for(Student s: v)
//			System.out.println(s.getSname());
	

		
	
	
	

		
		
		
		
		
		
		
	
	
}
	
	//}

	
	




