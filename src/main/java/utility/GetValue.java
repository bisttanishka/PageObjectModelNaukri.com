package utility;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class GetValue {

/*public static void main(String[] args) throws IOException { // To check that this function is running we can use main method

System.out.println(readProperty("username"));
} //*/

//add an object of properties
 public static Properties property;// we are putting this static bcz below we have initialize under static
//Create method and make it static so that it can use without making object of the this class
 
public static void initializePropertyFile() throws IOException {

//1. Initialize Property object
	
	property=new Properties();
//2.To read Properties file we will use FileInputStream
	FileInputStream inputstream=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/configuration/configuration.properties"); // We can use InputStream inputstream=new FileInputStream() 
	property.load(inputstream);
	
}
//This is to get the value from the propertyfile which is stored inthe form of key and value
//We have to create a generic function to get the value from congiuration file by passing the key
public static String readProperty(String key) throws IOException {
	initializePropertyFile();
	 String propertyValue= property.getProperty(key); // we can write like this also ->return property.getProperty(key);
	return propertyValue;
	
	
	

}
	
	
	
	
	
}


