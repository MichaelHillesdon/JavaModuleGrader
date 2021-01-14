//System_Y3849047 Class File for Assessment 2
//17/02/2020
import java.util.*;
public class System_Y3849047 {
	Scanner sc=new Scanner(System.in);

	private String make;
	private String model;
	private int speed;
	private int memorySize; //in MB
	private double hardDiskSize; //in GB
	private double purchaseCost;

	public void SystemY3849047(String make, String model, int processorSpeed) {
		//constructor initialises the make, model and processor speed of the system
		
		make = getMake();
		model = getModel();
		speed = getProcessorSpeed();
		
	}
	
	public void setMemory(int memorySizeIn) {
		//Set RAM Size.
		memorySize = memorySizeIn;
		System.out.println("RAM is " + memorySize + "MB");
	}
	
	public void setHardDisk(double hardDiskSizeIn) {
		//Set Hard Disk Size
		hardDiskSize = hardDiskSizeIn;
		System.out.println("Hard Disk is " + hardDiskSize + "GB");
	}
	
	public double setPurchaseCost(double purchaseCost) {
		//methods to set corresponding attributes
		purchaseCost = 200;
		return purchaseCost;
	}
	
	public String getMake() {
		//Set the make of the computer.
		make = "DELL";
		return make;
	}
	
	public String getModel() {
		//Set the model of the computer.
		model = "Inspiron 15-3000";
		return model;
	}
	
	public int getProcessorSpeed() {
		//methods to return attribute values
		speed = 20;
		return speed;
	}
	
	public void displayDetails() {
		//Displays all the details of the system to the terminal
		System.out.println("Make of System: " + getMake());
		System.out.println("Model of System: " + getModel());
		System.out.println("Processor Speed: " + getProcessorSpeed());
	}
	
	public String checkHDStatus() {
		//Method checks if hard disk is below 2GB, if so, return "low" otherwise "OK"
		String HDStatus = "Not Valid";
		if (hardDiskSize < 2.0 ) {
			HDStatus = "low";
		}
		else if (hardDiskSize >= 2.0) {
			HDStatus = "OK";
		}
		System.out.println(HDStatus);
		return HDStatus;
	}
	
	public boolean goodMemorySize() {
		//checks if RAM is below 128MB, if so then returns false, otherwise true.
		boolean goodMemory = false;
		if (memorySize >= 128.0){
			goodMemory = true;
		}
		else if (memorySize < 128.0) {
			goodMemory = false;
		}
		return goodMemory;
	}
	
	public void diagnoseSystem() {
		//This method checks both the checkHDStatus() and goodMemorySize() methods and displays them to the terminal.
		System.out.println("Hard disk size = " + checkHDStatus());
		System.out.println("Memory size OK = " + goodMemorySize());
	}

	public void displaySystemProperties() {
		//Output the local System Properties into the console.
		String osArch; String osName; String osSystemVersion; String userAccountName; String javaVersion;
		
		osArch = System.getProperty("os.arch");
		System.out.println("Operating System Architecture: " + osArch);
		
		osName = System.getProperty("os.name");
		if(osName.equals("Windows 10") == true) {
			System.out.println("Operating System Name: " + osName + ", This is a good thing!");
		}
		else if(osName.equals("Linux") == true) {
			System.out.println("Operating System Name: " + osName + ", This is a bad thing!");
		}
		else {
			System.out.println("Operating System Name: " + osName + ", This is neither good nor bad!");
		}

		osSystemVersion = System.getProperty("os.version");
		System.out.println("Operating System Version: " + osSystemVersion);
		userAccountName = System.getProperty("user.name");
		System.out.println("User Account Name: " + userAccountName);
		javaVersion = System.getProperty("java.version");
		System.out.println("Version of Java: " + javaVersion);
	}
	
}