package com.yan.dubbo.wmsServiceClient;

import com.yyw.wms.client.dubbo.restApi.RfSortingRestService;

/**
 * Created by huyan on 2021/1/16.
 * TIME: 13:48
 * DESC:
 */
public class RfSortingRestTestService extends BaseTestService {

    public static void main(String[] args) {
        RfSortingRestService rfSortingRestService = getBean(RfSortingRestService.class, "rfSortingRestService");
        String result = rfSortingRestService.checkSortingBin("001");
        System.out.println(result);
    }
}
