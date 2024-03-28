import java.math.BigInteger;
import java.security.MessageDigest;

/**
* @ClassName: MD5Util
* @Description:MD5加密/验证工具类
* @author weny.yang
* @date May 11, 2021
*/
public class MD5Util {
    
    /**
     * @Title: md5Lower
     * @Description:不加盐值32位小写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5Lower(String plainText) {
        String md5 = null;
        if (null != plainText && !"".equals(plainText)) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(plainText.getBytes("UTF-8"));
                md5 =  new BigInteger(1, md.digest()).toString(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return md5;
    }
    
    /**
     * @Title: md5Lower
     * @Description:加盐值32位小写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5Lower(String plainText, String saltValue) {
        String md5 = null;
        if (null != plainText && !"".equals(plainText) && null != saltValue && !"".equals(saltValue)) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(plainText.getBytes("UTF-8"));
                md.update(saltValue.getBytes("UTF-8"));
                md5 = new BigInteger(1, md.digest()).toString(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return md5;
    }
    
    /**
     * @Title: md5_16Lower
     * @Description:不加盐值16位小写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5_16Lower(String plainText) {
        String md5 = md5Lower(plainText);
        return null==md5?md5:md5.substring(8, 24);
    }
    
    /**
     * @Title: md5_16Lower
     * @Description:加盐值16位小写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5_16Lower(String plainText, String saltValue) {
        String md5 = md5Lower(plainText, saltValue);
        return null==md5?md5:md5.substring(8, 24);
    }
    
    /**
     * @Title: md5_16Upper
     * @Description:不加盐值16位大写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5_16Upper(String plainText) {
        String md5 = md5_16Lower(plainText);
        return null==md5?md5:md5.toUpperCase();
    }
 
    /**
     * @Title: md5_16Upper
     * @Description:加盐值16位大写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5_16Upper(String plainText, String saltValue) {
        String md5 = md5_16Lower(plainText, saltValue);
        return null==md5?md5:md5.toUpperCase();
    }
 
    /**
     * @Title: md5Upper
     * @Description:不加盐值32位大写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5Upper(String plainText) {
        String md5 = md5Lower(plainText);
        return null==md5?md5:md5.toUpperCase();
    }
    
    /**
     * @Title: md5Upper
     * @Description:加盐值32位大写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5Upper(String plainText, String saltValue) {
        String md5 = md5Lower(plainText, saltValue);
        return null==md5?md5:md5.toUpperCase();
    }
    
    
 
    public static void main(String[] args) {
        String plainText = "c08a042b47bb47838db5d918a85fe86d{\"address\":\"南栅六区民昌路七巷三号\",\"blRbillcode\":1,\"city\":\"东莞市\",\"county\":\"虎门镇\",\"customerCode\":\"1387641\",\"itemName\":\"电话费的订单物品请发此单\",\"mobile\":\"18868456179\",\"name\":\"陈韦撒旦法\",\"orderType\":\"01\",\"payType\":\"现付\",\"phone\":\"\",\"pieceNumber\":1,\"prov\":\"广东省\",\"recCompany\":\"都挺好食品店\",\"remark\":\"电商事业部\",\"sendAddress\":\"金花路29号\",\"sendCity\":\"深圳市\",\"sendCompany\":\"天地通自动化设备有限公司\",\"sendCounty\":\"福田区\",\"sendMobile\":\"18868456179\",\"sendName\":\"星新城\",\"sendPhone\":\"\",\"sendProv\":\"广东省\",\"txLogisticId\":\"KDN2306011150000019\",\"weight\":2.6}";//明文
        String saltValue = "8";//盐值
 

        System.out.println(md5Lower(plainText));

        System.out.println("====================");

    }
}