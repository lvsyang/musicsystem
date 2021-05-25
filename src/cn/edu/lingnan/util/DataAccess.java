package cn.edu.lingnan.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
public class DataAccess {
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	private static String xmlPath="database.conf.xml";
	private static String xsdPath="database.conf.xsd";
	
  public static Connection getConnection(){
	  Connection conn=null;
	  String base = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	  xmlPath =base+"database.conf.xml";
	  xsdPath =base+"database.conf.xsd";
	  
	  
	  System.out.println("xml "+xmlPath);
	  
	  if(XmlValidator.validate(xsdPath, xmlPath)) {
		  

	    HashMap<String,String> hm=XmlParser.parser(xmlPath);
	    driver=hm.get("driver");  
	    url=hm.get("url");  
	    user=hm.get("user");  
	    password=hm.get("password");  
		try {
			Class.forName(driver);//注册驱动程序		
				conn=DriverManager.getConnection//获取连接
						(url, user,password);
		} catch (ClassNotFoundException e) {
			System.out.println("你的jar包不见了");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接参数设置错误");
				e.printStackTrace();
			} 
	  }
             return conn;
  }
  
  
  
  public static void closeConnection
  (Connection conn,Statement stat,ResultSet rs) {
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
  
  
         public static void closeConnection
         (Connection conn,Statement stat) {
        	 try {
     			
     			if(stat!=null)
     			stat.close();
     			if(conn!=null)
     		    conn.close();
     		} catch (SQLException e) {
     			e.printStackTrace();
     		}
	  
	  
	  
	  
	  
  }
         
         
         public static void closeConnection
         (Statement stat,ResultSet rs) {
        	 try {
        		    if(rs!=null)
       			rs.close();
       			if(stat!=null)
       			stat.close();
       		} catch (SQLException e) {
       			e.printStackTrace();
       		}
         }
         
         
         
         
         
         
         public static void closeConnection
         (Connection conn,PreparedStatement prep) {
        	 try {
        		 
       			if(prep!=null)
       			prep.close();
       			if(conn!=null)
       		    conn.close();
       		} catch (SQLException e) {
       			e.printStackTrace();
       		}
         }
         
         
         
         
         
  }
 