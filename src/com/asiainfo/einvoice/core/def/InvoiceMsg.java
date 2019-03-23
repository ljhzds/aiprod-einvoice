package com.asiainfo.einvoice.core.def;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangjh on 16/4/8.
 */
/**
 * @author zhanghao
 *
 */
public class InvoiceMsg {
	private long invoiceInsId;// ֻ���ڳ������ط�Ʊ�ļ�ʱ�Ż�ʹ�ø��ֶ�
	private long invoiceDefId;

	private String busiType;

	private String billId;
	private long custId;
	private long userId;
	private long acctId;
	private String soOrderId;
	private String soOrderSeria;

	private String issuingChannel;
	private String issuingType;// ��Ʊ��Ʊ���ͣ� 1�����ӷ�Ʊ�� 2��ֽ�ʷ�Ʊ��Ŀǰֻ֧��1

	private String invoiceType;
	// 1.����ͨ�û���Ʊ
	// 2.������ֵ˰��ͨ��Ʊ
	// 3.ͨ�û���Ʊ
	// 4.��ֵ˰��ͨ��Ʊ
	// 5.��ֵ˰ר�÷�Ʊ

	private String invoiceHead;// ��Ʊ̧ͷ��ʾ����Ϣ���磺���ˡ���λ�ȡ�
	private String invoiceContent;// �����߷�Ʊ�����ݣ���칫��Ʒ��ʳƷ���Ʒ��ϸ��

	private double totalAmount;
	private double totalTax;
	private double totalPrice;

	private String kpfSbh;
	private String kpfMc;
	private String kpfDzdah;

	private String xhfNsrsbh;// ��������˰��ʶ���
	private String xhfNsrmc;// ��������˰������
	private String xhfDz;// ��������ַ
	private String xhfDhhm;// �������绰
	private String xhfYhzh;// �������������˺�

	private String ghfNsrmc;// ��������˰������
	private String ghfQylx;// ��������ҵ����
	private String ghfYhzh;
	private String ghfDhhm;
	private String ghfNsrsbh;
	private String ghfDz;

	private String dkbz;// ������־

	private String kpy;// ��ƱԱ
	private String fhy;
	private String sky;

	private long createOpId;
	private long createOrgId;

	// �ֱ���Ϣ
	private String regionId;// ����
	private String countyId;// ���У������ѯ��������˰�����ʻ�ȡʱʹ�ã�

	private Map attributeMap = new HashMap();

	public long getInvoiceInsId() {
		return invoiceInsId;
	}

	public void setInvoiceInsId(long invoiceInsId) {
		this.invoiceInsId = invoiceInsId;
	}

	public long getInvoiceDefId() {
		return invoiceDefId;
	}

	public void setInvoiceDefId(long invoiceDefId) {
		this.invoiceDefId = invoiceDefId;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getAcctId() {
		return acctId;
	}

	public void setAcctId(long acctId) {
		this.acctId = acctId;
	}

	public String getSoOrderId() {
		return soOrderId;
	}

	public void setSoOrderId(String soOrderId) {
		this.soOrderId = soOrderId;
	}

	public String getSoOrderSeria() {
		return soOrderSeria;
	}

	public void setSoOrderSeria(String soOrderSeria) {
		this.soOrderSeria = soOrderSeria;
	}

	public String getIssuingChannel() {
		return issuingChannel;
	}

	public void setIssuingChannel(String issuingChannel) {
		this.issuingChannel = issuingChannel;
	}

	public String getIssuingType() {
		return issuingType;
	}

	public void setIssuingType(String issuingType) {
		this.issuingType = issuingType;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getInvoiceHead() {
		return invoiceHead;
	}

	public void setInvoiceHead(String invoiceHead) {
		this.invoiceHead = invoiceHead;
	}

	public String getInvoiceContent() {
		return invoiceContent;
	}

	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getKpfSbh() {
		return kpfSbh;
	}

	public void setKpfSbh(String kpfSbh) {
		this.kpfSbh = kpfSbh;
	}

	public String getKpfMc() {
		return kpfMc;
	}

	public void setKpfMc(String kpfMc) {
		this.kpfMc = kpfMc;
	}

	public String getKpfDzdah() {
		return kpfDzdah;
	}

	public void setKpfDzdah(String kpfDzdah) {
		this.kpfDzdah = kpfDzdah;
	}

	public String getXhfNsrsbh() {
		return xhfNsrsbh;
	}

	public void setXhfNsrsbh(String xhfNsrsbh) {
		this.xhfNsrsbh = xhfNsrsbh;
	}

	public String getXhfNsrmc() {
		return xhfNsrmc;
	}

	public void setXhfNsrmc(String xhfNsrmc) {
		this.xhfNsrmc = xhfNsrmc;
	}

	public String getXhfDz() {
		return xhfDz;
	}

	public void setXhfDz(String xhfDz) {
		this.xhfDz = xhfDz;
	}

	public String getXhfDhhm() {
		return xhfDhhm;
	}

	public void setXhfDhhm(String xhfDhhm) {
		this.xhfDhhm = xhfDhhm;
	}

	public String getXhfYhzh() {
		return xhfYhzh;
	}

	public void setXhfYhzh(String xhfYhzh) {
		this.xhfYhzh = xhfYhzh;
	}

	public String getGhfNsrmc() {
		return ghfNsrmc;
	}

	public void setGhfNsrmc(String ghfNsrmc) {
		this.ghfNsrmc = ghfNsrmc;
	}

	public String getGhfQylx() {
		return ghfQylx;
	}

	public void setGhfQylx(String ghfQylx) {
		this.ghfQylx = ghfQylx;
	}

	public String getGhfYhzh() {
		return ghfYhzh;
	}

	public void setGhfYhzh(String ghfYhzh) {
		this.ghfYhzh = ghfYhzh;
	}

	public String getGhfDhhm() {
		return ghfDhhm;
	}

	public void setGhfDhhm(String ghfDhhm) {
		this.ghfDhhm = ghfDhhm;
	}

	public String getGhfNsrsbh() {
		return ghfNsrsbh;
	}

	public void setGhfNsrsbh(String ghfNsrsbh) {
		this.ghfNsrsbh = ghfNsrsbh;
	}

	public String getGhfDz() {
		return ghfDz;
	}

	public void setGhfDz(String ghfDz) {
		this.ghfDz = ghfDz;
	}

	public String getDkbz() {
		return dkbz;
	}

	public void setDkbz(String dkbz) {
		this.dkbz = dkbz;
	}

	public String getKpy() {
		return kpy;
	}

	public void setKpy(String kpy) {
		this.kpy = kpy;
	}

	public String getFhy() {
		return fhy;
	}

	public void setFhy(String fhy) {
		this.fhy = fhy;
	}

	public String getSky() {
		return sky;
	}

	public void setSky(String sky) {
		this.sky = sky;
	}

	public long getCreateOpId() {
		return createOpId;
	}

	public void setCreateOpId(long createOpId) {
		this.createOpId = createOpId;
	}

	public long getCreateOrgId() {
		return createOrgId;
	}

	public void setCreateOrgId(long createOrgId) {
		this.createOrgId = createOrgId;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getCountyId() {
		return countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	public Map getAttributeMap() {
		return attributeMap;
	}

	public void setAttributeMap(Map attributeMap) {
		this.attributeMap = attributeMap;
	}

}
