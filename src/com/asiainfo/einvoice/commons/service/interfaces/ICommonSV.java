package com.asiainfo.einvoice.commons.service.interfaces;

/**
 * Created by huangjh on 16/3/23.
 */
public interface ICommonSV {
    /**
     * ���ӷ�Ʊ����У��
     *
     * @param regionID  ����
     * @return true �����˵��ӷ�Ʊ false �ر��˵��ӷ�Ʊ
     * @throws Exception
     */
    public boolean checkEInvoiceSwitch(String regionID, String busi_and_fee_type) throws Exception;
}
