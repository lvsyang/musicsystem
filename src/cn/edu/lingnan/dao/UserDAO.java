package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import cn.edu.lingnan.util.DataAccess;
import cn.edu.lingnan.dto.*;
//import cn.edu.lingnan.test.PrepInsertUser;
public class UserDAO {
	//���û�����������Ҹ��û��Ƿ����
	public int findUserByNameAndPassWord(String _name,String _Password)
	{
		int superuser=0;
		boolean flag=false;	
		Connection conn=null;
		Statement stat =null;
		ResultSet rs=null;
		try {
			    conn=DataAccess.getConnection();
			    //ִ��SQL���
				stat = conn.createStatement();
				rs=stat.executeQuery
	("select * from user where uname='"+_name+"' and upassword='"+_Password+"'");
			//��������
				if(rs.next())
                  superuser =rs.getInt("superuser");	
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {
		try {
			if(rs!=null)
			rs.close();
			if(stat!=null)
			stat.close();
			if(conn!=null)
		    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

			}

	

		
		return superuser;
	}
	
	//�������е��û���¼
	public Vector<User> findAllUser(){boolean flag=false;	
		Vector<User> v = new Vector<User>();
		Connection conn=null;
		Statement stat =null;
		ResultSet rs=null;
		try {
			    conn=DataAccess.getConnection();
				stat = conn.createStatement();
				rs=stat.executeQuery("select * from user");

				while(rs.next()) {
					//ÿ���ҵ�һ���û���¼������һ�����󣬴���ɱ�����
					User u =new User();
					u.setUid(rs.getString("uid"));
					u.setUname(rs.getString("uname"));
					u.setUpassword(rs.getString("upassword"));
					u.setSuperuser(rs.getInt("superuser"));
					u.setBan(rs.getInt("ban"));
					v.add(u);
					
					
				}
				
				
				rs.next();
                  flag=true;	
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {
		DataAccess.closeConnection(conn, stat, rs);

			}

	
		
		return v;
	}
	
	
	
	//����һ���û���¼��
	public boolean insertUser(User u) {
		
		boolean flag=false;	
		Connection conn=null;
		Statement stat =null;
		try {
			conn=DataAccess.getConnection();
			stat = conn.createStatement();
			stat.executeUpdate
			("insert into user values(........)");
	
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {
		DataAccess.closeConnection(conn, stat);

			}

	

		
		return flag;
		
	}
	
	
	
	
	
	
	
	
	
//	//����һ���û���¼��
//	public boolean insertUser(User u) {
//		
//		boolean flag=false;	
//		Connection conn=null;
//		Statement stat =null;
//		try {
//			conn=DataAccess.getConnection();
//			stat = conn.createStatement();
//			stat.executeUpdate
//			("insert into user values(........)");
//	
//		}catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//		DataAccess.closeConnection(conn, stat);
//
//			}
//
//	
//
//		
//		return flag;
//		
//	}
	
	
	
	
	
	
	
	
	
	


		

	



//ɾ��һ���û���¼
	public boolean deleteUser(String _uid){
		System.out.println("ɾ���ɹ�");
		Connection conn=null;
		Statement stat =null;
		ResultSet rs=null;
		Statement stat1 =null;
		ResultSet rs1=null;
		Statement stat2 =null;
		ResultSet rs2=null;
		boolean flag=true;
		try {
			conn=DataAccess.getConnection();
			stat = conn.createStatement();
			stat1= conn.createStatement();
			stat2= conn.createStatement();
			
			Statement stat3 =null;
			stat3= conn.createStatement();
			ResultSet rs3=null;
			
			
			//����u01ϲ�������������ͺ���Щ��
			rs=stat.executeQuery("select * from ilike where uid='"+_uid+"'" );
			String temp;
			String temp2;
			int num;
			
			rs3=stat3.executeQuery("select * from user where uid='"+_uid+"' and superuser=2" );
			
			
			if(rs3.next()){/////����Ա�޷�ɾ��
		
			HashSet<String> h = new HashSet<String>();
			HashSet<String> h2 = new HashSet<String>();

			while(rs.next()) {
				temp=rs.getString("uid");
				rs1=stat1.executeQuery
						("select count(*) as num from lmusic where uid='"+temp+"'");
				rs1.next();
				num =Integer.parseInt(rs1.getString("num"));
				if(num==1)
				   h.add(temp);
				
			}
			
			
			
///*****
			rs=stat.executeQuery("select * from lmusic where uid='"+_uid+"'" );
			while(rs.next()) {
				temp2=rs.getString("uid");
				rs2=stat1.executeQuery
						("select count(*) as num from ilike where uid='"+temp2+"'");
				rs2.next();
				num =Integer.parseInt(rs2.getString("num"));
				if(num==1)
				   h2.add(temp2);
				
			}
			
			
			
			//�������ﴦ��
			conn.setAutoCommit(false);
			stat.executeUpdate("delete from lmusic where uid ='"+_uid+"'" );
			stat.executeUpdate("delete from ilike where uid ='"+_uid+"'" );
			Iterator<String> it =h.iterator();
			Iterator<String> it2 =h2.iterator();
			while(it.hasNext())
				stat.executeUpdate("delete from ilike where uid ='"+it.next()+"'" );
			while(it2.hasNext())
			    stat.executeUpdate("delete from ilike where uid ='"+it2.next()+"'" );
			
			stat.executeUpdate("delete from user where uid ='"+_uid+"'" );
			
			}/////����Ա�޷�ɾ��
     	    conn.commit();
	     	conn.setAutoCommit(true);
			
			
			
		}catch (SQLException e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			} 
			e.printStackTrace();
		}finally {
		DataAccess.closeConnection(conn, stat,rs);
		DataAccess.closeConnection(stat1, rs1);

			}

	

		
		return flag;
		
		
		
		
	}
		
	
	
	
	
	
	
	
	
	///ʹ��preparestatement��������һ������
	public void PrepInsertUser(String _uid,String _uname,String _upassword,int _superuser1) {
	
	Connection conn=null;
	PreparedStatement prep =null;
	ResultSet rs=null;
	try {
		conn=DataAccess.getConnection();
		//ִ��SQL���
			prep =conn.prepareStatement("insert into user values(?,?,?,?,0)");
			prep.setString(1, _uid);
			prep.setString(2, _uname);
			prep.setString(3, _upassword);
			prep.setInt(4, _superuser1);
			prep.executeUpdate();		
			//������		
			
	}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DataAccess.closeConnection(conn, prep);;
		}

	
	}
	
	
	
	
	
	
	
//	
//	public void PrepRegister(String _uid,String _uname,String _upassword,int _superuser1) {
//		
//	Connection conn=null;
//	PreparedStatement prep =null;
//	ResultSet rs=null;
//	try {
//		conn=DataAccess.getConnection();
//		//ִ��SQL���
//			prep =conn.prepareStatement("insert into user values(?,?,?,?)");
//			prep.setString(1, _uid);
//			prep.setString(2, _uname);
//			prep.setString(3, _upassword);
//			prep.setInt(4, _superuser1);
//			prep.executeUpdate();		
//			//������		
//			
//	}catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			DataAccess.closeConnection(conn, prep);;
//		}
//
//	
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//preparestatement��������
	public void PrepUpdateUserid(String uuid,String _uid) {
		
		Connection conn=null;
		PreparedStatement prep =null;
		ResultSet rs=null;
		try {
			conn=DataAccess.getConnection();
			//ִ��SQL���
				prep =conn.prepareStatement("update user set uid=? where uid='"+uuid+"'");
				prep.setString(1, _uid);
				prep.executeUpdate();		
				//������		
				
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {

				DataAccess.closeConnection(conn, prep);;
			}

		
		}
	
	
	
	public void PrepUpdateUsername(String _uid,String _uname) {
		
		Connection conn=null;
		PreparedStatement prep =null;
		ResultSet rs=null;
		try {
			conn=DataAccess.getConnection();
			//ִ��SQL���
				prep =conn.prepareStatement("update user set uname=?  where uid='"+_uid+"'");
				prep.setString(1, _uname);
				prep.executeUpdate();		
				//������		
				
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {

				DataAccess.closeConnection(conn, prep);;
			}

		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void PrepUpdateUserPassword(String _uid,String _upassword) {
		
		Connection conn=null;
		PreparedStatement prep =null;
		ResultSet rs=null;
		try {
			conn=DataAccess.getConnection();
			//ִ��SQL���
				prep =conn.prepareStatement("update user set upassword=? where uid='"+_uid+"'");
				prep.setString(1, _upassword);
				prep.executeUpdate();		
				//������		
				
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {

				DataAccess.closeConnection(conn, prep);;
			}

		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void PrepUpdateUserSuperuser(String _uid,int _superuser1) {
		
		Connection conn=null;
		PreparedStatement prep =null;
		ResultSet rs=null;
		try {
			conn=DataAccess.getConnection();
			//ִ��SQL���
				prep =conn.prepareStatement("update user set superuser=? where uid='"+_uid+"'");
				prep.setInt(1, _superuser1);
				prep.executeUpdate();		
				//������		
				
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {

				DataAccess.closeConnection(conn, prep);;
			}

		
		}
	
	
	
	
	
	
	
	
	
	
	
	public void PrepUpdate(String uuid,String _uid,String _uname,String _upassword,int _superuser1) {
		
	Connection conn=null;
	PreparedStatement prep =null;
	ResultSet rs=null;
	try {
		conn=DataAccess.getConnection();
		//ִ��SQL���
			prep =conn.prepareStatement("update user set uid=? ,uname=?,upassword=?,superuser=? where uid='"+uuid+"'");
			prep.setString(1, _uid);
			prep.setString(2, _uname);
			prep.setString(3, _upassword);
			prep.setInt(4, _superuser1);
			prep.executeUpdate();		
			//������		
			
	}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DataAccess.closeConnection(conn, prep);;
		}

	
	}
	
	
	
	
//public void SearchAllUserid(String uuid,String _uid) {
//		
//		Connection conn=null;
//		PreparedStatement prep =null;
//		ResultSet rs=null;
//		try {
//			conn=DataAccess.getConnection();
//			//ִ��SQL���
//				prep =conn.prepareStatement("update user set uid=? where uid='"+uuid+"'");
//				prep.setString(1, _uid);
//				prep.executeUpdate();		
//				//������		
//				
//		}catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//
//				DataAccess.closeConnection(conn, prep);;
//			}
//
//		
//		}
	
	
	
public Vector<User> findAllUserid(){boolean flag=false;	
Vector<User> v = new Vector<User>();
Connection conn=null;
Statement stat =null;
ResultSet rs=null;
try {
	    conn=DataAccess.getConnection();
		stat = conn.createStatement();
		rs=stat.executeQuery("select uid from user");
		while(rs.next()) {
			//ÿ���ҵ�һ���û���¼������һ�����󣬴���ɱ�����
			User u =new User();
			u.setUid(rs.getString("uid"));
			v.add(u);
			
			
		}
		
		
		rs.next();
          flag=true;	
}catch (SQLException e) {
		e.printStackTrace();
	} finally {
DataAccess.closeConnection(conn, stat, rs);

	}



return v;
}











public boolean updateUser(User u){
	boolean flag=false;
	String uid=u.getUid();
	String uname=u.getUname();
	String upassword=u.getUpassword();
	int superuser=u.getSuperuser();
	String sql="update user set uname='"+uname+"',upassword='"
			+upassword+"',superuser='"+superuser+"'where uid='"+uid+"'";
	Connection conn=null;
	Statement stat =null;
	try {
		conn=DataAccess.getConnection();
		stat = conn.createStatement();
		stat.executeUpdate(sql);
	}catch (SQLException e) {
		e.printStackTrace();
	} finally {
DataAccess.closeConnection(conn, stat);

	}
	
	
	
	
	return flag;
}
	
	


public boolean banUser(String uid){
	boolean flag=true;
	String sql="update user set ban=1 where uid='"+uid+"' and superuser=2";
	Connection conn=null;
	Statement stat =null;
	try {
		conn=DataAccess.getConnection();
		stat = conn.createStatement();
		stat.executeUpdate(sql);
	}catch (SQLException e) {
		e.printStackTrace();
	} finally {
DataAccess.closeConnection(conn, stat);

	}
	
	
	
	
	return flag;
}
	
	
public boolean ubanUser(String uid){
	boolean flag=true;
	String sql="update user set ban=0 where uid='"+uid+"' and superuser=2";
	Connection conn=null;
	Statement stat =null;
	try {
		conn=DataAccess.getConnection();
		stat = conn.createStatement();
		stat.executeUpdate(sql);
	}catch (SQLException e) {
		e.printStackTrace();
	} finally {
DataAccess.closeConnection(conn, stat);

	}
	
	
	
	
	return flag;
}
	
	
public int bbb(String _name,String _Password)//����Ժ������¼
{
	int ban=1;
	boolean flag=false;	
	Connection conn=null;
	Statement stat =null;
	ResultSet rs=null;
	try {
		    conn=DataAccess.getConnection();
		    //ִ��SQL���
			stat = conn.createStatement();
			rs=stat.executeQuery
("select * from user where uid='"+_name+"' and upassword='"+_Password+"'");
		//��������
			if(rs.next())
              ban =rs.getInt("ban");	
	}catch (SQLException e) {
			e.printStackTrace();
		} finally {
	try {
		if(rs!=null)
		rs.close();
		if(stat!=null)
		stat.close();
		if(conn!=null)
	    conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

		}



	
	return ban;
}	






public int ubbb(String _name,String _Password)
{
	int ban=0;
	boolean flag=false;	
	Connection conn=null;
	Statement stat =null;
	ResultSet rs=null;
	try {
		    conn=DataAccess.getConnection();
		    //ִ��SQL���
			stat = conn.createStatement();
			rs=stat.executeQuery
("select * from user where uname='"+_name+"' and upassword='"+_Password+"'");
		//��������
			if(rs.next())
              ban =rs.getInt("ban");	
	}catch (SQLException e) {
			e.printStackTrace();
		} finally {
	try {
		if(rs!=null)
		rs.close();
		if(stat!=null)
		stat.close();
		if(conn!=null)
	    conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

		}



	
	return ban;
}	
	
	




public User findUser(String uid){                      //���ҵ����û�
	Connection conn=DataAccess.getConnection();
	Statement state =null;
	ResultSet rs = null;
	User u=new User();
	try{
	String sql = "select * from user where uid = '"+uid+"'";
	state = conn.createStatement();
	rs=state.executeQuery(sql);
	if(rs.next()){
		u.setUid(rs.getString("uid"));
		u.setUname(rs.getString("uname"));
		u.setUpassword(rs.getString("upassword"));
	}
	}catch(Exception e){
		e.printStackTrace();
		}finally{
		DataAccess.closeConnection(conn,state, rs);
	}
	return u;
	}







public int findUserByuidAndPassWord(String _name,String _Password)
{
	int superuser=0;
	boolean flag=false;	
	Connection conn=null;
	Statement stat =null;
	ResultSet rs=null;
	try {
		    conn=DataAccess.getConnection();
		    //ִ��SQL���
			stat = conn.createStatement();
			rs=stat.executeQuery
("select * from user where uid='"+_name+"' and upassword='"+_Password+"'");
		//��������
			if(rs.next())
              superuser =rs.getInt("superuser");	
	}catch (SQLException e) {
			e.printStackTrace();
		} finally {
	try {
		if(rs!=null)
		rs.close();
		if(stat!=null)
		stat.close();
		if(conn!=null)
	    conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

		}



	
	return superuser;
}

		
}

