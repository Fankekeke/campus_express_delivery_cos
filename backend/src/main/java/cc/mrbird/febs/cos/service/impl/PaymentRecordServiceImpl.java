package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.dao.PaymentRecordMapper;
import cc.mrbird.febs.cos.entity.PaymentRecord;
import cc.mrbird.febs.cos.service.IPaymentRecordService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK fan1ke2ke@gmail.com
 */
@Service
public class PaymentRecordServiceImpl extends ServiceImpl<PaymentRecordMapper, PaymentRecord> implements IPaymentRecordService {

    /**
     * 分页获取缴费信息
     *
     * @param page          分页对象
     * @param paymentRecord 缴费信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> queryPaymentPage(Page<PaymentRecord> page, PaymentRecord paymentRecord) {
        return baseMapper.queryPaymentPage(page, paymentRecord);
    }
}
