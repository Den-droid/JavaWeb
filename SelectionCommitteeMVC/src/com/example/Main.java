package com.example;

import com.example.controllers.FrontController;

public class Main {
    public static void main(String[] args) {
        FrontController frontController = FrontController.getInstance();
        frontController.mainMenu();
    }
}