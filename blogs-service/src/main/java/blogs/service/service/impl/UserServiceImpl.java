package blogs.service.service.impl;

import blogs.service.pojo.User;
import blogs.service.mapper.UserMapper;
import blogs.service.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
