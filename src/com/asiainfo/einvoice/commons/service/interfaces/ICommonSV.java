package com.asiainfo.einvoice.commons.service.interfaces;

/**
 * Created by huangjh on 16/3/23.
 */
public interface ICommonSV {
    /**
     * 电子发票开关校验
     *
     * @param regionID  地市
     * @return true 开启了电子发票 false 关闭了电子发票
     * @throws Exception
     */
    public boolean checkEInvoiceSwitch(String regionID, String busi_and_fee_type) throws Exception;
}
