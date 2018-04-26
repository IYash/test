package com.design.pattern.action.observer.my.client;

import com.design.pattern.action.observer.my.biz.Mediator;
import com.design.pattern.action.observer.my.biz.UserMediator;
import com.design.pattern.action.observer.my.biz.UserObserver;
import com.design.pattern.action.observer.my.biz.common.*;
import com.design.pattern.action.observer.my.entity.User;

/**
 * @author huangchangling on 2017/11/10 0010
 */
public class ProcessTest {

    public static void main(String[] args) {

        UserObserver observer = new UserObserver();

        Mediator mediator = new UserMediator();

        mediator.attachObserver(observer);

        createSubcriber(mediator);

        createPublisher(mediator);

    }

    private static void createSubcriber(Mediator mediator) {


        StringBuilder actions =new StringBuilder(50);
        actions.append(ActionConfig.Action.like.name()).append(CommonConstant.SPLIT).append(ActionConfig.Action.comment.name());
        User sub = new User(mediator);
        sub.setId(GenerateId.INSTANCE.nextId(sub));
        sub.setName("JACK");
        sub.individual(CommonConstant.TARGET,1);
        sub.individual(CommonConstant.TARGET_TYPE, TargetTypeConfig.targetType.post.name());
        sub.individual(CommonConstant.ACTION, actions.toString());
        sub.subscribe();
        System.out.println("-----------------"+sub.toString()+"-------subscribe info------");
    }

    private static void createPublisher(Mediator mediator) {
        User pub = new User(mediator);
        pub.setId(GenerateId.INSTANCE.nextId(pub));
        pub.setName("ROSE");
        pub.individual(CommonConstant.TARGET,1);
        pub.individual(CommonConstant.TARGET_TYPE, TargetTypeConfig.targetType.post.name());
        pub.individual(CommonConstant.ACTION, ActionConfig.Action.like.name());
        pub.individual(CommonConstant.CONTENT,"ROSE LIKE THE POST");
        pub.individual(CommonConstant.TYPE, TypeConfig.Type.notify.name());
        pub.publish();
        System.out.println("-----------------"+pub.toString()+"-------publish info------");
    }
}
