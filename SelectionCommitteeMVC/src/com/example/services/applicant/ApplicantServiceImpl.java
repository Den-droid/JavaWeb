package com.example.services.applicant;

import com.example.dao.applicant.ApplicantDao;
import com.example.dao.applicant.ApplicantDaoImpl;
import com.example.dao.user.UserDao;
import com.example.dao.user.UserDaoImpl;
import com.example.entities.Applicant;
import com.example.entities.User;
import com.example.models.RegisterModel;

import java.sql.SQLException;

public class ApplicantServiceImpl implements ApplicantService {
    private final ApplicantDao applicantDao;
    private final UserDao userDao;

    public ApplicantServiceImpl() {
        this.applicantDao = new ApplicantDaoImpl();
        this.userDao = new UserDaoImpl();
    }

    @Override
    public void register(RegisterModel model) throws SQLException {
        String name = model.getName();
        int age = model.getAge();
        String email = model.getEmail();
        String phoneNumber = model.getPhoneNumber();
        String town = model.getTown();
        String region = model.getRegion();
        String schoolName = model.getSchoolName();
        String login = model.getLogin();
        User user = userDao.getByLogin(login);
        applicantDao.add(new Applicant(user.getId(), name, age, email,
                phoneNumber, town, region, schoolName));
    }

    @Override
    public Applicant getByUserId(int userId) throws SQLException {
        return applicantDao.getByUserId(userId);
    }
}
