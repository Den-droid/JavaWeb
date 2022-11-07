package com.example.services.university;

import com.example.dao.university.UniversityDao;
import com.example.dao.university.UniversityDaoImpl;
import com.example.entities.University;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class UniversityServiceImpl implements UniversityService {
    private final UniversityDao dao;

    public UniversityServiceImpl() {
        this.dao = new UniversityDaoImpl();
    }

    @Override
    public List<University> getAll() throws SQLException {
        return dao.getAll();
    }

    @Override
    public University getById(int id) throws SQLException {
        return dao.getById(id);
    }

    @Override
    public List<University> getByIds(List<Integer> ids) throws SQLException {
        return dao.getAll().stream()
                .filter(x -> ids.stream().anyMatch(y -> x.getId() == y))
                .collect(Collectors.toList());
    }

    @Override
    public University getByName(String name) throws SQLException {
        return dao.getByName(name);
    }
}
