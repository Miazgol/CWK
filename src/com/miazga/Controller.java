package com.miazga;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;

public class Controller {

    @FXML
    public Text timer;
    public TextField seconds;
    public TextField minutes;
    public TextField hours;
    private Timeline timeline;
    private int time;

    public void shutdownComputer() throws IOException {
        int hoursInt = Integer.parseInt(hours.getText());
        int minutesInt = Integer.parseInt(minutes.getText());
        int secondsInt = Integer.parseInt(seconds.getText());
        time = (hoursInt * 3600) + (minutesInt * 60) + secondsInt;
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("shutdown -s -t " + time);
        setTimer();
    }

    public void shutdownStop() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("shutdown -a");
        timeline.stop();
    }

    private void setTimer() {
        Integer STARTTIME = time;
        int timerTime = STARTTIME;
        IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
        timer.textProperty().bind(timeSeconds.asString());
        timeSeconds.set(timerTime);
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(timerTime + 1),
                        new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
    }
}
