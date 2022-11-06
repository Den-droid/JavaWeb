package com.example.controllers;

import com.example.entities.Applicant;
import com.example.entities.User;
import com.example.enums.UserRole;
import com.example.views.MainMenu;

public class FrontController {
    private static FrontController instance;
    private final UserController userController;
    private final AdminController adminController;
    private final ApplicantController applicantController;

    private FrontController() {
        this.userController = UserController.getInstance();
        this.adminController = AdminController.getInstance();
        this.applicantController = ApplicantController.getInstance();
    }

    public static FrontController getInstance() {
        if (instance == null) {
            instance = new FrontController();
        }
        return instance;
    }

    public void mainMenu() {
        String answer;
        do {
            answer = MainMenu.getAnswer();
            switch (answer) {
                case "1":
                    User user = userController.login();
                    if (user != null) {
                        if (user.getRole().equals(UserRole.ADMIN))
                            adminController.mainMenu(user);
                        else {
                            Applicant applicant = applicantController.getApplicantByUserId(user.getId());
                            applicantController.mainMenu(applicant);
                        }
                    }
                    break;
                case "2":
                    userController.register();
                    break;
                case "3":
                    userController.sortFaculties();
                    break;
                case "4":
                    break;
            }
        } while (!answer.equals("4"));
    }
}
