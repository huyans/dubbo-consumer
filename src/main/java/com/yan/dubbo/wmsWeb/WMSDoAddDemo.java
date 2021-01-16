package com.yan.dubbo.wmsWeb;

import com.yyw.wms.dto.WmsResponse;
import com.yyw.wms.dto.oms.DoFrozenBatchNoInfoDto;
import com.yyw.wms.dubbo.service.DoDubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Created by huyan on 2019/11/19.
 * TIME: 11:03
 * DESC:
 */
public class WMSDoAddDemo {

    public static final String FILE_NAME = "wmsWeb/do.xml";

    public static void main(String[] args) throws JAXBException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-dubbo.xml");
        ctx.start();
        try {
            DoDubboService doDubboService = (DoDubboService) ctx.getBean("doDubboService");
            WmsResponse<List<DoFrozenBatchNoInfoDto>> response = doDubboService.getMoreBatchInfoByDoNo("52013140810", 13L);
            List<DoFrozenBatchNoInfoDto> infoList = response.getData();
            System.out.println(infoList);
        } finally {
            ctx.close();
        }
    }

    private static <T> T xmlToBean(Class<T> load) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(load);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new File(buildFilePath()));
    }

    private static String buildFilePath() {
        return FILE_NAME.getClass().getResource("/" + FILE_NAME).getPath();
    }

}
