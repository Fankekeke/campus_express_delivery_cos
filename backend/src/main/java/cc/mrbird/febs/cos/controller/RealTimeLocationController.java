package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.RealTimeLocation;
import cc.mrbird.febs.cos.service.IRealTimeLocationService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/real-time-location")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RealTimeLocationController {

    private final IRealTimeLocationService realTimeLocationService;

    /**
     * 获取ID获取实时位置详情
     *
     * @param id 主键
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(realTimeLocationService.getById(id));
    }

    /**
     * 获取实时位置信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(realTimeLocationService.list());
    }

    /**
     * 新增实时位置信息
     *
     * @param realTimeLocation 实时位置信息
     * @return 结果
     */
    @PostMapping
    public R save(RealTimeLocation realTimeLocation) {
        realTimeLocation.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(realTimeLocationService.save(realTimeLocation));
    }

    /**
     * 修改实时位置信息
     *
     * @param realTimeLocation 实时位置信息
     * @return 结果
     */
    @PutMapping
    public R edit(RealTimeLocation realTimeLocation) {
        return R.ok(realTimeLocationService.updateById(realTimeLocation));
    }

    /**
     * 删除实时位置信息
     *
     * @param ids ids
     * @return 实时位置信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(realTimeLocationService.removeByIds(ids));
    }
}
