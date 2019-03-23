package com.asiainfo.einvoice.inter.sk.interfaces;

/**
 * ����˰��ϵͳ�ӿڱ��ؿͻ��˷���
 * 
 * @author zhanghao
 *
 */
public interface ISkClientSV {

	/**
	 * ��Ʊ���߽ӿ�
	 *
	 * ˰�ؿ�Ʊ������������ַ�Ʊ�ͺ��ַ�Ʊ���ߣ���Ŀ��Ŀ���100��
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String issuingInvoice(String data) throws Exception;

	/**
	 * ��Ʊ���ӿ�
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String issuingInvoiceRed(String data) throws Exception;

	/**
	 * ��Ʊ��ѯ�ӿ�
	 * 
	 * ���ݷ�Ʊ������ˮ�Ų�ѯ˰�ؿ�Ʊ�������ķ�Ʊ���
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String queryInvoice(String data) throws Exception;
}
