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
		System.out.println("��ӭ�������ֺ�̨����ϵͳ����ѡ����Ҫ�����ı�");
		System.out.println("1���û���");
		System.out.println("2��Kind��");
		System.out.println("3��Ilike��");
		System.out.println("4��Lmusic��");	
		int x;int y;
		while(true)
		{		
			x=reader.nextInt();///ѡ����Ҫ�����ı�
			if(x==1)y=1;
			else if(x==2)y=2;
			else if(x==3)y=3;
			else if(x==4)y=4;
			else y=5;
			switch(y)
			{
			case 1://///////////////////////////////////////////////////////////////�û���
			{
				
				System.out.println("��ӭ�����û����̨������ѡ����Ҫ�����ķ���");
				System.out.println("1.��");
				System.out.println("2.��");
				System.out.println("3.ɾ");
				System.out.println("4.��");
				int u0;
				u0=reader.nextInt();
				     switch(u0) {
				   case 1://////��ѯ�û���
					 System.out.println("��ѡ��Ҫ��ѯ�ķ�����");
				     System.out.println("1.���������û�");
				     System.out.println("2.���û�����������Ҹ��û��Ƿ����");
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
				     
				  case 2:///////�����û���
				    System.out.println("������Ҫ���ӵ����ݣ�");
				    Test insu=new Test();
				    insu.insertus();	     
				     break;
				  case 3:///////ɾ���û���					 
					 Test onepu=new Test();
					 onepu.onepieceofuser();
					 break;
				  case 4:///////�޸��û���
					 Test changeus=new Test();
					 changeus.changeuser();
					 break;			     
				     }
			
			
			break;
			}//�û������!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			
			
			
			case 2:///////////////////////////////////kind��
//				System.out.println("Kind��");
{
				
				System.out.println("��ӭ����kind���̨������ѡ����Ҫ�����ķ���");
				System.out.println("1.��");
				System.out.println("2.��");
				System.out.println("3.ɾ");
				System.out.println("4.��");
				int u1;
				u1=reader.nextInt();
				     switch(u1) {
				   case 1://////��ѯkind��
					 System.out.println("��ѡ��Ҫ��ѯ�ķ�����");
				     System.out.println("1.�����������");
				     System.out.println("2.�����id����������Ҹ��û��Ƿ����");
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
				     
				  case 2:///////����kind��
				    System.out.println("������Ҫ���ӵ����ݣ�");
				    Test insk=new Test();
				    insk.insertkind();	     
				     break;
				  case 3:///////ɾ��kind��					 
					 Test onepk=new Test();
					 onepk.onepieceofkind();
					 break;
				  case 4:///////�޸�kind��
					 Test changekin=new Test();
					 changekin.changekind();
					 break;			     
				     }
			
			
			break;
			}//kind�����!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			
				
				
				
				
				

			case 3:System.out.println("Ilike��");//////////////////////////////////////////////////////ilike��
			
			{
				
				System.out.println("��ӭ����ilike���̨������ѡ����Ҫ�����ķ���");
				System.out.println("1.��");
				System.out.println("2.��");
				System.out.println("3.ɾ");
				System.out.println("4.��");
				int u2;
				u2=reader.nextInt();
				     switch(u2) {
				   case 1://////��ѯilike��
					 System.out.println("��ѡ��Ҫ��ѯ�ķ�����");
				     System.out.println("1.���������û��ļ�¼");
				     System.out.println("2.���û�id�����id�鿴���û��Ƿ����ղظø赥");
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
				     
				  case 2:///////����ilike��
				    System.out.println("������Ҫ���ӵ����ݣ�");
				    Test insi=new Test();
				    insi.insertilike();	     
				     break;
				  case 3:///////ɾ��ilke��					 
					 Test onepi=new Test();
					 onepi.onepieceofilikek();
					 break;
				  case 4:///////�޸�ilike��
					 Test changeilike=new Test();
					 changeilike.changeilike();
					 break;			     
				     }
			
			
			break;
			}//ilike�����!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			
			
			
			
			
			
			
			
			
			
			
			
	
			case 4:System.out.println("Lmusic��");
{
				
				System.out.println("��ӭ����Lmusic���̨������ѡ����Ҫ�����ķ���");
				System.out.println("1.��");
				System.out.println("2.��");
				System.out.println("3.ɾ");
				System.out.println("4.��");
				int u3;
				u3=reader.nextInt();
				     switch(u3) {
				   case 1://////��ѯLmusic��
					 System.out.println("��ѡ��Ҫ��ѯ�ķ�����");
				     System.out.println("1.�������и�����");
				     System.out.println("2.���������û�id���Ҹ��û��Ƿ��ղظø���");
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
				     
				  case 2:///////����Lmusic��
				    System.out.println("������Ҫ���ӵ����ݣ�");
				    Test insl=new Test();
				    insl.insertlmusic();	     
				     break;
				  case 3:///////ɾ��Lmusic��					 
					 Test onepl=new Test();
					 onepl.onepieceoflmusic();
					 break;
				  case 4:///////�޸�Lmusic��
					 Test changelm=new Test();
					 changelm.changelmusic();
					 break;			     
				     }
			
			
			break;
			}//Lmusic�����!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			case 5:System.out.println("������������������");break;
			}
		}

		
		
		
	}
		
		
		
		
		//��	******************************************************************************************************************************
		//(1)PreparedStatement����û���.һ������
		public void insertus() {
		UserDAO udao =new UserDAO();
		String _uid1;
		String _uname1;
		String _upassword1;
		int _superuser1;
		_uid1=reader.next();_uname1=reader.next();_upassword1=reader.next();_superuser1=reader.nextInt();
		udao.PrepInsertUser(_uid1, _uname1, _upassword1, _superuser1);
		System.out.println("����ɹ�");
		}
		//////////����******************************************************************************************************************
		//(1)���������û�
	public void findAllUser() {
		UserDAO udao =new UserDAO();
		Vector<User> v=new Vector<User>();
		v=udao.findAllUser();
		for(User u:v)
			System.out.println(u.getUname());
	}
		//(2)���û�����������Ҹ��û��Ƿ����
	
		public void findbyUseridAndPassword() {
		System.out.println("���û�����������Ҹ��û��Ƿ����?");
		UserDAO udao1 =new UserDAO();
		String find1;String find2;
		find1=reader.next();find2=reader.next();
		int temp=0;
        temp=udao1.findUserByNameAndPassWord(find1, find2);
        if(temp==1)
        	System.out.println("�û�����");
        else
        	System.out.println("�û�������");
		
		}	
		////////////ɾɾɾ****************************************************************************************************************
		//ɾ��һ���û���¼
		public void onepieceofuser() {
		System.out.println("������Ҫɾ�����û�����");
		UserDAO udao =new UserDAO();
		String del;
		del=reader.next();
		udao.deleteUser(del);
		System.out.println("ɾ���ɹ�");
		}  
		////////////��***************************************************************************************************************************
		public void changeuser() {
		String uuid;
		System.out.println("������Ҫ�޸ĵ��û����û���");
		uuid=reader.next();
        int uu;
        UserDAO upudao =new UserDAO();
        System.out.println("��ѡ��Ҫ�޸ĵ�����");
        System.out.println("1.�û��˺�");
        System.out.println("2.�û���");
        System.out.println("3.����");
        System.out.println("4.�û�Ȩ�޼���");
        System.out.println("5.�Զ����޸�����");
        
        uu=reader.nextInt();
        switch(uu) {
        
        case 1:System.out.println("������Ҫ���ĵ�����ֵ");String upu1=reader.next();
                      upudao.PrepUpdateUserid(uuid, upu1);
                      System.out.println("�޸ĳɹ�");
                      break;
        	
        case 2:System.out.println("������Ҫ���ĵ�����ֵ");String upu2=reader.next();
        upudao.PrepUpdateUsername(uuid, upu2);System.out.println("�޸ĳɹ�");break;
        	
        case 3:System.out.println("������Ҫ���ĵ�����ֵ");String upu3=reader.next();
        upudao.PrepUpdateUserPassword(uuid, upu3);
        System.out.println("�޸ĳɹ�");
        break;
        	
        case 4:System.out.println("������Ҫ���ĵ�����ֵ");int upu4=reader.nextInt();
        upudao.PrepUpdateUserSuperuser(uuid, upu4);
        System.out.println("�޸ĳɹ�");
        break;
        
        case 5:System.out.println("��������������ֵ���޸��Զ�������");
        String upu5=reader.next();
        String upu6=reader.next();
        String upu7=reader.next();
        int upu8=reader.nextInt();
        upudao.PrepUpdate(uuid, upu5, upu6, upu7, upu8);
        System.out.println("�޸ĳɹ�");
        break;
        
        }
		
		}
		
		

		
		
		//////////////////////////***************************************************************************kind��
		

		
		
		
		
		
		
		//��	******************************************************************************************************************************
		//(1)PreparedStatement����û���.һ������
		public void insertkind() {
		KindDAO kdao =new KindDAO();
		String _kid1;
		String _kname1;
		_kid1=reader.next();_kname1=reader.next();
		kdao.PrepInsertKind(_kid1, _kname1);
		System.out.println("����ɹ�");
		}
		//////////����******************************************************************************************************************
		//(1)���������û�
	public void findAllKinds() {
		KindDAO kdao =new KindDAO();
		Vector<Kind> v=new Vector<Kind>();
		v=kdao.findAllKind();
		for(Kind u:v)
			System.out.println(u.getKname());
	}
		//(2)���û�����������Ҹ��û��Ƿ����
	
		public void findbyKindidAndKname() {
		System.out.println("�����id����������Ҹ�����Ƿ����?");
		KindDAO kdao1 =new KindDAO();
		String find1;String find2;
		find1=reader.next();find2=reader.next();
		boolean temp=false;
        temp=kdao1.findKindByKidAndKname(find1, find2);
        if(temp)
        	System.out.println("������");
        else
        	System.out.println("��𲻴���");
		
		}	
		////////////ɾɾɾ****************************************************************************************************************
		//ɾ��һ���û���¼
		public void onepieceofkind() {
		System.out.println("������Ҫɾ�����������");
		KindDAO kdao =new KindDAO();
		String del;
		del=reader.next();
		kdao.deleteKind(del);
		System.out.println("ɾ���ɹ�");
		}  
		////////////��***************************************************************************************************************************
		public void changekind() {
		String kkid;
		System.out.println("������Ҫ�޸ĵ�����id");
		kkid=reader.next();
        int kk;
        KindDAO upudao =new KindDAO();
        System.out.println("��ѡ��Ҫ�޸ĵ�����");
        System.out.println("1.���id");
        System.out.println("2.�����");
        System.out.println("3.�Զ����޸�����");
        kk=reader.nextInt();
        switch(kk) {
        
        case 1:System.out.println("������Ҫ���ĵ�����ֵ");String kpu1=reader.next();
                      upudao.PrepUpdateKindid(kkid, kpu1);
                      System.out.println("�޸ĳɹ�");
                      break;
        	
        case 2:System.out.println("������Ҫ���ĵ�����ֵ");String kpu2=reader.next();
        upudao.PrepUpdateKindname(kkid, kpu2);System.out.println("�޸ĳɹ�");break;
        	
        
        case 3:System.out.println("��������������ֵ���޸��Զ�������");
        String kpu3=reader.next();
        String kpu4=reader.next();
        upudao.PrepUpdate(kkid, kpu3, kpu4);
        System.out.println("�޸ĳɹ�");
        break;
        
        }
		
		}
		
		
		
		
		
		
		//////////////////////////***************************************************************************ilike��
		

		//��	******************************************************************************************************************************
		//(1)PreparedStatement����û���.һ������
		public void insertilike() {
		IlikeDAO idao =new IlikeDAO();
		String _uid;
		String _kid;
		int _playtimes;
		_uid=reader.next();_kid=reader.next();_playtimes=reader.nextInt();
		idao.PrepInsertIlike(_uid, _kid, _playtimes);
		System.out.println("����ɹ�");
		}
		//////////����******************************************************************************************************************
		//(1)��������ilike
	public void findAllIlike() {
		IlikeDAO idao =new IlikeDAO();
		Vector<ilike> v=new Vector<ilike>();
		v=idao.findAllIlike();
		for(ilike i:v)
			System.out.println(i.getUid()+"   "+i.getKid()+"   "+i.getPlaytimes());
		
	}
		//(2)���û�id�����id�鿴���û��Ƿ����ղظø赥
	
		public void findUseridAndKide() {
		System.out.println("���û�id�����id�鿴���û��Ƿ����ղظø赥");
		IlikeDAO idao1 =new IlikeDAO();
		String find1;String find2;
		find1=reader.next();find2=reader.next();
		boolean temp=false;
        temp=idao1.findUseridAndKid(find1, find2);
        if(temp)
        	System.out.println("�û����ղ�");
        else
        	System.out.println("�û�δ�ղ�");
		
		}	
		////////////ɾɾɾ****************************************************************************************************************
		//ɾ��һ���û���¼
		public void onepieceofilikek() {
		System.out.println("������Ҫɾ�����û�id�����id��");
		IlikeDAO idao =new IlikeDAO();
		String del,del1;
		del=reader.next();del1=reader.next();
		idao.deleteIlike(del,del1);
		System.out.println("ɾ���ɹ�");
		}  
		////////////��***************************************************************************************************************************
		public void changeilike() {
		String uuid;
		System.out.println("������Ҫ�޸ĵ��û�id�����id");
		uuid=reader.next();String upu1=reader.next();
        IlikeDAO ipudao =new IlikeDAO();
        System.out.println("���ڸñ����⣬ֻ���޸��������");

        int playtimes=reader.nextInt();
        
        
                      ipudao.PrepUpdateIlikeid(uuid, upu1,playtimes);
                      System.out.println("�޸ĳɹ�");
                    
        
        }
		
		
		
		
		/////////////////////////////////////////////////////*******************************************Lmusic��������������
		//��	******************************************************************************************************************************
				//(1)PreparedStatement����û���.һ������
				public void insertlmusic() {
				LmusicDAO udao =new LmusicDAO();
				String _mname;
				String _kid;String _uid;
				_mname=reader.next();_kid=reader.next();_uid=reader.next();
				udao.PrepInsertLmusic(_mname, _kid, _uid);
				System.out.println("����ɹ�");
				}
				//////////����******************************************************************************************************************
				//(1)��������Lmusic��¼
			public void findAllLmusics() {
				LmusicDAO ldao =new LmusicDAO();
				Vector<Lmusic> v=new Vector<Lmusic>();
				v=ldao.findAllLmusic();
				for(Lmusic l:v)
					System.out.println(l.getMname());
			}
				//(2)���û�����������Ҹ��û��Ƿ����
			
				public void findLmusicByKidAndUidd() {
				System.out.println("���������û�id���Ҹ��û��Ƿ��ղظø���");
				LmusicDAO udao1 =new LmusicDAO();
				String find1;String find2;
				find1=reader.next();find2=reader.next();
				boolean temp=false;
		        temp=udao1.findLmusicByKidAndUid(find1, find2);
		        if(temp)
		        	System.out.println("�û��Ѿ��ղ�");
		        else
		        	System.out.println("�û�δ�ղ�");
				
				}	
				////////////ɾɾɾ****************************************************************************************************************
				//ɾ��һ��Lmusic��¼
				public void onepieceoflmusic() {
				System.out.println("������Ҫɾ���ĸ������û�id��");
				LmusicDAO ldao =new LmusicDAO();
				String del,del2;
				del=reader.next();del2=reader.next();
				ldao.deleteLmusic(del,del2);
				System.out.println("ɾ���ɹ�");
				}  
				////////////��***************************************************************************************************************************
				public void changelmusic() {
				String llname1;String llid;
				System.out.println("���ڱ��������ԣ������޸ĸ���");
				System.out.println("�����뵱ǰ���ݵĸ������û�id");
				llname1=reader.next();llid=reader.next();
		        LmusicDAO lpudao =new LmusicDAO();		        
		        
                System.out.println("������Ҫ���ĵ�����ֵ");String llmname =reader.next();
		                      lpudao.PrepUpdateLmusicMname(llname1, llid,llmname);
		                      System.out.println("�޸ĳɹ�");
		        
				
				}
				
				
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
//		StudentDAO sdao =new StudentDAO();
//		Vector<Student> v = new Vector<Student>();
//		sdao.findAllStu();
//		for(Student s: v)
//			System.out.println(s.getSname());
	

		
	
	
	

		
		
		
		
		
		
		
	
	
}
	
	//}

	
	




