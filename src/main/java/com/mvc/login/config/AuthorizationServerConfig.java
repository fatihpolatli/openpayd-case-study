package com.mvc.login.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * AuthorizationConfig
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    DataSource dataSource;

    @Autowired
    PasswordEncoder passwordEncoder;

    
    /** 
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // clients.jdbc(dataSource)
        clients.inMemory().withClient("testClient").secret(passwordEncoder.encode("secret"))
                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT", "USER", "ROLE_ADMIN", "ADMIN")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
                .scopes("read,write").autoApprove(true);
        /*
         * clients.inMemory().withClient(CLIENT_ID).secret(CLIENT_SECRET)
         * .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN)
         * .scopes(SCOPE_READ, SCOPE_WRITE,
         * TRUST).accessTokenValiditySeconds(VALID_FOREVER)
         * .refreshTokenValiditySeconds(VALID_FOREVER);
         */
    }

    
    /** 
     * @return TokenStore
     */
    @Bean
    public TokenStore tokenStore() {
        // return new InMemoryTokenStore();
        return new JdbcTokenStore(dataSource);
    }

    
    /** 
     * @param endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
    }
}