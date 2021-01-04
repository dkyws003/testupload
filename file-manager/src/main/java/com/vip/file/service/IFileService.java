package com.vip.file.service;

import cn.novelweb.tool.upload.local.pojo.UploadFileParam;
import com.vip.file.dto.AddFileDto;
import com.vip.file.dto.GetFileDto;
import com.vip.file.entity.Files;
import com.vip.file.response.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 文件上传下载 服务类
 * </p>
 *
 * @author LEON
 * @since 2020-05-29
 */
public interface IFileService {
    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    Result<String> uploadFiles(MultipartFile file);

    /**
     * 获取文件输入流
     *
     * @param id
     * @return
     */
    InputStream getFileInputStream(String id);

    /**
     * 获取指定文件详情
     *
     * @param id
     * @return
     */
    Result<Files> getFileDetails(String id);

    /**
     * 分页获取文件信息
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<List<GetFileDto>> getFileList(Integer pageNo, Integer pageSize);

    /**
     * 检查文件MD5
     *
     * @param md5
     * @param fileName
     * @return
     */
    Result checkFileMd5(String md5, String fileName);

    /**
     * 断点续传
     *
     * @param param
     * @param request
     * @return
     */
    Result<Object> breakpointResumeUpload(UploadFileParam param, HttpServletRequest request);

    /**
     * 添加文件
     *
     * @param dto
     * @return
     */
    Result<String> addFile(AddFileDto dto);
}
