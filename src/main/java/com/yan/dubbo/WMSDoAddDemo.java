package com.yan.dubbo;

import com.yyw.wms.dto.DeliveryOrderDto;
import com.yyw.wms.dto.WmsResponse;
import com.yyw.wms.dubbo.service.DoDubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by huyan on 2019/11/19.
 * TIME: 11:03
 * DESC:
 */
public class WMSDoAddDemo {

    public static final String FILE_NAME = "do.xml";

    public static void main(String[] args) throws JAXBException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-dubbo.xml");
        ctx.start();
        try {
            DoDubboService doDubboService = (DoDubboService) ctx.getBean("doDubboService");
            DeliveryOrderDto doDto = xmlToBean(DeliveryOrderDto.class);
            WmsResponse wmsResponse = doDubboService.add(doDto);
            System.out.println("DO ADD code: " + wmsResponse.getCode() + " msg: " + wmsResponse.getMessage());
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
