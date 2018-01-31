package com.wtown.suggest.dao.impl;

import com.wtown.suggest.dao.ReportResultDao;
import com.wtown.suggest.dao.mapper.ReportResultMapper;
import com.wtown.suggest.entity.ReportResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportResultDaoImpl implements ReportResultDao {

    @Autowired
    private ReportResultMapper mapper;

    @Override
    public void insert(ReportResult reportResult) {
        mapper.insert(reportResult);
    }
}
