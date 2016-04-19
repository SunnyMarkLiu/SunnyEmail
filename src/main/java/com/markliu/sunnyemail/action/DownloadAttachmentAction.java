package com.markliu.sunnyemail.action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 19, 2016 3:15:38 PM
 */
@Controller
@Scope("prototype")
public class DownloadAttachmentAction extends ActionSupport {

	private static final long serialVersionUID = 509489161841629163L;
	
    private String fileName;
    public String getFileName() throws UnsupportedEncodingException {
        /*
         * HTTP协议将响应按照ISO-8859-1编码格式进行转换之后再传递。
         * 因此，为防止客户端显示下载的文件名出现中文乱码，需要将fileName
         * 从UTF-8 --> ISO-8859-1
         */
        String name = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        System.out.println("服务器发送的文件名："+name);
        return name;
    }

    public void setFileName(String fileName) throws UnsupportedEncodingException {
        this.fileName = fileName;
    }

    /*
     * 返回一个输入流，作为一个客户端来说为输入流，但对于服务器端为输出流
     */
    public InputStream getDownloadFileAsInputStream() throws Exception {
        // 根据资源路径获取输入流,注意此处的fileName仍让是UTF-8编码
        InputStream in = new FileInputStream("E:\\email_attachments\\upload\\"+fileName);
        return in;
    }
}
