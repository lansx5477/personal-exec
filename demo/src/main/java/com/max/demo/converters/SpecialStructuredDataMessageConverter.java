package com.max.demo.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.max.demo.annotations.SpecialData;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/01/31/14:23
 * @Description: 自定义的消息转换器，用于处理特定结构的数据（媒体类型为 application/x-special）
 * @Version 1.0
 */
public class SpecialStructuredDataMessageConverter implements HttpMessageConverter {

    private static ThreadLocal<ObjectMapper> mapperThread = ThreadLocal.withInitial(ObjectMapper::new);

    private static Logger logger = LoggerFactory.getLogger(SpecialStructuredDataMessageConverter.class);

    @Override
    public boolean canRead(Class clazz, MediaType mediaType) {
        return false;
    }

    /**
     * 该 MessageConverter 用于将添加了 @SpecialData 注解的对象写为特定格式
     * @param clazz the class to test for writability
     * @param mediaType the media type to write (can be {@code null} if not specified);
     * typically the value of an {@code Accept} header.
     * @return
     */
    @Override
    public boolean canWrite(Class clazz, MediaType mediaType) {
        return clazz.getDeclaredAnnotation(SpecialData.class) != null ? true : false;
    }

    /**
     * 服务器要统计所有 MessageConverter 都能写出哪些内容类型：application/x-special、...
     * @return
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-special");
    }

    @Override
    public Object read(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    /**
     * 将添加了指定注解的对象序列化并进行sha-1加密
     * @param o the object to write to the output message. The type of this object must have previously been
     * passed to the {@link #canWrite canWrite} method of this interface, which must have returned {@code true}.
     * @param contentType the content type to use when writing. May be {@code null} to indicate that the
     * default content type of the converter must be used. If not {@code null}, this media type must have
     * previously been passed to the {@link #canWrite canWrite} method of this interface, which must have
     * returned {@code true}.
     * @param outputMessage the message to write to
     * @throws Exception
     */
    @Override
    public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String json = mapperThread.get().writeValueAsString(o);
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            logger.error("获取加密算法失败", e);
            outputMessage.getBody().write(json.getBytes());
            return;
        }
        md.update(json.getBytes(StandardCharsets.UTF_8));
        String digest = String.valueOf(Hex.encodeHex(md.digest()));
        OutputStream body = outputMessage.getBody();
        body.write(digest.getBytes());
    }
}
