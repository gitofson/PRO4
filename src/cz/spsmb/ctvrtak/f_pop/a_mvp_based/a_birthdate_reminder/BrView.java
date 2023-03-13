package cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder;

import cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder.model.HumanRepository;
import cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder.model.MonthlyCal;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class BrView extends Application {

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    private HumanRepository model = context.getBean("humanRepo", HumanRepository.class);
    private LocalDate date;
    private BorderPane mainBp = new BorderPane();
    private DatePicker dp = new DatePicker();
    private Scene scene = new Scene(mainBp);
    private TextFlow tf = new TextFlow();
    private void updateYearLabel(Label yearLabel) {
        yearLabel.setText(Integer.toString(date.getYear()));
        GridPane gridPane = new GridPane();
        gridPane.setHgap(25);
        for (int i = 1; i <= 12; i++) {
            VBox vb = new VBox();
            Label lbl = new Label(Month.values()[i-1].getDisplayName(TextStyle.FULL_STANDALONE,new Locale("cs", "CZ")));
            lbl.setStyle("-fx-font-size: 18px;");
            vb.setAlignment(Pos.CENTER);
            vb.getChildren().add(lbl);
            vb.getChildren().add(new MonthlyCal(this.date.getYear(), i, model));
            gridPane.add(vb, (i - 1) % 3, (i - 1) / 3);

        }
        this.mainBp.setCenter(gridPane);

    }
    @Override
    public void start(Stage stage) throws Exception {
        this.mainBp.setMinSize(500, 700);
        this.date = LocalDate.now();
        this.dp.setValue(this.date);

        HBox bar = new HBox();
        bar.setAlignment(Pos.TOP_CENTER);

        Button back = new Button();
        Button next = new Button();
        Label yearLabel = new Label(Integer.toString(date.getYear()));

        back.setText("<");
        back.setOnAction(event -> {
            this.date = this.date.minusYears(1);
            this.dp.setValue(this.date);
            updateYearLabel(yearLabel);
        });


        next.setText(">");
        next.setOnAction(event -> {
            this.date = this.date.plusYears(1);
            this.dp.setValue(this.date);
            updateYearLabel(yearLabel);
        });
        updateYearLabel(yearLabel);
        yearLabel.setStyle("-fx-font-size: 18px;");

        Label space = new Label();
        space.setStyle("-fx-padding: 10px");
        Label space2 = new Label();
        space2.setStyle("-fx-padding: 10px");

        bar.getChildren().add(back);
        bar.getChildren().add(space);
        bar.getChildren().add(yearLabel);
        bar.getChildren().add(space2);
        bar.getChildren().add(next);

        this.mainBp.setTop(bar);

        stage.setTitle("Birthday reminder");
        stage.getIcons().add(new Image("https://itvitek.eu/img/me.png"));
        stage.setScene(this.scene);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}

