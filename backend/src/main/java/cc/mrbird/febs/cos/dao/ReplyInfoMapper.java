package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.ReplyInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface ReplyInfoMapper extends BaseMapper<ReplyInfo> {

    /**
     * 分页查询回复信息
     *
     * @param page      分页对象
     * @param replyInfo 回复信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryReplyPage(Page<ReplyInfo> page, @Param("replyInfo") ReplyInfo replyInfo);
}
