package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import cn.edu.lingnan.util.DataAccess;
import cn.edu.lingnan.dto.*;
//import cn.edu.lingnan.test.PrepInsertUser;
public class IlikeDAO {
	//按用户id和类别id查看该用户是否有收藏该歌单
	public boolean findUseridAndKid(String _uid,String _kid)
	{
		boolean flag=false;	
		Connection conn=null;
		Statement stat =null;
		ResultSet rs=null;
		try {
			    conn=DataAccess.getConnection();
			    //执行SQL语句
				stat = conn.createStatement();
				rs=stat.executeQuery
	("select * from ilike where uid='"+_uid+"' and kid='"+_kid+"'");
			//处理结果集
				if(rs.next())
                  flag=true;	
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

	

		
		return flag;
	}
	
	//查找所有的用户记录
	public Vector<ilike> findAllIlike(){boolean flag=false;	
		Vector<ilike> v = new Vector<ilike>();
		Connection conn=null;
		Statement stat =null;
		ResultSet rs=null;
		try {
			    conn=DataAccess.getConnection();
				stat = conn.createStatement();
				rs=stat.executeQuery("select * from ilike");

				while(rs.next()) {
					//每查找到一条ilike记录，创建一个对象，存入可变数组
					ilike i=new ilike();
					i.setUid(rs.getString("uid"));
					i.setKid(rs.getString("kid"));
					v.add(i);
					
					
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
	


//删除一条用户记录
	public boolean deleteIlike(String _uid,String _kid){
		System.out.println("删除成功");
		Connection conn=null;
		Statement stat =null;
		ResultSet rs=null;
		Statement stat1 =null;
//		ResultSet rs1=null;
//		Statement stat2 =null;
//		ResultSet rs2=null;
		boolean flag=true;
		try {
			conn=DataAccess.getConnection();
			stat = conn.createStatement();
//			stat1= conn.createStatement();
//			stat2= conn.createStatement();
			//看看u01喜欢哪种音乐类型和哪些歌
			rs=stat.executeQuery("select * from ilike where uid='"+_uid+"' and kid='"+_kid+"'" );	
///*****
//			rs=stat.executeQuery("select * from lmusic where uid='"+_uid+"'" );

				

			
			
			
			//增加事物处理
			conn.setAutoCommit(false);

			
			stat.executeUpdate("delete from ilike where uid ='"+_uid+"'and kid='"+_kid+"'" );
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
//		DataAccess.closeConnection(stat1, rs1);

			}

	

		
		return flag;
		
		
		
		
	}
		
	
	
	
	
	
	
	
	
	///使用preparestatement方法插入一行数据
	public void PrepInsertIlike(String _uid,String _kid,int _playtimes) {
	
	Connection conn=null;
	PreparedStatement prep =null;
	ResultSet rs=null;
	try {
		conn=DataAccess.getConnection();
		//执行SQL语句
			prep =conn.prepareStatement("insert into ilike values(?,?,?)");
			prep.setString(1, _uid);
			prep.setString(2, _kid);
			prep.setInt(3, _playtimes);
			prep.executeUpdate();		
			//批处理		
			
	}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DataAccess.closeConnection(conn, prep);;
		}

	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//preparestatement更改听歌时间
	public void PrepUpdateIlikeid(String uuid,String kkid,int _playtimes) {
		
		Connection conn=null;
		PreparedStatement prep =null;
		ResultSet rs=null;
		try {
			conn=DataAccess.getConnection();
			//执行SQL语句
				prep =conn.prepareStatement("update ilike set playtimes=? where uid='"+uuid+"' and kid='"+kkid+"'");
				prep.setInt(1,_playtimes);				
				prep.executeUpdate();		
				//批处理		
				
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {

				DataAccess.closeConnection(conn, prep);;
			}

		
		}
	
	
	
	
	
	
	
	public Vector<ilike> findIlike(){boolean flag=false;	
	Vector<ilike> v = new Vector<ilike>();
	Connection conn=null;
	Statement stat =null;
	ResultSet rs=null;
	try {
		    conn=DataAccess.getConnection();
			stat = conn.createStatement();
			rs=stat.executeQuery("select * from user natural join ilike");

			while(rs.next()) {
				//每查找到一条ilike记录，创建一个对象，存入可变数组
				ilike i =new ilike();		
				i.setUid(rs.getString("uid"));
				i.setKid(rs.getString("kid"));
				i.setPlaytimes(rs.getInt("playtimes"));;
				v.add(i);
				
				
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	}

