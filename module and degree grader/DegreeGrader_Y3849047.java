import java.util.*;
public class DegreeGrader_Y3849047 {
Scanner sc=new Scanner(System.in);

	public String gradeDegree(int vAllModAverage,int vISMModAverage,int vComFailedCredits,int vFailedMods)
	{
		//This method is used to assign the correct degree classification to the results provided.
		//Will probably have to change everything to have an 'In' at the end of their name.
		String result = "invalid option";
		
		if (vAllModAverage >= 50 && vISMModAverage >= 50 && vComFailedCredits <= 30) 
		{
			result = "pass";
		}
		if (vAllModAverage >= 60 && vISMModAverage >= 60 && vComFailedCredits <= 15) 
		{
			result = "merit";
		}
		if (vAllModAverage >= 70 && vISMModAverage >= 70 && vComFailedCredits <= 0) 
		{
			result = "Distinction";
		}
		if (vFailedMods > 0 || vAllModAverage < 50 || vISMModAverage <50 || vComFailedCredits > 30) 
		{
			result = "fail";
		}
		//System.out.println(result);
		return (result);
	}
	
	public int getValidModuleAverageMark()
	{
		//This method is used to validate the number that is input, making sure it is between 0-100
		int allModuleMark;
		System.out.println("Please enter the total module average. This number should be between 0-100: ");
		allModuleMark = sc.nextInt();
		while (allModuleMark < 0 || allModuleMark > 100) {
			System.out.println("This is an invalid mark.");
			System.out.println("Please enter a mark between 0-100!");
			allModuleMark = sc.nextInt();
		}
		return allModuleMark;
	}
	
	public int getValidISMModuleMark()
	{
		//This method is used to validate the number that is input, making sure it is between 0-100
		int ISMModuleMark;
		System.out.println("Please enter the ISM Module average. This number should be between 0-100: ");
		ISMModuleMark = sc.nextInt();
		while (ISMModuleMark < 0 || ISMModuleMark > 100) {
			System.out.println("This is an invalid mark.");
			System.out.println("Please enter a mark between 0-100!");
			ISMModuleMark = sc.nextInt();
		}
		return ISMModuleMark;
	}
	
	public int getValidCompensatableFailedCredits()
	{
		//This method is used to validate the number that is input, making sure it is between 0-180
		int compensatableFailedCredits;
		System.out.println("Please enter the quantity of credits that are Compensatable Fails. This number should be between 0-180: ");
		compensatableFailedCredits = sc.nextInt();
		while (compensatableFailedCredits < 0 || compensatableFailedCredits > 180) {
			System.out.println("This is an invalid mark.");
			System.out.println("Please enter a mark between 0-180!");
			compensatableFailedCredits = sc.nextInt();
		}
		return compensatableFailedCredits;
	}
	
	public int getValidOutrightFailedModules()
	{
		//This method is used to validate the number that is input, making sure it is between 0-11
		int outrightFailedModules;
		System.out.println("Please enter the total modules failed. This number should be between 0-11: ");
		outrightFailedModules = sc.nextInt();
		while (outrightFailedModules < 0 || outrightFailedModules > 11) {
			System.out.println("This is an invalid mark.");
			System.out.println("Please enter a mark between 0-11!");
			outrightFailedModules = sc.nextInt();
		}
		return outrightFailedModules;
	}
	
	public void startDegreeGrading()
	{
		char response; int vAllModAverage; int vISMModAverage;
		int vComFailedCredits; int vFailedMods; String grade;
		System.out.println("*********** Degree Classification Program *********");
		System.out.println();
		do
		{
			vAllModAverage = getValidModuleAverageMark();
			vISMModAverage = getValidISMModuleMark();
			vComFailedCredits = getValidCompensatableFailedCredits();
			vFailedMods = getValidOutrightFailedModules();
			grade = gradeDegree(vAllModAverage, vISMModAverage, vComFailedCredits, vFailedMods);
			System.out.println(grade);
			System.out.println("grade another?: (y/n)");
			response = sc.next().charAt(0);
		} while (response == 'y' || response == 'Y');
	}
	
	public static void main(String[] args) {
		
		String grade;
		DegreeGrader_Y3849047 g=new DegreeGrader_Y3849047();
		g.startDegreeGrading();
		//grade = gradeDegree();
		
	}
}