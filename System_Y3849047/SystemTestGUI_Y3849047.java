//SystemTestGUI_Y3849047 for Assessment 2
//17/02/2020
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class SystemTestGUI_Y3849047 extends Application {

	//set Stage and Scenes.
	Stage window;
	Scene scene, printSystemDetailsScene, diagnoseSystemScene, setDetailsScene;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Call System_Y3849047 Class
		System_Y3849047 g=new System_Y3849047();

		//Primary Scene.
		window = primaryStage;
		window.setTitle("System_Y3849047 GUI");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//Start of Content, label giving purpose of page.
		Label label = new Label();		
		label.setText("Please pick an operation:");
		GridPane.setConstraints(label, 0, 0);
		
		//Button to print the system details, both to the GUI and to the console.
		Button prtSysDetailsBtn = new Button("Print System Details");
		//Action calls the Print System Details Scene.
		prtSysDetailsBtn.setOnAction(e -> window.setScene(printSystemDetailsScene)); //MIGHT WANT TO ADD THE DETAILS TO THE CONSOLE
		GridPane.setConstraints(prtSysDetailsBtn, 0, 1);
		
		//Button to present the System Diagnosis.
		Button diagnoseSysBtn = new Button("Diagnose System");
		//enter scene change call here
		diagnoseSysBtn.setOnAction(e -> window.setScene(diagnoseSystemScene)); //MIGHT WANT TO ADD THE DETAILS TO THE CONSOLE
		GridPane.setConstraints(diagnoseSysBtn, 0, 2);
		
		//Button to set the details of the RAM and Hard Disk Space.
		Button setDetailsBtn = new Button("Set Details");
		//enter scene change call here
		setDetailsBtn.setOnAction(e -> window.setScene(setDetailsScene));
		GridPane.setConstraints(setDetailsBtn, 0, 3);		
		
		//creating a button to quit the program.
		Button quitBtn = new Button("Quit the program");
		quitBtn.setOnAction( e -> closeProgram());
		GridPane.setConstraints(quitBtn, 0, 4);		
		
		//Add all the children to the Grid format.
		grid.getChildren().addAll(label, prtSysDetailsBtn, diagnoseSysBtn, setDetailsBtn, quitBtn);
		
		//Initiate the Scene.
		Scene scene = new Scene(grid, 500, 500);
		window.setScene(scene);
		window.show();
		
		
		
		//Contents for Print System Details scene.
		Label label1 = new Label("Make of Computer: " + g.getMake() ); 
		Label label2 = new Label( "Computer Model: " + g.getModel() ); 
		Label label3 = new Label();
		label3.setText("Processor Speed: " + g.getProcessorSpeed());
		Button backToPrimarySceneButton = new Button("Back");
		backToPrimarySceneButton.setOnAction(e -> window.setScene(scene));
		
		//Layout for Print System Details scene.
		VBox printSystemDetailsLayout = new VBox();
		printSystemDetailsLayout.setPadding(new Insets(20));
		printSystemDetailsLayout.getChildren().addAll(label1, label2, label3, backToPrimarySceneButton);
		printSystemDetailsScene = new Scene(printSystemDetailsLayout, 500, 500);
		
		
		
		//Contents for Diagnose System scene.
		Label label4 = new Label ("Hard disk size = " + g.checkHDStatus());
		Label label5 = new Label ("Memory size OK = " + g.goodMemorySize());
		Button backToPrimarySceneButton2 = new Button("Back");
		backToPrimarySceneButton2.setOnAction(e -> window.setScene(scene));

		//Layout for Diagnose System scene.
		VBox diagnoseSystemLayout = new VBox();
		diagnoseSystemLayout.setPadding(new Insets(20));
		diagnoseSystemLayout.getChildren().addAll(label4, label5, backToPrimarySceneButton2);
		diagnoseSystemScene = new Scene(diagnoseSystemLayout, 500, 500);
		
		
		
		
		//Contents for Set Details scene.
		Label label6 = new Label ("Set the computers Memory Size (MB) in the box below:");
		TextField memoryImput = new TextField("Memory of Computer");
		Label label7 = new Label ("Set the computers Hard Disk Size (GB) in the box below");
		TextField hardDiskImput = new TextField("Size of Hard Disk");
		
		Button submit = new Button ("Submit");
		submit.setOnAction(e -> {
			isInt(memoryImput, memoryImput.getText());
			isDouble(hardDiskImput, hardDiskImput.getText());
			window.setScene(scene);
		});
				
		//Layout for Set Details scene.
		VBox setDetailsLayout = new VBox();
		setDetailsLayout.setPadding(new Insets(20));
		setDetailsLayout.getChildren().addAll(label6, memoryImput, label7, hardDiskImput, submit);	
		setDetailsScene = new Scene(setDetailsLayout, 500, 500);
		}
	
	//Validate Memory Size data for Set Details.
	private boolean isInt(TextField input, String message){
        try{
    		System_Y3849047 g=new System_Y3849047();
        	int memorySize = Integer.parseInt(input.getText());
        	System.out.println("Memory of computer: " + memorySize);
        	g.setMemory(memorySize);
            g.diagnoseSystem();
            return true;
        }catch(NumberFormatException e){
            System.out.println("Error: " + message + " is not a number");
            return false;
            }
        }
	
	//Validate Hard Disk data for Set Details.
	private boolean isDouble(TextField input, String message){
        try{
    		System_Y3849047 g=new System_Y3849047();
            double hardDiskSize = Double.parseDouble(input.getText());
            g.setHardDisk(hardDiskSize);
            System.out.println("Hard Disk Size: " + hardDiskSize);
            g.diagnoseSystem();
            return true;
        }catch(NumberFormatException e){
            System.out.println("Error: " + message + " is not a number");
            return false;
            }
        }
	
	//Code to be run when closing the Program.
	private void closeProgram() {
		window.close();
	}
}