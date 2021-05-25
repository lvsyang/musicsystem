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
public class LmusicDAO {
	//按歌名和用户id查找该用户是否收藏该歌曲
	public boolean findLmusicByKidAndUid(String _mname,String _uid)
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
	("select * from lmusic where mname='"+_mname+"' and uid='"+_uid+"'");
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
	
	//查找所有的歌曲名
	public Vector<Lmusic> findAllLmusic(){boolean flag=false;	
		Vector<Lmusic> v = new Vector<Lmusic>();
		Connection conn=null;
		Statement stat =null;
		ResultSet rs=null;
		try {
			    conn=DataAccess.getConnection();
				stat = conn.createStatement();
				rs=stat.executeQuery("select * from lmusic");

				while(rs.next()) {
					//每查找到一条Lmusic记录，创建一个对象，存入可变数组
					Lmusic l =new Lmusic();
					l.setMname(rs.getString("mname"));
					l.setKid(rs.getString("kid"));
					l.setUid(rs.getString("uid"));
					v.add(l);
					
					
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
	
	
	


//删除一条用户喜欢的音乐记录
	public boolean deleteLmusic(String _mname,String _uid){
		System.out.println("删除成功");
		Connection conn=null;
		Statement stat =null;
		ResultSet rs=null;
		boolean flag=true;
		try {
			conn=DataAccess.getConnection();
			stat = conn.createStatement();
			//看看u01喜欢哪种音乐类型和哪些歌
			rs=stat.executeQuery("select * from lmusic where mname='"+_mname+"' and uid='"+_uid+"'" );
			int num;
			//增加事物处理
			conn.setAutoCommit(false);
			stat.executeUpdate("delete from lmusic where mname='"+_mname+"' and uid ='"+_uid+"'" );
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

			}

	

		
		return flag;
		
		
		
		
	}
		
	
	
	
	
	
	
	
	
	///使用preparestatement方法插入一行数据
	public void PrepInsertLmusic(String _mname,String _kid,String _uid) {
	
	Connection conn=null;
	PreparedStatement prep =null;
	ResultSet rs=null;
	try {
		conn=DataAccess.getConnection();
		//执行SQL语句
			prep =conn.prepareStatement("insert into lmusic values(?,?,?)");
			prep.setString(2, _mname);
			prep.setString(2, _kid);
            prep.setString(3, _uid);			
			prep.executeUpdate();		
			//批处理		
			
	}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DataAccess.closeConnection(conn, prep);;
		}

	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//preparestatement更新数据
	public void PrepUpdateLmusicMname(String _mname,String _uid,String mmname) {
		
		Connection conn=null;
		PreparedStatement prep =null;
		ResultSet rs=null;
		try {
			conn=DataAccess.getConnection();
			//执行SQL语句
				prep =conn.prepareStatement("update lmusic set mname=?  where mname='"+_mname+"'and uid='"+_uid+"'");
				prep.setString(1, mmname);
				prep.executeUpdate();		
				//批处理		
				
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {

				DataAccess.closeConnection(conn, prep);;
			}

		
		}
	
	
	
	//////////////////查找单个用户喜欢歌曲
//	public Lmusic findLmusic(String uid){                      //查找单个用户喜欢歌曲
//		Connection conn=DataAccess.getConnection();
//		Statement state =null;
//		ResultSet rs = null;
//		
//		Lmusic l=new Lmusic();
//		try{
//		String sql = "select * from lmusic where uid = '"+uid+"'";
//		state = conn.createStatement();
//		rs=state.executeQuery(sql);
//		if(rs.next()){
//			l.setUid(rs.getString("uid"));
//			l.setMname(rs.getString("mname"));
//			l.setKid(rs.getString("kid"));
//		}
//		}catch(Exception e){
//			e.printStackTrace();
//			}finally{
//			DataAccess.closeConnection(conn,state, rs);
//		}
//		return l;
//		}
//	
	
	
	
	
	
	
	
	public Vector<Lmusic> findLmusic(String uid){boolean flag=false;	
	Vector<Lmusic> v = new Vector<Lmusic>();
	Connection conn=null;
	Statement stat =null;
	ResultSet rs=null;
	try {
		    conn=DataAccess.getConnection();
			stat = conn.createStatement();
			rs=stat.executeQuery("select * from lmusic where uid = '"+uid+"'");

			while(rs.next()) {
				//每查找到一条music记录，创建一个对象，存入可变数组
				Lmusic l =new Lmusic();
				l.setMname(rs.getString("mname"));
				l.setKid(rs.getString("kid"));
				//l.setKname(rs.getString("kname"));
//				l.setMid(rs.getString("mid"));
//				l.setPastm(rs.getInt("pastm"));
				//l.setUid(rs.getString("uid"));
				v.add(l);
				
				
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

	
	
	
	
///////////////////////////////建立新表Music实现查找所有歌曲的功能	
	public Vector<Music> findLmusic(){boolean flag=false;	
	Vector<Music> v = new Vector<Music>();
	Connection conn=null;
	Statement stat =null;
	ResultSet rs=null;
	try {
		    conn=DataAccess.getConnection();
			stat = conn.createStatement();
			rs=stat.executeQuery("select * from music natural join kind");

			while(rs.next()) {
				//每查找到一条music记录，创建一个对象，存入可变数组
				Music m =new Music();
				m.setMname(rs.getString("mname"));
				m.setKid(rs.getString("kid"));
				m.setKname(rs.getString("kname"));
				m.setMid(rs.getString("mid"));
				m.setPastm(rs.getInt("pastm"));
				//l.setUid(rs.getString("uid"));
				v.add(m);
				
				
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

	
	
	
	
	
	
	///////////////////////////用Lmusic表，通过groupby语法遍历出所有歌曲
	
		public Vector<Lmusic> findmyLmusic(){boolean flag=false;	
			Vector<Lmusic> v = new Vector<Lmusic>();
			Connection conn=null;
			Statement stat =null;
			ResultSet rs=null;
			try {
				    conn=DataAccess.getConnection();
					stat = conn.createStatement();
					rs=stat.executeQuery("select * from lmusic natural join kind group by mname");

					while(rs.next()) {
						//每查找到一条Lmusic记录，创建一个对象，存入可变数组
						Lmusic l =new Lmusic();
						Kind k=new Kind();
						l.setMname(rs.getString("mname"));
						l.setKid(rs.getString("kid"));
						l.setUid(rs.getString("uid"));
						l.setKname(rs.getString("kname"));
						v.add(l);
						
						
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
		
		
		
		
		
		public Music findMusic(String mid){                      //查找单个歌曲
			Connection conn=DataAccess.getConnection();
			Statement state =null;
			ResultSet rs = null;
			Music m= new Music();
			try{
			String sql = "select * from music where mid = '"+mid+"'";
			state = conn.createStatement();
			rs=state.executeQuery(sql);
			if(rs.next()){
				m.setMname(rs.getString("mname"));
				m.setKid(rs.getString("kid"));
				//m.setKname(rs.getString("kname"));
				m.setMid(rs.getString("mid"));
				//u.setUpassword(rs.getString("upassword"));
			}
			}catch(Exception e){
				e.printStackTrace();
				}finally{
				DataAccess.closeConnection(conn,state, rs);
			}
			return m;
			}


		
		
		
		public boolean updateMusic(Music m){
			boolean flag=false;
			String mname=m.getMname();
			String kid=m.getKid();
			String mid=m.getMid();
			String sql="update music set kid='"+kid+"',mname='"+mname+"' where mid='"+mid+"'";
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
		
	
	
		
		
		////*********************************************************删除Music表中的一条指定数据
		public boolean deleteMusic(String mid){
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
				//看看u01喜欢哪种音乐类型和哪些歌
				rs=stat.executeQuery("select * from lmusic where mname=(select mname from music where mid='"+mid+"')" );
				String temp;
				int num;
				
				
				
			
				HashSet<String> h = new HashSet<String>();

				while(rs.next()) {
					temp=rs.getString("mname");
					rs1=stat1.executeQuery
							("select count(*) as num from lmusic where mname='"+temp+"'");
					rs1.next();
					num =Integer.parseInt(rs1.getString("num"));
					if(num==1)
					   h.add(temp);
					
				}
				
				
				
	///*****		
				//增加事物处理
				conn.setAutoCommit(false);
				stat.executeUpdate("delete from lmusic where mname =(select mname from music where mid='"+mid+"')" );
				Iterator<String> it =h.iterator();

				while(it.hasNext())
					stat.executeUpdate("delete from lmusic where mname ='"+it.next()+"'" );
				stat.executeUpdate("delete from music where mid ='"+mid+"'" );
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
		
		
		
		
		////////////*******************根据mid下架歌曲
		public boolean banMsuic(String mid){
			boolean flag=true;
			String sql="update music set pastm=1 where mid='"+mid+"'";
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
		
		////////************************************************************************************上架
		
		public boolean ubanMsuic(String mid){
			boolean flag=true;
			String sql="update music set pastm=0 where mid='"+mid+"'";
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
		
		
		
		
		
		
		
		
		
		
		
		///使用preparestatement方法插入一行数据
		public void PrepInsertaLmusic(String mname,String kid,String uid) {
		
		Connection conn=null;
		PreparedStatement prep =null;
		ResultSet rs=null;
		try {
			conn=DataAccess.getConnection();
			//执行SQL语句
				prep =conn.prepareStatement("insert into lmusic values(?,?,?)");
				prep.setString(1, mname);
				prep.setString(2, kid);
	            prep.setString(3, uid);			
				prep.executeUpdate();		
				//批处理		
				
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {

				DataAccess.closeConnection(conn, prep);;
			}

		
		}
		
		
		
		
		
		
		
		
		
		public boolean PlayMusic(String uid,String kid){
			boolean flag=true;
			String sql="update ilike set playtimes=playtimes+1 where uid='"+uid+"'&&kid='"+kid+"'";
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
	
	
	
	
	
	
	
	
		
	}

