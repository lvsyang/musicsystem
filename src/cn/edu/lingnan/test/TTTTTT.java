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

public class TTTTTT {
	public static void main(String[] args){
	UserDAO udao=new UserDAO();
	User u=new User();
	u.setUid("u2");
	u.setUname("kk");
	u.setUpassword("kk");
	u.setSuperuser(2);
	boolean flag=udao.updateUser(u);
    System.out.println("  5 "+flag);
	}

}
