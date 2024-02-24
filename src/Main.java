import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	
	private Label label_url, label_status;
	private TextField text_url;
	private TextArea txtarea_status;
	private Button btn_start;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Log.log(LogType.INFO, "Fuzzer started.");

		//Init GUI
		Scene scene = initGUI();
		
		//Init actions
		initListeners();
		
		//Launch Window
		stage.setTitle("Fuzzer");
		stage.setScene(scene);
		stage.setWidth(600);
		stage.setHeight(300);
		stage.show();
	}
	
	private void initListeners() {
		//Start fuzzing button
		
		btn_start.setOnAction(event -> {
			//Get form
			String url = text_url.getText();
			
			//Log action
			Log.log(LogType.INFO, "Init fuzz on URL " + url);
			
			//VALIDATE
			if(!Valid.url(url)) {
				Log.log(LogType.ERROR, "cannot fuzz not a URL- " + url);
				return;
			}
			
			//Log action
			Log.log(LogType.INFO, "Attempt fuzz on " + url);
			
			Crawl crawl = new Crawl(url);
			crawl.init();
			
		});
	}

	private Scene initGUI() {
		// 
		//FORM
		label_url = new Label("URL");
		text_url = new TextField();
		VBox form = new VBox(label_url, text_url);
		form.setPadding(new Insets(10));
		form.minWidth(300);
		
		
		//ACTIONS
		btn_start = new Button("Start");
		VBox action = new VBox(btn_start);
		action.setPadding(new Insets(25));
		action.setAlignment(Pos.CENTER);
		action.setMaxWidth(300);
		action.setMinWidth(300);
		
		
		//STATUS
		label_status = new Label("Status");
		txtarea_status = new TextArea();
		VBox status = new VBox(label_status, txtarea_status);
		status.setPadding(new Insets(10));
		status.setMaxWidth(300);
		status.setMinWidth(300);
		
		//MAIN CONTAINER
		BorderPane bp = new BorderPane();
		bp.setCenter(form);
		bp.setBottom(action);
		bp.setRight(status);
		
		return new Scene(bp);
	}

}