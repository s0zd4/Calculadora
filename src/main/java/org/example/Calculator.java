package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator extends JFrame {
    private JPanel mainCalculadora;
    private JTextField txtValues;
    private JButton btnPonto;
    private JButton btnOFF;
    private JButton btnSomar;
    private JButton btn0;
    private JButton btnC;
    private JButton btn1;
    private JButton btn2;
    private JButton btnSub;
    private JButton btn7;
    private JButton btn8;
    private JButton btnDividir;
    private JButton btn4;
    private JButton btn5;
    private JButton btnMult;
    private JButton btn9;
    private JButton btn6;
    private JButton btn3;
    private JButton btnCalc;
    private JPanel JCalculadora;
    ArrayList<String> valores  = new ArrayList<>();
    String array = "";
    String nums = "";
    String valor = "";

    private void facilitador(String val){
        if (nums.isEmpty()){
            nums = val;
        }

        else{
            nums = nums + val;
            valor = valor + val;
        }
        txtValues.setText(String.valueOf(array + nums));
    }
    private void prox(String adds){
        if(nums.isEmpty() && array.isEmpty()){
        }
        else{
            valores.add(nums);
            valores.add(adds);
            array = array + nums + " "+adds+" ";
            nums = "";
            txtValues.setText(String.valueOf(array + nums));
        }
    }

    public Calculator() {
        setContentPane(mainCalculadora);
        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(290, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facilitador("0");
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facilitador("1");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facilitador("2");
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facilitador("3");
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facilitador("4");
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facilitador("5");
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facilitador("6");
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facilitador("7");
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facilitador("8");
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facilitador("9");
            }
        });
        btnPonto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nums.contains(".") || nums.isEmpty()){
                }
                else {
                    facilitador(".");
                    txtValues.setText(String.valueOf(array + nums));
                }
            }
        });
        btnDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prox("/");
            }
        });
        btnMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prox("*");
            }
        });
        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prox("-");
            }
        });
        btnSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prox("+");
            }
        });
        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valores.clear();
                array = "";
                nums = "";
                txtValues.setText(String.valueOf(nums));
            }
        });
        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valores.add(nums);
                nums = "";
                String num1, num2, valS;
                double valD = 0;
                for(int j = 0; j < valores.size()+1; j++){
                    for(int i = 0; i < valores.size(); i++){
                        if(valores.get(i).equals("*")){
                            num1 = valores.get(i-1);
                            num2 = valores.get(i+1);
                            double num3 = Double.parseDouble(num1);
                            double num4 = Double.parseDouble(num2);
                            valD = num3 * num4;
                            valS = "" + valD;
                            valores.remove(1+1);
                            valores.set(i, valS);
                            valores.remove(i-1);
                        }
                        else if(valores.get(i).equals("/")){
                            num1 = valores.get(i-1);
                            num2 = valores.get(i+1);
                            double num3 = Double.parseDouble(num1);
                            double num4 = Double.parseDouble(num2);
                            valD = num3 / num4;
                            valS = "" + valD;
                            valores.remove(1+1);
                            valores.set(i, valS);
                            valores.remove(i-1);
                        }
                    }
                }
                for(int j = 0; j < valores.size()+1; j++){
                    for(int i = 0; i < valores.size(); i++){
                        if(valores.get(i).equals("-")){
                            num1 = valores.get(i-1);
                            num2 = valores.get(i+1);
                            double num3 = Double.parseDouble(num1);
                            double num4 = Double.parseDouble(num2);
                            valD = num3 - num4;
                            valS = "" + valD;
                            valores.remove(1+1);
                            valores.set(i, valS);
                            valores.remove(i-1);
                        }
                        else if(valores.get(i).equals("+")){
                            num1 = valores.get(i-1);
                            num2 = valores.get(i+1);
                            double num3 = Double.parseDouble(num1);
                            double num4 = Double.parseDouble(num2);
                            valD = num3 + num4;
                            valS = "" + valD;
                            valores.remove(1+1);
                            valores.set(i, valS);
                            valores.remove(i-1);
                        }
                    }
                }
                array = "";
                nums = valores.getFirst();
                valores.clear();
                txtValues.setText(String.valueOf(nums));
            }
        });
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
