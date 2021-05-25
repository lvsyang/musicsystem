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
public class KindDAO {
	//按歌曲id和类别名查找该类别是否存在
	public boolean findKindByKidAndKname(String _kid,String _kname)
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
	("select * from kind where kid='"+_kid+"' and kname='"+_kname+"'");
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
	
	//查找所有的类别记录
	public Vector<Kind> findAllKind(){boolean flag=false;	
		Vector<Kind> v = new Vector<Kind>();
		Connection conn=null;
		Statement stat =null;
		ResultSet rs=null;
		try {
			    conn=DataAccess.getConnection();
				stat = conn.createStatement();
				rs=stat.executeQuery("select * from kind");

				while(rs.next()) {
					//每查找到一条kind记录，创建一个对象，存入可变数组
					Kind k =new Kind();
					k.setKid(rs.getString("kid"));
					k.setKname(rs.getString("kname"));
					v.add(k);
					
					
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
//删除一条kind记录
	public boolean deleteKind(String _kid){
		System.out.println("删除成功");
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
			//看看u01喜欢哪种音乐类型
			rs=stat.executeQuery("select * from ilike where kid='"+_kid+"'" );
			String temp;
			String temp2;
			int num;
			
			
			
		
			HashSet<String> h = new HashSet<String>();
			HashSet<String> h2 = new HashSet<String>();

			while(rs.next()) {
				temp=rs.getString("kid");
				rs1=stat1.executeQuery
						("select count(*) as num from lmusic where kid='"+temp+"'");
				rs1.next();
				num =Integer.parseInt(rs1.getString("num"));
				if(num==1)
				   h.add(temp);
				
			}
			
			
			
///*****
			rs=stat.executeQuery("select * from lmusic where kid='"+_kid+"'" );
			while(rs.next()) {
				temp2=rs.getString("kid");
				rs2=stat1.executeQuery
						("select count(*) as num from ilike where kid='"+temp2+"'");
				rs2.next();
				num =Integer.parseInt(rs2.getString("num"));
				if(num==1)
				   h2.add(temp2);
				
			}
			
			
			
			//增加事物处理
			conn.setAutoCommit(false);
			stat.executeUpdate("delete from lmusic where kid ='"+_kid+"'" );
			stat.executeUpdate("delete from ilike where kid ='"+_kid+"'" );
			Iterator<String> it =h.iterator();
			Iterator<String> it2 =h2.iterator();
			while(it.hasNext())
				stat.executeUpdate("delete from ilike where kid ='"+it.next()+"'" );
			while(it2.hasNext())
			    stat.executeUpdate("delete from lmusic where kid ='"+it2.next()+"'" );
			
			stat.executeUpdate("delete from kind where kid ='"+_kid+"'" );
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
		
	
	
	
	
	
	
	
	
	///使用preparestatement方法插入一行数据
	public void PrepInsertKind(String _kid,String _kname) {
	
	Connection conn=null;
	PreparedStatement prep =null;
	ResultSet rs=null;
	try {
		conn=DataAccess.getConnection();
		//执行SQL语句
			prep =conn.prepareStatement("insert into kind values(?,?)");
			prep.setString(1, _kid);
			prep.setString(2, _kname);
			prep.executeUpdate();		
			//批处理		
			
	}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DataAccess.closeConnection(conn, prep);;
		}

	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//preparestatement更新数据
	public void PrepUpdateKindid(String kkid,String _kid) {
		
		Connection conn=null;
		PreparedStatement prep =null;
		ResultSet rs=null;
		try {
			conn=DataAccess.getConnection();
			//执行SQL语句
				prep =conn.prepareStatement("update kind set kid=? where kid='"+kkid+"'");
				prep.setString(1, _kid);
				prep.executeUpdate();		
				//批处理		
				
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {

				DataAccess.closeConnection(conn, prep);;
			}

		
		}
	
	
	
	public void PrepUpdateKindname(String _kid,String _kname) {
		
		Connection conn=null;
		PreparedStatement prep =null;
		ResultSet rs=null;
		try {
			conn=DataAccess.getConnection();
			//执行SQL语句
				prep =conn.prepareStatement("update kind set kname=?  where kid='"+_kid+"'");
				prep.setString(1, _kname);
				prep.executeUpdate();		
				//批处理		
				
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {

				DataAccess.closeConnection(conn, prep);;
			}

		
		}
	
	
	
	
	
	
	
	public void PrepUpdate(String kkid,String _kid,String _kname) {
		
	Connection conn=null;
	PreparedStatement prep =null;
	ResultSet rs=null;
	try {
		conn=DataAccess.getConnection();
		//执行SQL语句
			prep =conn.prepareStatement("update kind set kid=? ,kname=? where kid='"+kkid+"'");
			prep.setString(1, _kid);
			prep.setString(2, _kname);
			prep.executeUpdate();		
			//批处理		
			
	}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DataAccess.closeConnection(conn, prep);;
		}

	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	}

