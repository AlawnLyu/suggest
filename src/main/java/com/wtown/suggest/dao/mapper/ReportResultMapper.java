package com.wtown.suggest.dao.mapper;

import com.wtown.suggest.entity.ReportResult;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportResultMapper {

    @Insert("INSERT INTO `report_result` (" +
            "description," +
            "images," +
            "create_time," +
            "is_view," +
            "is_deal," +
            "deal_suggest," +
            "deal_time) " +
            "VALUES (" +
            "#{description}, " +
            "#{images}, " +
            "#{createTime}, " +
            "#{isView}, " +
            "#{isDeal}, " +
            "#{dealSuggest}, " +
            "#{dealTime});")
    void insert(ReportResult reportResult);
}
