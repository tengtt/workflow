package workflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by teng on 2016/7/28.
 */

@Controller
@RequestMapping(value = "/workflow")
public class ActivitiController {

    protected Logger logger = LoggerFactory.getLogger(getClass());
}
