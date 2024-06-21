package com.example.primedivisorsfindergui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController {

    @FXML
    private TextField input;

    @FXML
    private TextArea output;

    PrimeList primeList = new PrimeList(true);
    DivisorList divisorList;
    FileHandler fileHandler = new FileHandler("SaveFile");


    @FXML
    protected void onFindButtonClick()
    {
        
        int a = Integer.parseInt(input.getText());
        if(a > 0)
        {
            divisorList = primeList.findDivisors(a);
            output.setText(divisorList.stringMaker());
        }
        else
            output.setText("Invalid input");
    }

    @FXML
    protected void onSaveButtonClick()
    {
        try
        {
            fileHandler.overwrite(primeList);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onLoadButtonClick()
    {
        try
        {
            primeList = fileHandler.loadFile();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}