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
 * ���ӷ�Ʊ������
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
            "<FPQQLSH></FPQQLSH>" + //��Ʊ����Ψһ��ˮ��
            "<DSPTBM></DSPTBM>" + //ƽ̨����
            "<NSRSBH></NSRSBH>" + //��Ʊ��ʶ���
            "<NSRMC></NSRMC>" + //��Ʊ������
            "<NSRDZDAH></NSRDZDAH>" + //��Ʊ�����ӵ�����
            "<SWJG_DM></SWJG_DM>" + //˰���������
            "<DKBZ></DKBZ>" + //������־
            "<PYDM></PYDM>" + //Ʊ������
            "<KPXM></KPXM>" + //��Ҫ��Ʊ��Ŀ
            "<BMB_BBH></BMB_BBH>" + //�����汾��
            "<XHF_NSRSBH></XHF_NSRSBH>" + //������ʶ���
            "<XHFMC></XHFMC>" + //����������
            "<XHF_DZ></XHF_DZ>" + //��������ַ
            "<XHF_DH></XHF_DH>" + //�������绰
            "<XHF_YHZH></XHF_YHZH>" + //�����������˺�
            "<GHFMC></GHFMC>" + //����������
            "<GHF_NSRSBH></GHF_NSRSBH>" + //������ʶ���
            "<GHF_SF></GHF_SF>" + //������ʡ��
            "<GHF_DZ></GHF_DZ>" + //��������ַ
            "<GHF_GDDH></GHF_GDDH>" + //�������̶��绰
            "<GHF_SJ></GHF_SJ>" + //�������ֻ�
            "<GHF_EMAIL></GHF_EMAIL>" + //����������
            "<GHFQYLX></GHFQYLX>" + //��������ҵ����
            "<GHF_YHZH></GHF_YHZH>" + //�����������˺�
            "<HY_DM></HY_DM>" + //��ҵ����
            "<HY_MC></HY_MC>" + //��ҵ����
            "<KPY></KPY>" + //��ƱԱ
            "<SKY></SKY>" + //�տ�Ա
            "<FHR></FHR>" + //������
            "<KPRQ></KPRQ>" + //��Ʊ����
            "<KPLX></KPLX>" + //��Ʊ����
            "<YFP_DM></YFP_DM>" + //ԭ��Ʊ����
            "<YFP_HM></YFP_HM>" + //ԭ��Ʊ����
            "<CZDM></CZDM>" + //��������
            "<CHYY></CHYY>" + //���ԭ��
            "<TSCHBZ></TSCHBZ>" + //�������־
            "<KPHJJE></KPHJJE>" + //��˰�ϼƽ��
            "<HJBHSJE></HJBHSJE>" + //�ϼƲ���˰���
            "<HJSE></HJSE>" + //�ϼ�˰��
            "<BZ></BZ>" + //��ע
            "<BYZD1></BYZD1>" + //�����ֶ�
            "<BYZD2></BYZD2>" + //�����ֶ�
            "<BYZD3></BYZD3>" + //�����ֶ�
            "<BYZD4></BYZD4>" + //�����ֶ�
            "<BYZD5></BYZD5>" + //�����ֶ�
            "</FPKJXX_FPTXX>" +

            "<FPKJXX_XMXXS class=\"FPKJXX_XMXX;\" size=\"\">" +
            "</FPKJXX_XMXXS>" +


            "<FPKJXX_DDXX class=\"FPKJXX_DDXX\">" +
            "<DDH></DDH>" + //������
            "<THDH></THDH>" + //�˻�����
            "<DDDATE></DDDATE>" + //����ʱ��
            "</FPKJXX_DDXX>" +

            "<FPKJXX_DDMXXXS class=\"FPKJXX_DDMXXX;\" size=\"0\">" +
            "<FPKJXX_DDMXXX>" +
            "<DDMC></DDMC>" + //��������
            "<DW></DW>" + //��λ
            "<GGXH></GGXH>" + //����ͺ�
            "<SL></SL>" + //����
            "<DJ></DJ>" + //����
            "<JE></JE>" + //���
            "<BYZD1></BYZD1>" + //�����ֶ�1
            "<BYZD2></BYZD2>" + //�����ֶ�2
            "<BYZD3></BYZD3>" + //�����ֶ�3
            "<BYZD4></BYZD4>" + //�����ֶ�4
            "<BYZD5></BYZD5>" + //�����ֶ�5
            "</FPKJXX_DDMXXX>" +
            "</FPKJXX_DDMXXXS>" +

            "<FPKJXX_ZFXX class=\"FPKJXX_ZFXX\">" +
            "<ZFFS></ZFFS>" + //֧����ʽ
            "<ZFLSH></ZFLSH>" + //֧����ˮ��
            "<ZFPT></ZFPT>" + //֧��ƽ̨
            "</FPKJXX_ZFXX>" +

            "<FPKJXX_WLXX class=\"FPKJXX_WLXX\">" +
            "<CYGS></CYGS>" + //���˹�˾
            "<SHSJ></SHSJ>" + //�ͻ�ʱ��
            "<WLDH></WLDH>" + //��������
            "<SHDZ></SHDZ>" + //�ͻ���ַ
            "</FPKJXX_WLXX>" +

            "</REQUEST_FPKJXX>" +
            "</content>";

    public static final String XMXX_REQ_XML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
            "<FPKJXX_XMXX>" +
            "<XMMC></XMMC>" + //��Ŀ����
            "<XMDW></XMDW>" + //��Ŀ��λ
            "<GGXH></GGXH>" + //����ͺ�
            "<XMSL></XMSL>" + //��Ŀ����
            "<HSBZ></HSBZ>" + //��˰��־
            "<XMDJ></XMDJ>" + //��Ŀ����
            "<SPBM></SPBM>" + //��Ʒ����
            "<ZXBM></ZXBM>" + //���б���
            "<YHZCBS></YHZCBS>" + //�Ż����߱�ʶ
            "<LSLBS></LSLBS>" + //��˰�ʱ�ʶ
            "<ZZSTSGL></ZZSTSGL>" + //��ֵ˰�������
            "<XMJE></XMJE>" + //��Ŀ���
            "<SL></SL>" + //˰��
            "<SE></SE>" + //˰��
            "<BYZD1></BYZD1>" + //�����ֶ�1
            "<BYZD2></BYZD2>" + //�����ֶ�2
            "<BYZD3></BYZD3>" + //�����ֶ�3
            "<BYZD4></BYZD4>" + //�����ֶ�4
            "<BYZD5></BYZD5>" + //�����ֶ�5
            "</FPKJXX_XMXX>";


    /**
     * ����XML������װDOC
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
     * �趨ָ���ڵ���ı�ֵ
     *
     * @param doc
     * @param xpath   xxx.xxx �ĸ�ʽ��ȡ
     * @param content
     * @throws Exception
     */
    public static void setNoteContent(Document doc, String xpath, String content) throws Exception {
        String newPath = "//" + xpath.replaceAll("\\.", "/");
        Element ele = (Element) doc.selectSingleNode(newPath);
        ele.setText(content);
    }

    /**
     * ���element
     *
     * @param doc
     * @param xpath   xxx.xxx �ĸ�ʽ��ȡ
     * @param content
     * @throws Exception
     */
    public static Element getElementNote(Document doc, String xpath) throws Exception {
        String newPath = "//" + xpath.replaceAll("\\.", "/");
        Element ele = (Element) doc.selectSingleNode(newPath);
        return ele;
    }

    /**
     * ����attribute
     *
     * @param doc
     * @param xpath xxx.xxx �ĸ�ʽ��ȡ
     * @throws Exception
     */
    public static Element setElementAttr(Document doc, String xpath, String attr, String attrValue) throws Exception {
        String newPath = "//" + xpath.replaceAll("\\.", "/");
        Element ele = (Element) doc.selectSingleNode(newPath);
        ele.addAttribute(attr, attrValue);
        return ele;
    }

    /**
     * doc ת�ı�
     *
     * @param doc
     * @return
     * @throws Exception
     */
    public static String doc2String(Document doc, String encoding) throws Exception {
        OutputFormat format = OutputFormat.createCompactFormat(); //���� ���Ű�
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
     * element ת�ı�
     *
     * @param doc
     * @return
     * @throws Exception
     */
    public static String element2String(Element element, String encoding) throws Exception {
        OutputFormat format = OutputFormat.createCompactFormat(); //���� ���Ű�
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
     * ��ȡ��ǰָ����ʽ������
     *
     * @param pattern ��ʽ
     * @return ��ǰ����
     */
    public static String getNowDate(String pattern) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * �����С�����֮��������
     * @param min int
     * @param max int
     * @return int
     */
/*	public static int getRandom(int min, int max) {
       return min + (int) (Math.random() * (max - min + 1));
	 }*/

    /**
     * �����С�����֮��������
     *
     * @param min long
     * @param max long
     * @return long
     */
    public static long getRandom(long min, long max) {
        return min + (long) (Math.random() * (max - min + 1));
    }

    /**
     * base64����
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
     * base64����
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
     * base64����
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
     * base64����
     *
     * @param byte[]
     * @return byte[]
     * @throws Exception
     */
    public static byte[] base64DecodeBytes(String source, String encoding) throws Exception {
        return Base64.decodeBase64(source.getBytes(encoding));
    }

    /**
     * ����double�����ݣ�������λС��
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
     * ��ȡ�ֶ�
     *
     * @param splitStr ��Ҫ��ȡ���ַ���
     * @param extract  ��ȡ����
     * @return
     */
    public static String cutMultibyte(String splitStr, int extract) {
        try {
            byte[] bytes = splitStr.getBytes();
            //��ȡ�ֽ�����С��ԭʼ�ֽ���ʱֱ�ӷ���ԭ�ַ�����ע���ֽ���һ��Ҫ�� bytes.length�����ַ����� length() �������ص����ַ�����
            if (extract >= bytes.length) {
                return splitStr;
            } else {
                int result = 0;
                int cutLength = 0;
                //ͳ�Ƴ���Ҫ��ȡ���ֽ����м����ֽ��Ǹ���
                for (int i = 0; i < extract; i++) {
                    if (bytes[i] < 0) {
                        cutLength++;
                    }
                }
                //�������ֽ�����ż������Ҫ��ȡ���ֽ����������պ������������ĺ��֣����ȡ�ֽ������䣻�������ֽ�������������ʾ�����Ĳ����������֣���ȡ�ֽ����� 1��
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
     * ��ȡ�ֶ�
     *
     * @param smsContent ��Ҫ��ȡ���ַ���
     * @param cutLength  ÿ�ν�ȡ����
     * @param maxSize    ����ȡ����
     * @return
     */
    public static List<String> processMessage(String smsContent, int cutLength, int maxSize) {
        List<String> list = new ArrayList<String>();
        String cutSms = smsContent;
        String tmpContent = null;
        int cycleCount = 0;
        try {
            double times = Math.ceil((double) cutSms.getBytes().length / cutLength);//�ɽ�ȡ�Ķ���
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
                        list.add(tmpContent);//��һ������
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
     * Gzip��ѹ
     *
     * @param data ������ֽ�����
     * @return ��ѹ����ֽ�����
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
     * Gzipѹ��
     *
     * @param data ������ֽ�����
     * @return ѹ������ֽ�����
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
     * �ж��Ƿ�Ϊ����
     * @param str ������ַ���
     * @return �����ַ���true,���򷵻�false
     */
    public static boolean isNumeric(String str) {
        if (str.isEmpty()) {
            return false;
        } else {
            return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        }
    }

    /*
     * �ж��Ƿ�Ϊ����
     * @param str ������ַ���
     * @return ����������true,���򷵻�false
     */
    public static boolean isInteger(String str) {
        return StringUtils.isNumeric(str) && str.matches("^[-\\+]?[\\d]+$");
    }


    /**
     * &lt;&gt;ת<>
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
     * ���ļ���ת����base64����
     * by quanly
     *
     * @return base64����
     * @throws Exception
     */
    public static String getbase64Code(InputStream inputStream) throws Exception {
        return encodeBase64FileInputStream(inputStream);
    }

    /**
     * <p>���ļ�ת��base64 �ַ���</p>
     * by quanly
     *
     * @param path �ļ�·��
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
     * <p>���ļ���ת��base64 �ַ���</p>
     * by quanly
     *
     * @return base64�ַ���
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
            throw new Exception("���ļ���ת��base64 �ַ���ʧ�ܣ�");
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
     * <p>��base64�ַ����뱣���ļ�</p>
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
     * <p>��base64�ַ������ı��ļ�</p>
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
     * ��Date����ת����ʱ���
     * by quanly
     *
     * @return ʱ���
     * @throws Exception
     */
    public static long getTime(Date date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return (sdf.parse(sdf.format(date))).getTime() / 1000;
    }

    /**
     * ����ʱ���+UUID��ʽ��ȡ16λ�������
     * ʱ���ȡ1970-01-01 08:00:00���뵱ǰʱ�������
     * by quanly
     * @return
     */
    public static String makeRandom(){
        String src = String.valueOf(System.currentTimeMillis()/1000);//�õ���1970-01-01 08:00:00���뵱ǰʱ�������
        String uuid = String.valueOf(UUID.randomUUID());//ͨ��UUID��ȡһ�������
        uuid = uuid.substring(0, 6);//��ȡǰ6λ
        String[] str = array(uuid);//�������ַ�ת��������

        //��ʱ�����UUID�����������У�ȷ��������Ψһ���밲ȫ��
        for(int i = 0; i < str.length; i++){
            src = insertStringInParticularPosition(src, str[i], i*2);
        }
        return src;
    }

    /**
     * ���ַ�������ֳ�����
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
     * ��λ����
     * by quanly
     * @param src ԭʼ��
     * @param dec Ҫ���������
     * @param position Ҫ�����λ��
     * @return
     */
    private static String insertStringInParticularPosition(String src, String dec, int position){
        StringBuffer stringBuffer = new StringBuffer(src);
        return String.valueOf(stringBuffer.insert(position, dec));
    }


}