//package com.oauth2.springoauth.configuration;
//
//import java.util.function.Consumer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//
//
////@EnableWebFluxSecurity
//public class OAuth2LoginSecurityConfig {
//  @Autowired
//  private ReactiveClientRegistrationRepository clientRegistrationRepository;
//
//  @Bean
//  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//    http
//        .authorizeExchange(authorize -> authorize
//            .anyExchange().authenticated()
//        )
//        .oauth2Login(oauth2 -> oauth2
//            .authorizationRequestResolver(
//                authorizationRequestResolver(this.clientRegistrationRepository)
//            )
//        );
//    return http.build();
//  }
//
//  private ServerOAuth2AuthorizationRequestResolver authorizationRequestResolver(
//      ReactiveClientRegistrationRepository clientRegistrationRepository) {
//
//    DefaultServerOAuth2AuthorizationRequestResolver authorizationRequestResolver =
//        new DefaultServerOAuth2AuthorizationRequestResolver(
//            clientRegistrationRepository);
//    authorizationRequestResolver.setAuthorizationRequestCustomizer(
//        authorizationRequestCustomizer());
//
//    return  authorizationRequestResolver;
//  }
//
//  private Consumer<Builder> authorizationRequestCustomizer() {
//    return customizer -> customizer
//        .additionalParameters(params -> params.put("prompt", "consent"));
//  }
//}
