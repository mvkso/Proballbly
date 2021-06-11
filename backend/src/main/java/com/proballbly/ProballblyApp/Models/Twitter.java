package com.proballbly.ProballblyApp.Models;

import org.springframework.social.twitter.api.*;

public interface Twitter {

    boolean isAuthorizedForUser();

    DirectMessageOperations directMessageOperations();

    FriendOperations friendOperations();

    GeoOperations geoOperations();

    ListOperations listOperations();

    SearchOperations searchOperations();

    TimelineOperations timelineOperations();

    UserOperations userOperations();
}
