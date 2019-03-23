package com.asiainfo.einvoice.util;

import com.ai.common.ivalues.IBOBsStaticDataValue;
import com.ai.common.util.StaticDataUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 电子发票工具类
 *
 * @author wangcl
 */
public class EInvoiceUtil {
    private final static Log log = LogFactory.getLog(EInvoiceUtil.class);

    private final static String OPEN_ELEC_INVOICEPARAM = "OPEN_ELEC_INVOICE_PARAM";

    public static final String PUBLIC_REQ_XML = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
            "<interface xmlns=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.chinatax.gov.cn/tirip/dataspec/interfaces.xsd\" version=\"DZFP1.0\" >" +
            "<globalInfo>" +
            "<terminalCode></terminalCode>" +
            "<appId></appId>" +
            "<version></version>" +
            "<interfaceCode></interfaceCode>" +
            "<userName></userName>" +
            "<passWord></passWord>" +
            "<taxpayerId></taxpayerId>" +
            "<authorizationCode></authorizationCode>" +
            "<requestCode></requestCode>" +
            "<requestTime></requestTime>" +
            "<responseCode></responseCode>" +
            "<dataExchangeId></dataExchangeId>" +
            "</globalInfo>" +
            "<returnStateInfo>" +
            "<returnCode></returnCode>" +
            "<returnMessage></returnMessage>" +
            "</returnStateInfo>" +
            "<Data>" +
            "<dataDescription>" +
            "<zipCode></zipCode>" +
            "<encryptCode></encryptCode>" +
            "<codeType></codeType>" +
            "</dataDescription>" +
            "<content></content>" +
            "</Data>" +
            "</interface>";

    public static final String CONTENT_REQ_XML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
            "<content>" +
            "<REQUEST_FPKJXX class=\"REQUEST_FPKJXX\">" +
            "<FPKJXX_FPTXX class=\"FPKJXX_FPTXX\">" +
            "<FPQQLSH></FPQQLSH>" + //发票请求唯一流水号
            "<DSPTBM></DSPTBM>" + //平台编码
            "<NSRSBH></NSRSBH>" + //开票方识别号
            "<NSRMC></NSRMC>" + //开票方名称
            "<NSRDZDAH></NSRDZDAH>" + //开票方电子档案号
            "<SWJG_DM></SWJG_DM>" + //税务机构代码
            "<DKBZ></DKBZ>" + //代开标志
            "<PYDM></PYDM>" + //票样代码
            "<KPXM></KPXM>" + //主要开票项目
            "<BMB_BBH></BMB_BBH>" + //编码表版本号
            "<XHF_NSRSBH></XHF_NSRSBH>" + //销货方识别号
            "<XHFMC></XHFMC>" + //销货方名称
            "<XHF_DZ></XHF_DZ>" + //销货方地址
            "<XHF_DH></XHF_DH>" + //销货方电话
            "<XHF_YHZH></XHF_YHZH>" + //销货方银行账号
            "<GHFMC></GHFMC>" + //购货方名称
            "<GHF_NSRSBH></GHF_NSRSBH>" + //购货方识别号
            "<GHF_SF></GHF_SF>" + //购货方省份
            "<GHF_DZ></GHF_DZ>" + //购货方地址
            "<GHF_GDDH></GHF_GDDH>" + //购货方固定电话
            "<GHF_SJ></GHF_SJ>" + //购货方手机
            "<GHF_EMAIL></GHF_EMAIL>" + //购货方邮箱
            "<GHFQYLX></GHFQYLX>" + //购货方企业类型
            "<GHF_YHZH></GHF_YHZH>" + //购货方银行账号
            "<HY_DM></HY_DM>" + //行业代码
            "<HY_MC></HY_MC>" + //行业名称
            "<KPY></KPY>" + //开票员
            "<SKY></SKY>" + //收款员
            "<FHR></FHR>" + //复核人
            "<KPRQ></KPRQ>" + //开票日期
            "<KPLX></KPLX>" + //开票类型
            "<YFP_DM></YFP_DM>" + //原发票代码
            "<YFP_HM></YFP_HM>" + //原发票号码
            "<CZDM></CZDM>" + //操作代码
            "<CHYY></CHYY>" + //冲红原因
            "<TSCHBZ></TSCHBZ>" + //特殊冲红标志
            "<KPHJJE></KPHJJE>" + //价税合计金额
            "<HJBHSJE></HJBHSJE>" + //合计不含税金额
            "<HJSE></HJSE>" + //合计税额
            "<BZ></BZ>" + //备注
            "<BYZD1></BYZD1>" + //备用字段
            "<BYZD2></BYZD2>" + //备用字段
            "<BYZD3></BYZD3>" + //备用字段
            "<BYZD4></BYZD4>" + //备用字段
            "<BYZD5></BYZD5>" + //备用字段
            "</FPKJXX_FPTXX>" +

