package blogs.service.service.impl;

import blogs.service.pojo.Category;
import blogs.service.mapper.CategoryMapper;
import blogs.service.service.CategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
