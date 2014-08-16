package myPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;  
	
import java.util.Properties;  
	  

	public class Users {  
		Properties properties;
		FileInputStream stream = null;
	  
	  
	    public Users() {  
	    	
	    	properties = new Properties();
	      
	    	try {
	    	    stream = new FileInputStream("C:/Users/vinisha/Desktop/users.properties");
	    	  
	    	    properties.load(stream);
	    	} catch (FileNotFoundException e) {
	    	    System.out.println("FileNotFound");
	    	} catch (IOException e) {
	    	    System.out.println("IOEXCeption");
	    	} finally {
	    	    if (null != stream)
	    	    {
	    	        try
	    	        {
	    	            stream.close();
	    	        }
	    	        catch (Exception e)
	    	        {
	    	            e.printStackTrace();
	    	        }
	    	    }
	    	}
	    	
	    
	    }  
	  
	    public boolean userExist(String username, String password1) {  
	    	boolean exists = false;
			String password = properties.getProperty(username);  
			System.out.println("Welcome user: " + username);
			
			
			if(password!= null && password.equals(password1))
				exists = true;
				return exists;
			
	    }  
	    
	    public void addUser(String username1, String password2){
	    	
	    	properties.setProperty(username1, password2);
	    	try {
				properties.store(new FileOutputStream("C:/Users/vinisha/Desktop/users.properties"), null);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  
	}  