            "<FPKJXX_XMXXS class=\"FPKJXX_XMXX;\" size=\"\">" +
            "</FPKJXX_XMXXS>" +


            "<FPKJXX_DDXX class=\"FPKJXX_DDXX\">" +
            "<DDH></DDH>" + //订单号
            "<THDH></THDH>" + //退货单号
            "<DDDATE></DDDATE>" + //订单时间
            "</FPKJXX_DDXX>" +

            "<FPKJXX_DDMXXXS class=\"FPKJXX_DDMXXX;\" size=\"0\">" +
            "<FPKJXX_DDMXXX>" +
            "<DDMC></DDMC>" + //订单名称
            "<DW></DW>" + //单位
            "<GGXH></GGXH>" + //规格型号
            "<SL></SL>" + //数量
            "<DJ></DJ>" + //单价
            "<JE></JE>" + //金额
            "<BYZD1></BYZD1>" + //备用字段1
            "<BYZD2></BYZD2>" + //备用字段2
            "<BYZD3></BYZD3>" + //备用字段3
            "<BYZD4></BYZD4>" + //备用字段4
            "<BYZD5></BYZD5>" + //备用字段5
            "</FPKJXX_DDMXXX>" +
            "</FPKJXX_DDMXXXS>" +

            "<FPKJXX_ZFXX class=\"FPKJXX_ZFXX\">" +
            "<ZFFS></ZFFS>" + //支付方式
            "<ZFLSH></ZFLSH>" + //支付流水号
            "<ZFPT></ZFPT>" + //支付平台
            "</FPKJXX_ZFXX>" +

            "<FPKJXX_WLXX class=\"FPKJXX_WLXX\">" +
            "<CYGS></CYGS>" + //承运公司
            "<SHSJ></SHSJ>" + //送货时间
            "<WLDH></WLDH>" + //物流单号
            "<SHDZ></SHDZ>" + //送货地址
            "</FPKJXX_WLXX>" +

            "</REQUEST_FPKJXX>" +
            "</content>";

    public static final String XMXX_REQ_XML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
            "<FPKJXX_XMXX>" +
            "<XMMC></XMMC>" + //项目名称
            "<XMDW></XMDW>" + //项目单位
            "<GGXH></GGXH>" + //规格型号
            "<XMSL></XMSL>" + //项目数量
            "<HSBZ></HSBZ>" + //含税标志
            "<XMDJ></XMDJ>" + //项目单价
            "<SPBM></SPBM>" + //商品编码
            "<ZXBM></ZXBM>" + //自行编码
            "<YHZCBS></YHZCBS>" + //优惠政策标识
            "<LSLBS></LSLBS>" + //零税率标识
            "<ZZSTSGL></ZZSTSGL>" + //增值税特殊管理
            "<XMJE></XMJE>" + //项目金额
            "<SL></SL>" + //税率
            "<SE></SE>" + //税额
            "<BYZD1></BYZD1>" + //备用字段1
            "<BYZD2></BYZD2>" + //备用字段2
            "<BYZD3></BYZD3>" + //备用字段3
            "<BYZD4></BYZD4>" + //备用字段4
            "<BYZD5></BYZD5>" + //备用字段5
            "</FPKJXX_XMXX>";


    /**
     * 根据XML内容组装DOC
     *
     * @param xmlText
     * @return
     * @throws Exception
     */
    public static Document getXML(String xmlText) throws Exception {
        Document doc = DocumentHelper.parseText(xmlText);
        return doc;
    }

