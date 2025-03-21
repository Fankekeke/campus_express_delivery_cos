package cc.mrbird.febs.cos.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 审核管理
 *
 * @author FanK fan1ke2ke@gmail.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AuditInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 图片
     */
    private String images;

    /**
     * 申请时间
     */
    private String createDate;

    /**
     * 审核状态 0.未审核 1.审核通过 2.驳回
     */
    private Integer auditStatus;

    /**
     * 状态时间
     */
    private String statusDate;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 标签
     */
    private String tag;

    @TableField(exist = false)
    private String merchantCode;

    @TableField(exist = false)
    private String merchantName;

    @TableField(exist = false)
    private String principal;
}
