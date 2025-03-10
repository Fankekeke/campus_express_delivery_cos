package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.PriceRules;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.LinkedHashMap;

/**
 * @author FanK fan1ke2ke@gmail.com
 */
public interface IPriceRulesService extends IService<PriceRules> {

    /**
     * 分页获取价格规则信息
     *
     * @param page       分页对象
     * @param priceRules 价格规则信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryPriceRulesPage(Page<PriceRules> page, PriceRules priceRules);
}
