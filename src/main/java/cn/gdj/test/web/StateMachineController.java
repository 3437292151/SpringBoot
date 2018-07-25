package cn.gdj.test.web;

import cn.gdj.test.bean.Events;
import cn.gdj.test.bean.States;
import org.springframework.statemachine.StateMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2018-7-19.
 */
@RestController
public class StateMachineController {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @RequestMapping("/testMachine")
    public void testMachine() {
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
    }

}
