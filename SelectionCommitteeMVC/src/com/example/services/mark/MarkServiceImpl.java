package com.example.services.mark;

import com.example.dao.mark.MarkDao;
import com.example.dao.mark.MarkDaoImpl;
import com.example.entities.Mark;
import com.example.enums.MarkType;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class MarkServiceImpl implements MarkService {

    private final MarkDao dao;

    public MarkServiceImpl() {
        this.dao = new MarkDaoImpl();
    }

    @Override
    public List<Mark> getByUserId(int userId) throws SQLException {
        return dao.getByUserId(userId);
    }

    @Override
    public List<Mark> getByMarkTypeFromList(List<Mark> marks, MarkType type) {
        return marks.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public void add(Mark mark) throws SQLException {
        dao.add(mark);
    }
}
