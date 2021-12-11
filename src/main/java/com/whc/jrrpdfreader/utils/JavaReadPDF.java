package com.whc.jrrpdfreader.utils;

import com.whc.jrrpdfreader.dto.ContentDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author whc
 * @Title: JavaReadPDF
 * @Package: com.whc.jrrpdfreader.utils
 * @Description:
 * @date 2021/12/9  19:32
 */
@Service
public class JavaReadPDF {

    /**
     * 单张pdf获取
     * @param path
     * @return
     * @throws IOException
     */
    public ContentDTO readPDF(String path) throws IOException {

        ContentDTO result = new ContentDTO();

        File file = new File(path);
        PDDocument pdDocument = PDDocument.load(file);
        PDDocumentInformation information = pdDocument.getDocumentInformation();
        result.setAuthor(information.getAuthor());
        result.setTitle(information.getTitle());
        result.setCreator(information.getCreator());
        result.setSubject(information.getSubject());
        result.setPath(path);
        return result;
    }

    /**
     * 批量pdf获取
     * @param path
     * @return
     * @throws Exception
     */
    public List<ContentDTO> readPDFAll(String path) throws Exception {

        File file = new File(path);
        List<ContentDTO> result = new ArrayList<>();
        if (!file.isDirectory()) {
            throw new Exception("该路径不是一个文件夹");
        }
        for (File file1 : file.listFiles()) {
            if (!file1.isFile()) {
                throw new Exception(file1.getName() + " 不是一个文件");
            } else {
                result.add(readPDF(file1.getAbsolutePath()));
            }
        }
        return result;
    }

    /**
     * 一键生成excel文件
     */
    public boolean generateExcel(String path) {
        return false;
    }
}


