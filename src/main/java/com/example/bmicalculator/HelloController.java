package com.example.bmicalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class HelloController
{

    @FXML
    private Label resultLabel;

    @FXML
    private Label resultLabelEnglish;

    @FXML
    private TextField weightInput;
    
    @FXML
    private TextField heightInput;

    @FXML
    private TextField weightInputLbs;

    @FXML
    private TextField heightInputInch;

    @FXML
    AnchorPane metricUnitsPane = new AnchorPane();

    @FXML
    AnchorPane englishUnitsPane = new AnchorPane();

    @FXML
    AnchorPane helpPane = new AnchorPane();

    @FXML
    AnchorPane exitPane = new AnchorPane();


    @FXML
    protected void onExitPane()
    {
        javafx.application.Platform.exit();
    }

    @FXML
    protected void onMetricUnits()
    {
        metricUnitsPane.setVisible(true);
        englishUnitsPane.setVisible(false);
        helpPane.setVisible(false);
    }

    @FXML
    protected void onEnglishUnits()
    {
        englishUnitsPane.setVisible(true);
        metricUnitsPane.setVisible(false);
        helpPane.setVisible(false);
    }

    @FXML
    protected void onHelpTab()
    {
        helpPane.setVisible(true);
        englishUnitsPane.setVisible(false);
        metricUnitsPane.setVisible(false);
    }

    @FXML
    protected void onCalcButton()
    {
        try
        {
            double weight = Double.parseDouble(weightInput.getText());
            double height = Double.parseDouble(heightInput.getText());
            height /= 100;
            double result = weight / (height * height);

            if(result >= 30)
            {
                resultLabel.setText("BMI: Obese");
                resultLabel.setVisible(true);
            }
            else if(result >= 25 && result <= 29.9)
            {
                resultLabel.setText("BMI: Overweight");
                resultLabel.setVisible(true);
            }
            else if(result >= 18.5 && result <= 24.9)
            {
                resultLabel.setText("BMI: Normal");
                resultLabel.setVisible(true);
            }
            else if(result < 18.5 )
            {
                resultLabel.setText("BMI: Underweight");
                resultLabel.setVisible(true);
            }


        }
        catch (NumberFormatException e)
        {
            resultLabel.setText("Invalid input. Please, enter numeric values.");
            heightInput.setText("");
            weightInput.setText("");
        }
    }

    @FXML
    protected void onClearClick()
    {
        heightInput.setText("");
        weightInput.setText("");
        resultLabel.setVisible(false);
    }

    @FXML
    protected void onCalcButtonEnglish()
    {
        try
        {
            double weightLbs = Double.parseDouble(weightInputLbs.getText());
            double heightInch = Double.parseDouble(heightInputInch.getText());
            double resultEnglish = 703 * weightLbs / (heightInch * heightInch);

            if(resultEnglish >= 30)
            {
                resultLabelEnglish.setText("BMI: Obese");
                resultLabelEnglish.setVisible(true);
            }
            else if(resultEnglish >= 25 && resultEnglish <= 29.9)
            {
                resultLabelEnglish.setText("BMI: Overweight");
                resultLabelEnglish.setVisible(true);
            }
            else if(resultEnglish >= 18.5 && resultEnglish <= 24.9)
            {
                resultLabelEnglish.setText("BMI: Normal");
                resultLabelEnglish.setVisible(true);
            }
            else if(resultEnglish < 18.5)
            {
                resultLabelEnglish.setText("BMI: Underweight");
                resultLabelEnglish.setVisible(true);
            }
        }
        catch (NumberFormatException e)
        {
            resultLabelEnglish.setText("Invalid input. Please, enter numeric values.");
        }
    }

    @FXML
    protected void onClearClickEnglish()
    {
        heightInputInch.setText("");
        weightInputLbs.setText("");
        resultLabelEnglish.setVisible(false);
    }

}