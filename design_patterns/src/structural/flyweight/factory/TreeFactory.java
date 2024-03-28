package structural.flyweight.factory;

import structural.flyweight.flyweight.TreeType;

import java.awt.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaoyl
 * @Date: 2023/07/12/21:46
 * @Description:
 */
public class TreeFactory {


    /**
     * 享元缓存池
     */
    public static Map<String, TreeType> treeTypes = new ConcurrentHashMap<>();




    // todo 并发问题待解决
    public static TreeType getTreeType(String name, Color color, String otherTreeData) {
        String key = calculateKey(name, color, otherTreeData);
        if (key == null) {
            key = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        }
        TreeType type = treeTypes.get(key);
        if (type == null) {
            type = new TreeType(name, color, otherTreeData);
            treeTypes.put(key, type);
        }
        return type;
    }

    private static String calculateKey(String name, Color color, String otherTreeData) {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(color.toString());
        sb.append(otherTreeData);
        MessageDigest md = null;
        String key = "";
        // md5+base64
        try {
            md = MessageDigest.getInstance("MD5");
            key = Base64.getEncoder().encodeToString(md.digest(sb.toString().getBytes("UTF-8"))).toLowerCase();
        } catch (Exception e) {
            return null;
        }
        return key;
    }


}
