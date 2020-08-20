package de.finn.simplecalculator;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label displayedText;

    @FXML
    private Button acButton;

    @FXML
    private Button plusButton, minusButton, multiplyButton, divideButton;

    private Main.Operators operator;

    private Float firstNumber, secondNumber;

    private boolean isTypingNumber = false;


    @FXML
    public void onACButtonClicked() {

        this.resetOperatorButtons();

        if (this.acButton.getText().equals("AC")) return;

        this.displayedText.setText("0");
        this.acButton.setText("AC");
        this.operator = null;
        this.firstNumber = null;
        this.secondNumber = null;
        this.isTypingNumber = false;

    }

    @FXML
    public void onEqualsButtonClicked() {

        if (this.operator == null) return;

        this.secondNumber = Float.valueOf(this.displayedText.getText().replace(",", "."));

        float result = switch (this.operator) {
            case PLUS -> this.firstNumber + this.secondNumber;
            case MINUS -> this.firstNumber - this.secondNumber;
            case MULTIPLY -> this.firstNumber * this.secondNumber;
            case DIVIDE -> this.firstNumber / this.secondNumber;
        };

        if (result % 1 != 0) {
            this.displayedText.setText(String.valueOf(result).replace(".", ","));
        } else {
            this.displayedText.setText(String.valueOf(Math.round(result)));
        }

        this.operator = null;
        this.firstNumber = null;
        this.secondNumber = null;
        this.isTypingNumber = false;

        this.resetOperatorButtons();

    }

    @FXML
    public void onPlusMinusButtonClicked() {

        if (!this.isTypingNumber) return;

        final String currentText = this.displayedText.getText();

        if (this.displayedText.getText().startsWith("-")) {
            this.displayedText.setText(this.displayedText.getText().replace("-", ""));
        } else {
            this.displayedText.setText("-" + currentText);
        }

    }

    @FXML
    public void onPercentButtonClicked() {

        if (this.firstNumber == null || !this.isTypingNumber) return;

        float secondNumber = Float.parseFloat(this.displayedText.getText().replace(",", "."));

        float percentage = this.firstNumber * (secondNumber / 100);

        if (percentage % 1 != 0) {
            this.displayedText.setText(String.valueOf(percentage).replace(".", ","));
        } else {
            this.displayedText.setText(String.valueOf(Math.round(percentage)));
        }

    }

    @FXML
    public void onDivideButtonClicked() {

        this.firstNumber = Float.valueOf(this.displayedText.getText().replace(",", "."));
        this.operator = Main.Operators.DIVIDE;
        this.isTypingNumber = false;

        this.resetOperatorButtons();
        this.divideButton.getStyleClass().remove("operatorbutton");
        this.divideButton.getStyleClass().add("operatorbutton_active");

    }

    @FXML
    public void onMultiplyButtonClicked() {

        this.firstNumber = Float.valueOf(this.displayedText.getText().replace(",", "."));
        this.operator = Main.Operators.MULTIPLY;
        this.isTypingNumber = false;

        this.resetOperatorButtons();
        this.multiplyButton.getStyleClass().remove("operatorbutton");
        this.multiplyButton.getStyleClass().add("operatorbutton_active");

    }

    @FXML
    public void onMinusButtonClicked() {

        this.firstNumber = Float.valueOf(this.displayedText.getText().replace(",", "."));
        this.operator = Main.Operators.MINUS;
        this.isTypingNumber = false;

        this.resetOperatorButtons();
        this.minusButton.getStyleClass().remove("operatorbutton");
        this.minusButton.getStyleClass().add("operatorbutton_active");

    }

    @FXML
    public void onPlusButtonClicked() {

        this.firstNumber = Float.valueOf(this.displayedText.getText().replace(",", "."));
        this.operator = Main.Operators.PLUS;
        this.isTypingNumber = false;

        this.resetOperatorButtons();
        this.plusButton.getStyleClass().remove("operatorbutton");
        this.plusButton.getStyleClass().add("operatorbutton_active");

    }

    @FXML
    public void onCommaButtonClicked() {

        if (!this.isTypingNumber) return;

        this.displayedText.setText(this.displayedText.getText() + ",");

    }

    @FXML
    public void onNineButtonClicked() {

        if (!this.isTypingNumber) {
            this.displayedText.setText("9");
            this.acButton.setText("C");
            this.isTypingNumber = true;
            this.resetOperatorButtons();
            return;
        }

        this.displayedText.setText(this.displayedText.getText() + "9");

    }

    @FXML
    public void onEightButtonClicked() {

        if (!this.isTypingNumber) {
            this.displayedText.setText("8");
            this.acButton.setText("C");
            this.isTypingNumber = true;
            this.resetOperatorButtons();
            return;
        }

        this.displayedText.setText(this.displayedText.getText() + "8");

    }

    @FXML
    public void onSevenButtonClicked() {

        if (!this.isTypingNumber) {
            this.displayedText.setText("7");
            this.acButton.setText("C");
            this.isTypingNumber = true;
            this.resetOperatorButtons();
            return;
        }

        this.displayedText.setText(this.displayedText.getText() + "7");

    }

    @FXML
    public void onSixButtonClicked() {

        if (!this.isTypingNumber) {
            this.displayedText.setText("6");
            this.acButton.setText("C");
            this.isTypingNumber = true;
            this.resetOperatorButtons();
            return;
        }

        this.displayedText.setText(this.displayedText.getText() + "6");

    }

    @FXML
    public void onFiveButtonClicked() {

        if (!this.isTypingNumber) {
            this.displayedText.setText("5");
            this.acButton.setText("C");
            this.isTypingNumber = true;
            this.resetOperatorButtons();
            return;
        }

        this.displayedText.setText(this.displayedText.getText() + "5");

    }

    @FXML
    public void onFourButtonClicked() {

        if (!this.isTypingNumber) {
            this.displayedText.setText("4");
            this.acButton.setText("C");
            this.isTypingNumber = true;
            this.resetOperatorButtons();
            return;
        }

        this.displayedText.setText(this.displayedText.getText() + "4");

    }

    @FXML
    public void onThreeButtonClicked() {

        if (!this.isTypingNumber) {
            this.displayedText.setText("3");
            this.acButton.setText("C");
            this.isTypingNumber = true;
            this.resetOperatorButtons();
            return;
        }

        this.displayedText.setText(this.displayedText.getText() + "3");

    }

    @FXML
    public void onTwoButtonClicked() {

        if (!this.isTypingNumber) {
            this.displayedText.setText("2");
            this.acButton.setText("C");
            this.isTypingNumber = true;
            this.resetOperatorButtons();
            return;
        }

        this.displayedText.setText(this.displayedText.getText() + "2");

    }

    @FXML
    public void onOneButtonClicked() {

        if (!this.isTypingNumber) {
            this.displayedText.setText("1");
            this.acButton.setText("C");
            this.isTypingNumber = true;
            this.resetOperatorButtons();
            return;
        }

        this.displayedText.setText(this.displayedText.getText() + "1");

    }

    @FXML
    public void onZeroButtonClicked() {

        if (!this.isTypingNumber) {
            this.displayedText.setText("0");
            this.acButton.setText("C");
            this.isTypingNumber = true;
            this.resetOperatorButtons();
            return;
        }

        this.displayedText.setText(this.displayedText.getText() + "0");

    }

    private void resetOperatorButtons() {

        this.plusButton.getStyleClass().remove("operatorbutton_active");
        this.plusButton.getStyleClass().add("operatorbutton");
        this.minusButton.getStyleClass().remove("operatorbutton_active");
        this.minusButton.getStyleClass().add("operatorbutton");
        this.multiplyButton.getStyleClass().remove("operatorbutton_active");
        this.multiplyButton.getStyleClass().add("operatorbutton");
        this.divideButton.getStyleClass().remove("operatorbutton_active");
        this.divideButton.getStyleClass().add("operatorbutton");

    }

}
