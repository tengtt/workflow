package workflow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by teng on 2016/7/28.
 * 测试
 */

@Controller
@RequestMapping(value = "/workflow")
public class ActivitiController {

//    protected Logger logger = LoggerFactory.getLogger(getClass());

    public void main(String[] args){
        System.out.print(true);
    }
}
