package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.RealTimeLocation;
import cc.mrbird.febs.cos.dao.RealTimeLocationMapper;
import cc.mrbird.febs.cos.service.IRealTimeLocationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author FanK
 */
@Service
public class RealTimeLocationServiceImpl extends ServiceImpl<RealTimeLocationMapper, RealTimeLocation> implements IRealTimeLocationService {

}