    /**
     * 设定指定节点的文本值
     *
     * @param doc
     * @param xpath   xxx.xxx 的格式获取
     * @param content
     * @throws Exception
     */
    public static void setNoteContent(Document doc, String xpath, String content) throws Exception {
        String newPath = "//" + xpath.replaceAll("\\.", "/");
        Element ele = (Element) doc.selectSingleNode(newPath);
        ele.setText(content);
    }

    /**
     * 获得element
     *
     * @param doc
     * @param xpath   xxx.xxx 的格式获取
     * @param content
     * @throws Exception
     */
    public static Element getElementNote(Document doc, String xpath) throws Exception {
        String newPath = "//" + xpath.replaceAll("\\.", "/");
        Element ele = (Element) doc.selectSingleNode(newPath);
        return ele;
    }

    /**
     * 设置attribute
     *
     * @param doc
     * @param xpath xxx.xxx 的格式获取
     * @throws Exception
     */
    public static Element setElementAttr(Document doc, String xpath, String attr, String attrValue) throws Exception {
        String newPath = "//" + xpath.replaceAll("\\.", "/");
        Element ele = (Element) doc.selectSingleNode(newPath);
        ele.addAttribute(attr, attrValue);
        return ele;
    }

    /**
     * doc 转文本
     *
     * @param doc
     * @return
     * @throws Exception
     */
    public static String doc2String(Document doc, String encoding) throws Exception {
        OutputFormat format = OutputFormat.createCompactFormat(); //紧缩 不排版
        format.setEncoding(encoding);
        format.setExpandEmptyElements(true);
        StringWriter st = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(st,
                format);
        xmlWriter.write(doc);
        xmlWriter.flush();
        xmlWriter.close();
        return st.toString();
    }

    /**
     * element 转文本
     *
     * @param doc
     * @return
     * @throws Exception
     */
    public static String element2String(Element element, String encoding) throws Exception {
        OutputFormat format = OutputFormat.createCompactFormat(); //紧缩 不排版
        format.setEncoding(encoding);
        format.setExpandEmptyElements(true);
        StringWriter st = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(st,
                format);
        xmlWriter.write(element);
        xmlWriter.flush();
        xmlWriter.close();
        return st.toString();
    }


    /**
     * 获取当前指定格式的日期
     *
     * @param pattern 格式
     * @return 当前日期
     */
    public static String getNowDate(String pattern) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 获得最小到最大之间的随机数
     * @param min int
     * @param max int
     * @return int
     */
/*	public static int getRandom(int min, int max) {
       return min + (int) (Math.random() * (max - min + 1));
	 }*/

    /**
     * 获得最小到最大之间的随机数
     *
     * @param min long
     * @param max long
     * @return long
     */
    public static long getRandom(long min, long max) {
        return min + (long) (Math.random() * (max - min + 1));
    }

    /**
     * base64编码
     *
     * @param String
     * @return String
     * @throws Exception
     */
    public static String base64Encode(String source, String encoding) throws Exception {
        byte[] encodeBase64 = Base64.encodeBase64(source.getBytes(encoding));
        return new String(encodeBase64, encoding);
    }

    /**
     * base64编码
     *
     * @param byte[]
     * @return byte[]
     * @throws Exception
     */
    public static byte[] base64EncodeBytes(byte[] bytes) throws Exception {
        byte[] encodeBase64 = Base64.encodeBase64(bytes);
        return encodeBase64;
    }

    /**
     * base64解码
     *
     * @param String
     * @return String
     * @throws Exception
     */
    public static String base64Decode(String source, String encoding) throws Exception {
        byte[] decodeBase64 = Base64.decodeBase64(source.getBytes(encoding));
        return new String(decodeBase64, encoding);
    }

    /**
     * base64解码
     *
     * @param byte[]
     * @return byte[]
     * @throws Exception
     */
    public static byte[] base64DecodeBytes(String source, String encoding) throws Exception {
        return Base64.decodeBase64(source.getBytes(encoding));
    }

    /**
     * 处理double型数据，保留两位小数
     *
     * @param doubleNum
     * @return
     */
    public static String dealDouble(Double doubleNum) {
        String dealDouble = String.valueOf(doubleNum);
        try {
            DecimalFormat f = new DecimalFormat("0.00");
            dealDouble = f.format(new BigDecimal(String.valueOf(doubleNum)).setScale(2, BigDecimal.ROUND_HALF_UP));
        } catch (Exception e) {
            dealDouble = String.valueOf(doubleNum);
        }
        return dealDouble;
    }


