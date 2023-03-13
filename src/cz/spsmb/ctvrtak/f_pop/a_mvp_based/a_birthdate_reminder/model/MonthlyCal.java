package cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder.model;

import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class MonthlyCal extends GridPane  {
    private HumanRepository humanRepository;

    public MonthlyCal(int year, int month, HumanRepository humanRepository) {
        super();
        this.humanRepository = humanRepository;

        for (DayOfWeek dow:DayOfWeek.values()
        ) {
            this.add(new Label(dow.getDisplayName(TextStyle.SHORT, new Locale("cs", "CZ"))+" "), dow.getValue(), 0);
        }

        LocalDate ld = LocalDate.of(year, month, 1);
        int rowCount = 1;
        int weekCount = isFirstWeekZero(year) ? 0 : 1;
        if (month > 1) weekCount += (LocalDate.of(year, 1, 1).getDayOfWeek().getValue() - 1 + ld.getDayOfYear()) / 7;
        while (ld.getMonth().getValue() == month) {
            Label l = new Label(Integer.toString(ld.getDayOfMonth())+" ");
            l.setStyle("-fx-font-size: 20;");
            LocalDate finalLd = ld;
            l.setOnMouseEntered(e -> {
                StringBuilder sb = new StringBuilder();
                for (Human h : humanRepository.getAll()) {
                    if (h.getBirthdate().getMonth().getValue() == month && h.getBirthdate().getDayOfMonth() == finalLd.getDayOfMonth()) {
                        int bir_date = year - h.getBirthdate().getYear();
                        sb.append(h.getFirstName() + " "+ h.getSecondName() + " " + bir_date).append("\n");
                    }
                }
                if (sb.length() > 0) {
                    Tooltip tooltip = new Tooltip(sb.toString());
                    l.setTooltip(tooltip);
                }
            });


            for (Human h : humanRepository.getAll()) {
                if (h.getBirthdate().getMonth().getValue() == month && h.getBirthdate().getDayOfMonth() == ld.getDayOfMonth()) {
                    l.setStyle("-fx-background-color: yellow; -fx-font-size: 26;");
                    break;
                }
            }
            this.add(l, ld.getDayOfWeek().getValue(), rowCount);
            if (ld.getDayOfWeek() == DayOfWeek.SUNDAY) {
                this.add(new Label(Integer.toString(weekCount)), 0, rowCount);
                rowCount++;
                weekCount++;
            }
            ld = ld.plusDays(1);
        }
    }

    private boolean isFirstWeekZero(int year){
        LocalDate ld = LocalDate.of(year, 1, 1);
        for (int i = 1; i <= 4; i++) {
            if(ld.getDayOfWeek() == DayOfWeek.THURSDAY){
                return false;
            }
            ld=ld.plusDays(1);
        }
        return true;
    }
}
