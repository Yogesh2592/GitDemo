package Testing;

public class TestMailConfig{


	
	public static String server="smtp.gmail.com";
	public static String from = "vyogesh25test@gmail.com";
	public static String password = "Yo@8802627555";
	public static String[] to ={"vyogesh25@gmail.com","yogesh.sharma2@conduent.com"};
	public static String subject = "Test Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath=".\\screenshot\\Sun_May_30_00_00_13_IST_2021.jpg";
	public static String attachmentName="Sun_May_30_00_00_13_IST_2021.jpg";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	public static String dbConnectionUrl="jdbc:sqlserver://localhost:1433;databaseName=Yogesh;integratedSecurity=true"; 
	public static String dbUserName="ACSIND\\52133356"; 
	public static String dbPassword="May@2021"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.cj.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "Yo@8802627555";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/30thmat2021";
	
	
	
	
	
	
	
	
	
}
