package method.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class KiemTraDangNhap {
	public int ChucVu(String username,String password) 
	{
		int check=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		Connection con=null;
		Statement stm=null;
		ResultSet rs;	
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/csdlwebkpi","root","Preciouspro1");
			stm=con.createStatement();
			rs=stm.executeQuery("SELECT * FROM users WHERE username='"+username+"' AND pass='"+password+"'");
			if(rs.next())
            	check=rs.getInt("roleid");			
			rs=stm.executeQuery("SELECT * FROM role WHERE roleid='"+check+"'");
			
			if(rs.next())
				return rs.getInt("roleid");
		}catch(SQLException e){
			e.printStackTrace();
		}		
		return -1;		
	}
	
	public boolean checkTaiKhoan(String username,String password) 
	{
		boolean check=false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con=null;
		Statement stm=null;
		ResultSet rs;
		
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/csdlwebkpi","root","Preciouspro1");
			stm=con.createStatement();
			rs=stm.executeQuery("SELECT * FROM users WHERE username='"+username+"' AND pass='"+password+"'");
			check=rs.next();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return check;
		
        
		
		 
	}
	
}
