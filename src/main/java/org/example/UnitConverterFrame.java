package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UnitConverterFrame extends JFrame {
    private final JComboBox<String> categoryBox;
    private final JComboBox<String> fromUnitBox;
    private final JComboBox<String> toUnitBox;
    private final JTextField inputField;
    private final JLabel resultLabel;

    public UnitConverterFrame() {
        setTitle("Unit Converter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setLayout(new GridLayout(7, 1));

        categoryBox = new JComboBox<>(new String[]{"Length", "Temperature"});
        fromUnitBox = new JComboBox<>();
        toUnitBox = new JComboBox<>();
        inputField = new JTextField();
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result: ");

        add(new JLabel("Select Category:"));
        add(categoryBox);
        add(new JLabel("Convert from:"));
        add(fromUnitBox);
        add(new JLabel("To:"));
        add(toUnitBox);
        add(new JLabel("Enter value:"));
        add(inputField);
        add(convertButton);
        add(resultLabel);

        updateUnitBoxes(); // Initial load

        // Listeners
        categoryBox.addActionListener(e -> updateUnitBoxes());

        convertButton.addActionListener(e -> handleConversion());

        setVisible(true);
    }

    private void updateUnitBoxes() {
        String category = (String) categoryBox.getSelectedItem();
        fromUnitBox.removeAllItems();
        toUnitBox.removeAllItems();

        String[] units = UnitConverterLogic.getUnitsForCategory(category);
        for (String unit : units) {
            fromUnitBox.addItem(unit);
            toUnitBox.addItem(unit);
        }
    }

    private void handleConversion() {
        try {
            double input = Double.parseDouble(inputField.getText());
            String category = (String) categoryBox.getSelectedItem();
            String from = (String) fromUnitBox.getSelectedItem();
            String to = (String) toUnitBox.getSelectedItem();

            double result = UnitConverterLogic.convert(category, from, to, input);
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number.");
        }
    }
}
