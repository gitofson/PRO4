package cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder;

import cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder.model.HumanRepository;
import cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder.model.Human;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class BrView extends Application {

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    private HumanRepository model = context.getBean("humanRepo", HumanRepository.class);
    private LocalDate date;
    private BorderPane mainBp = new BorderPane();
    private DatePicker dp = new DatePicker();
    private Scene scene = new Scene(mainBp);
    private TextFlow tf = new TextFlow();

    @Override
    public void start(Stage stage) throws Exception {
        this.mainBp.setMinSize(500, 700);
        this.date = LocalDate.now();
        this.dp.setValue(this.date);
        this.mainBp.setTop(this.dp);
        this.mainBp.setCenter(this.tf);

        //this.customizeDp();
        /*for (Human h : model.getAll()) {
            for (int i = 0; i <= 7; i++){
                this.tf.getChildren().add(new Text(h.getFirstName() + " " + h.getSecondName() + String.format("(%s)", h.getBirthdate())));
            this.tf.getChildren().add(new Text("\n"));
            }
        }*/

        setHandlers();
        stage.setScene(this.scene);
        stage.show();

    }
    public void setHandlers(){
        this.dp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BrView.this.tf.getChildren().clear();
                BrView.this.date = BrView.this.dp.getValue();
                for (int i = 0; i <= 7; i++){
                    LocalDate tmp = BrView.this.date.plusDays(i);
                    BrView.this.tf.getChildren().add(new Text("\n" + tmp.getDayOfWeek() + " " + tmp + " "));
                    for (Human h : model.getAll()){
                        if (h.getBirthdate().getMonth() == tmp.getMonth() && h.getBirthdate().getDayOfMonth() == tmp.getDayOfMonth()){
                            int vek = tmp.getYear() - h.getBirthdate().getYear();
                            BrView.this.tf.getChildren().add(new Text(h.getFirstName() + " " + h.getSecondName() + " - slaví " + vek + "té narozeniny"));

                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

