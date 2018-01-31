package com.wtown.suggest.service.impl;

import com.wtown.suggest.convert.json.JsonDataUtil;
import com.wtown.suggest.dao.ReportResultDao;
import com.wtown.suggest.entity.ReportResult;
import com.wtown.suggest.entity.dto.ResultDTO;
import com.wtown.suggest.feigh.TfsRemoteService;
import com.wtown.suggest.service.SuggestService;
import com.wtown.suggest.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SuggestServiceImpl implements SuggestService {

    public final static Logger logger = LoggerFactory.getLogger(SuggestServiceImpl.class);

    @Value("${room.tfsServer}")
    private String tfsServer;

    @Autowired
    private TfsRemoteService tfsRemoteService;

    @Autowired
    private JsonDataUtil jsonDataUtil;

    @Autowired
    private ReportResultDao dao;

    @Override
    public void submitSuggest(String description, List<MultipartFile> imgs) {
        ReportResult reportResult = new ReportResult();
        dao.insert(getReportResult(reportResult, description, imgs));
    }

    @Override
    public String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    private ReportResult getReportResult(ReportResult reportResult, String description, List<MultipartFile> imgs) {
        reportResult.setDescription(description);
        reportResult.setCreateTime(DateUtil.getInstance().getCurrentDate("yyyy-MM-dd"));
        reportResult.setIsView(0);
        reportResult.setIsDeal(0);
        String picurls = "";
        picurls = updatePic(imgs);
        reportResult.setImages(picurls);
        return reportResult;
    }

    private String updatePic(List<MultipartFile> imgs) {
        String picurls = "";
        for (int i = 0; i < imgs.size(); i++) {
            String suffix = getSuffix(imgs.get(i).getOriginalFilename());
            String result = tfsRemoteService.updatePic(imgs.get(i), suffix, 0);
            if (logger.isDebugEnabled()) {
                logger.debug("上传图片返回结果：{}", result);
            }
            //还需解析返回json字符串，并组装picurls
            try {
                ResultDTO resultDTO = jsonDataUtil.readObject(result, ResultDTO.class);
                picurls += resultDTO.getTfsFileName() + "|";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (picurls.length() > 0) {
            picurls = picurls.substring(0, picurls.length() - 1);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("上传图片组装结果：{}", picurls);
        }
        return picurls;
    }
}
