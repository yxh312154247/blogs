package blogs.service.service.impl;

import blogs.service.pojo.Link;
import blogs.service.mapper.LinkMapper;
import blogs.service.service.LinkService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangxianghua
 * @since 2020-01-17
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

}
