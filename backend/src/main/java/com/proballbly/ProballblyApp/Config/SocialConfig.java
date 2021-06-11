package com.proballbly.ProballblyApp.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

import javax.inject.Inject;

@Configuration
public class SocialConfig {

    @Autowired
    private Environment environment;

//    @Bean
//    public ConnectionFactoryLocator connectionFactoryLocator(){
//        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
//        registry.addConnectionFactory(new TwitterConnectionFactory(
//                environment.getProperty("twitter.consumerKey"),
//                environment.getProperty("twitter.consumerSecret")));
//        return registry;
//
//    }

    String consumerKey = "..."; // The application's consumer key
    String consumerSecret = "..."; // The application's consumer secret
    String accessToken = "..."; // The access token granted after OAuth authorization
    String accessTokenSecret = "..."; // The access token secret granted after OAuth authorization
    Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
}
