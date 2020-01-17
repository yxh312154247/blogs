package blogs.service.service.impl;

import blogs.service.pojo.Message;
import blogs.service.mapper.MessageMapper;
import blogs.service.service.MessageService;
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
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
