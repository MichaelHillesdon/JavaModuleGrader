//Author Michael Hillesdon
//Module Grader
//22/01/2020
import java.util.*;
public class ModuleGrader_Y3849047 {
Scanner sc=new Scanner(System.in);

	public String gradeModule(int vMarkIn)
	{
		//This method is used to take a number and assign a grade to it.
		if (vMarkIn > 69) 
		{
        return ("Excellent");
		}
			else if (vMarkIn > 59 && vMarkIn <70 ) 
			{
				return ("Good");
			}
			else if (vMarkIn > 49 && vMarkIn < 60) 
			{
				return ("Satisfactory");
			}
			else if (vMarkIn > 39 && vMarkIn < 50)
			{
				return ("Compensatable fail");
			}
			else
          {
            return("Outright fail");
          }
      }

	public int getValidModuleMark()
	{
		//This method is used to validate the number that is input, making sure it is between 0-100
		int mark;
		System.out.println("Please enter a mark between 0-100: ");
		mark = sc.nextInt();
		while (mark < 0 || mark > 100) {
			System.out.println("This is an invalid mark.");
			System.out.println("Please enter a mark between 0-100!");
			mark = sc.nextInt();
		}
		return mark;
	}
	
	public void startModuleGrading()
	{
		char response; int vMark; String grade;
		System.out.println("*********** Module Grading Program *********");
		System.out.println();
		do
		{
			vMark = getValidModuleMark();
			grade = gradeModule(vMark);
			System.out.println(grade);
			System.out.println("grade another?: (y/n)");
			response = sc.next().charAt(0);
		} while (response == 'y' || response == 'Y');
	}
}