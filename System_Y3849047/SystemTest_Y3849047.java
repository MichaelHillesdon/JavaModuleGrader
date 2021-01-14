//SystemTest_Y3849037 for Assessment 2
//17/02/2020
import java.util.*;
public class SystemTest_Y3849047 {
	
	public static void main(String[] args) {
		int iChoice;
		int memorySize;
		double hardDiskSize;
		Scanner sc=new Scanner(System.in);
		
		System_Y3849047 g=new System_Y3849047();
		// test all methods here:
		
		g.getMake();
		g.getModel();
		g.getProcessorSpeed();
		g.displayDetails();
		g.checkHDStatus();
		g.goodMemorySize();
		g.diagnoseSystem();
		g.displaySystemProperties();
		
		// start do loop for options to display.
		do
		{
		System.out.println(
				"\nChoice 1: Print System Details\n" + 
				"Choice 2: Diagnose System\n" + 
				"Choice 3: Set Details\n" + 
				"Choice 4: Quit the program\n");
		System.out.println("Please enter your answer below:");
		iChoice = sc.nextInt();
		if (iChoice==1) {
			g.displayDetails();
		}
		else if (iChoice==2){
			g.diagnoseSystem();
		}
		else if (iChoice==3){
			System.out.println("Please tell the system the size of the RAM (MB)");
			memorySize = sc.nextInt();
			g.setMemory(memorySize);
			System.out.println("Please tell the system the size of the Hard Disk (GB)");
			hardDiskSize = sc.nextDouble();
			g.setHardDisk(hardDiskSize);
		}
		} while (iChoice<4); // exits the program when imput < 4.

	}
	
}