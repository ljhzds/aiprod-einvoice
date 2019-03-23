package com.asiainfo.einvoice.inter.sk.interfaces;

/**
 * 航信税控系统接口本地客户端服务
 * 
 * @author zhanghao
 *
 */
public interface ISkClientSV {

	/**
	 * 发票开具接口
	 *
	 * 税控开票服务器完成蓝字发票和红字发票开具，项目条目最大100条
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String issuingInvoice(String data) throws Exception;

	/**
	 * 发票冲红接口
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String issuingInvoiceRed(String data) throws Exception;

	/**
	 * 发票查询接口
	 * 
	 * 根据发票请求流水号查询税控开票服务器的发票结果
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String queryInvoice(String data) throws Exception;
}
