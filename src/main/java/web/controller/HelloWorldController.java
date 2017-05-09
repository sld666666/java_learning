package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import web.manager.ISpeakerMananger;
import web.manager.SpeakerMananger;

import javax.annotation.Resource;

/**
 * Created by diwu.sld on 2016/1/20.
 */
@Controller
public class HelloWorldController{

    @Resource
    private ISpeakerMananger speaker;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {

        String msg = speaker.say();
        model.addAttribute("message", msg);
        return "hello";
    }

}
