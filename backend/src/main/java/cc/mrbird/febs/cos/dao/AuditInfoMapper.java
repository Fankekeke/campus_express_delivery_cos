package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.AuditInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK fan1ke2ke@gmail.com
 */
public interface AuditInfoMapper extends BaseMapper<AuditInfo> {

    /**
     * 分页获取审核信息
     *
     * @param page      分页对象
     * @param auditInfo 审核信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryAuditPage(Page<AuditInfo> page, @Param("auditInfo") AuditInfo auditInfo);
}
