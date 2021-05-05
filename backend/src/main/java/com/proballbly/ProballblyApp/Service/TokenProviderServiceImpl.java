package com.proballbly.ProballblyApp.Service;

import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.*;

@Service
public class TokenProviderServiceImpl implements TokenProviderService {
    private static final String TOKEN = "4b7d0d80c6784f3886c2ec32b4fdce4d";

    @Override
    public String getToken() {
        return TOKEN;
    }

    @Override
    public boolean hasToken() {
        String token = getToken();
        return StringUtils.isNotEmpty(token);

    }
}