    /**
     * 截取字段
     *
     * @param splitStr 需要截取的字符串
     * @param extract  截取长度
     * @return
     */
    public static String cutMultibyte(String splitStr, int extract) {
        try {
            byte[] bytes = splitStr.getBytes();
            //截取字节数不小于原始字节数时直接返回原字符串。注意字节数一定要用 bytes.length，用字符串的 length() 方法返回的是字符数！
            if (extract >= bytes.length) {
                return splitStr;
            } else {
                int result = 0;
                int cutLength = 0;
                //统计出在要截取的字节中有几个字节是负数
                for (int i = 0; i < extract; i++) {
                    if (bytes[i] < 0) {
                        cutLength++;
                    }
                }
                //若负数字节数是偶数，即要截取的字节数中遇到刚好是若干完整的汉字，则截取字节数不变；否则负数字节数是奇数，表示遇到的不是完整汉字，截取字节数减 1。
                if (cutLength % 2 == 0) {
                    result = extract;
                } else {
                    result = extract - 1;
                }
                String substrx = new String(bytes, 0, result);
                return substrx;
            }
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 截取字段
     *
     * @param smsContent 需要截取的字符串
     * @param cutLength  每段截取长度
     * @param maxSize    最大截取段数
     * @return
     */
    public static List<String> processMessage(String smsContent, int cutLength, int maxSize) {
        List<String> list = new ArrayList<String>();
        String cutSms = smsContent;
        String tmpContent = null;
        int cycleCount = 0;
        try {
            double times = Math.ceil((double) cutSms.getBytes().length / cutLength);//可截取的段数
            if (times > 1) {
                tmpContent = cutMultibyte(cutSms, cutLength);
                if (!StringUtils.isEmpty(tmpContent)) {
                    list.add(tmpContent);
                    cutSms = cutSms.substring(cutSms.indexOf(tmpContent) + tmpContent.length());
                }
                cycleCount++;
                while (!StringUtils.isEmpty(tmpContent) && cycleCount < maxSize) {
                    if (smsContent.indexOf(tmpContent) > -1 && !StringUtils.isEmpty(cutSms) && !StringUtils.isEmpty(tmpContent)) {
                        tmpContent = cutMultibyte(cutSms, cutLength);
                        if (cutSms.indexOf(tmpContent) > -1) {
                            cutSms = cutSms.substring(cutSms.indexOf(tmpContent) + tmpContent.length());
                        }
                    } else {
                        break;
                    }
                    if (!StringUtils.isEmpty(tmpContent)) {
                        list.add(tmpContent);//第一条内容
                    }
                    cycleCount++;
                }
            } else {
                list.add(cutSms);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
        return list;
    }

    /**
     * Gzip解压
     *
     * @param data 传入的字节数组
     * @return 解压后的字节数组
     */
    public static byte[] decompress(byte[] data) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPInputStream gis = new GZIPInputStream(bais);
        int count;
        int BUFFER = 1024;
        byte data1[] = new byte[BUFFER];
        while ((count = gis.read(data1, 0, BUFFER)) != -1) {
            baos.write(data1, 0, count);
        }
        gis.close();
        baos.flush();
        baos.close();
        bais.close();
        data = baos.toByteArray();
        return data;
    }

    /**
     * Gzip压缩
     *
     * @param data 传入的字节数组
     * @return 压缩后的字节数组
     */
    public static byte[] compress(byte[] data) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(data);
        gzip.close();
        out.close();
        return out.toByteArray();
    }

    public static String getCodeValue(String codeType) {
        try {
            IBOBsStaticDataValue[] iboBsStaticDataValues = StaticDataUtil
                    .getStaticData(codeType);
            if (iboBsStaticDataValues.length > 0) {
                return iboBsStaticDataValues[0].getCodeValue();
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public static String getElecInvoiceStatic(String key) {
        IBOBsStaticDataValue iboBsStaticDataValue = null;
        try {
            iboBsStaticDataValue = StaticDataUtil.getStaticData(OPEN_ELEC_INVOICEPARAM, key);
        } catch (Exception e) {
            return "";
        }
        if (iboBsStaticDataValue != null) {
            return iboBsStaticDataValue.getCodeDesc() == null ? "" : iboBsStaticDataValue.getCodeDesc();
        } else {
            return "";
        }
    }

    /*
     * 判断是否为数字
     * @param str 传入的字符串
     * @return 是数字返回true,否则返回false
     */
    public static boolean isNumeric(String str) {
        if (str.isEmpty()) {
            return false;
        } else {
            return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        }
    }

    /*
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */
    public static boolean isInteger(String str) {
        return StringUtils.isNumeric(str) && str.matches("^[-\\+]?[\\d]+$");
    }


    /**
     * &lt;&gt;转<>
     * by quanly
     *
     * @param doc
     * @return
     * @throws Exception
     */
    public static String replace(String str) throws Exception {
        if (str == null || "".equals(str)) {
            return str;
        }
        str = str.replace("&lt;", "<");
        str = str.replace("&gt;", ">");
        return str;
    }

    /**
     * 将文件流转换成base64编码
     * by quanly
     *
     * @return base64编码
     * @throws Exception
     */
    public static String getbase64Code(InputStream inputStream) throws Exception {
        return encodeBase64FileInputStream(inputStream);
    }

    /**
     * <p>将文件转成base64 字符串</p>
     * by quanly
     *
     * @param path 文件路径
     * @return
     * @throws Exception
     */
    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }

    /**
     * <p>将文件流转成base64 字符串</p>
     * by quanly
     *
     * @return base64字符串
     * @throws Exception
     */
    public static String encodeBase64FileInputStream(InputStream inputStream) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int len = 0;
            byte[] b = new byte[1024 * 256];
            while ((len = inputStream.read(b, 0, b.length)) != -1) {
                baos.write(b, 0, len);
            }
            byte[] buffer = baos.toByteArray();
            return new BASE64Encoder().encode(buffer);
        } catch (Exception e) {
            throw new Exception("将文件流转成base64 字符串失败！");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (baos != null) {
                baos.close();
            }
        }
    }

    /**
     * <p>将base64字符解码保存文件</p>
     * by quanly
     *
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */
    public static void decoderBase64File(String base64Code, String targetPath) throws Exception {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }

    /**
     * <p>将base64字符保存文本文件</p>
     * by quanly
     *
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */
    public static void toFile(String base64Code, String targetPath) throws Exception {
        byte[] buffer = base64Code.getBytes();
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }

    /**
     * 将Date类型转换成时间戳
     * by quanly
     *
     * @return 时间戳
     * @throws Exception
     */
    public static long getTime(Date date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return (sdf.parse(sdf.format(date))).getTime() / 1000;
    }

    /**
     * 根据时间戳+UUID方式获取16位的随机码
     * 时间戳取1970-01-01 08:00:00距离当前时间的秒数
     * by quanly
     * @return
     */
    public static String makeRandom(){
        String src = String.valueOf(System.currentTimeMillis()/1000);//得到从1970-01-01 08:00:00距离当前时间的秒数
        String uuid = String.valueOf(UUID.randomUUID());//通过UUID获取一串随机码
        uuid = uuid.substring(0, 6);//截取前6位
        String[] str = array(uuid);//将单个字符转换成数组

        //将时间戳与UUID随机码打乱排列，确保随机码的唯一性与安全性
        for(int i = 0; i < str.length; i++){
            src = insertStringInParticularPosition(src, str[i], i*2);
        }
        return src;
    }

    /**
     * 将字符串，拆分成数组
     * by quanly
     * @param str
     * @return
     */
    private static String[] array(String str){
        if(str == null || "".equals(str)){
            return null;
        }
        String[] randomCode = new String[str.length()];
        for(int i = 0; i < str.length(); i++){
            randomCode[i] = str.substring(i, i + 1);
        }
        return randomCode;
    }

    /**
     * 插位排列
     * by quanly
     * @param src 原始串
     * @param dec 要插入的内容
     * @param position 要插入的位置
     * @return
     */
    private static String insertStringInParticularPosition(String src, String dec, int position){
        StringBuffer stringBuffer = new StringBuffer(src);
        return String.valueOf(stringBuffer.insert(position, dec));
    }


}