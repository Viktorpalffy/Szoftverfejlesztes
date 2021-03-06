package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.Random;
import javafx.stage.Stage;
import numberguessinggame.results.GameResult;
import numberguessinggame.results.GameResultDao;
import validator.GuessValidator;

public class GameController{
    private final Random random = new Random();
    private int randomNumber;
    private int guessCount = 0;
    private String userName;
    private GameResultDao gameResultDao;
    @FXML
    private Label usernameLabel;
    @FXML
    private TextField guess;
    @FXML
    private Text guessCounterText;
    @FXML
    private ImageView upArrow;
    @FXML
    private ImageView downArrow;
    @FXML
    private ImageView correct;
    @FXML
    private Button toptiz;
    @FXML
    private Button ujra;




    public void initdata(String userName) {
        this.userName = userName;
        usernameLabel.setText("Jatekos: " + this.userName);
    }

    @FXML
    public void initialize() {
        gameResultDao = GameResultDao.getInstance();
        randomNumber = random.nextInt(100);
        System.out.println(randomNumber);
        downArrow.setVisible(false);
        upArrow.setVisible(false);
        correct.setVisible(false);
    }
    private GameResult getResult() {
        GameResult result = GameResult.builder()
                .player(userName)
                .guessCount(guessCount)
                .build();

        return result;
    }
    @FXML
    void checkGuess(ActionEvent event) {
        boolean valid = GuessValidator.validate(guess.getText());
        if (valid) {
            if (Integer.parseInt(guess.getText()) == randomNumber) {
                downArrow.setVisible(false);
                upArrow.setVisible(false);
                correct.setVisible(true);
                ujra.setVisible(false);
                toptiz.setVisible(true);


            } else if (Integer.parseInt(guess.getText()) > randomNumber) {
                downArrow.setVisible(true);
                upArrow.setVisible(false);
                correct.setVisible(false);
            } else if (Integer.parseInt(guess.getText()) < randomNumber) {
                downArrow.setVisible(false);
                upArrow.setVisible(true);
                correct.setVisible(false);
            }

            guess.setText("");
            guessCount++;
            guessCounterText.setText("Probalkozasok szama: " + guessCount);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nem megfelel?? ??rt??k lett megadva!", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }
    }
    @FXML
    void reset(ActionEvent event) {
        randomNumber = random.nextInt(100);
        downArrow.setVisible(false);
        upArrow.setVisible(false);
        correct.setVisible(false);
        guessCount = 0;
        guessCounterText.setText("Probalkozasok szama: " + guessCount);
        guess.setText("");
    }
    @FXML
    void showTopTenList(ActionEvent event) throws IOException {
        gameResultDao.persist(getResult());
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/topten.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }



}


