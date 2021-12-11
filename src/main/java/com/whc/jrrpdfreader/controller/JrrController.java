package com.whc.jrrpdfreader.controller;

import com.whc.jrrpdfreader.dto.ContentDTO;
import com.whc.jrrpdfreader.utils.JavaReadPDF;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.Optional;

/**
 * @author whc
 * @Title: JrrController
 * @Package: com.whc.jrrpdfreader
 * @Description:
 * @date 2021/12/9  19:50
 */
@Api(tags = "论文信息读取")
@RestController
@RequestMapping("/read")
public class JrrController {

    @Resource
    private JavaReadPDF javaReadPDF;


    @ApiOperation("批量获取pdf内信息")
    @PostMapping("/getInfo")
    public List<ContentDTO> getPDFInfo(@RequestParam(value = "FilePath") String FilePath) throws Exception {

        return javaReadPDF.readPDFAll(FilePath);
    }

}
