package com.example.services.facultyCoefficient;

import com.example.dao.facultyCoefficient.FacultyCoefficientDao;
import com.example.dao.facultyCoefficient.FacultyCoefficientDaoImpl;
import com.example.entities.FacultyCoefficient;

import java.sql.SQLException;
import java.util.List;

public class FacultyCoefficientServiceImpl implements FacultyCoefficientService {
    private final FacultyCoefficientDao dao;

    public FacultyCoefficientServiceImpl() {
        this.dao = new FacultyCoefficientDaoImpl();
    }

    @Override
    public void addList(List<FacultyCoefficient> coefficients) throws SQLException {
        dao.addCoefficients(coefficients);
    }

    @Override
    public void deleteByFacultyId(int facultyId) throws SQLException {
        dao.deleteCoefficientsByFacultyId(facultyId);
    }

    @Override
    public List<FacultyCoefficient> getByFacultyId(int facultyId) throws SQLException {
        return dao.getByFacultyId(facultyId);
    }
}
