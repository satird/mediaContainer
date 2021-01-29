package ru.satird.mediaContainer.security.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.satird.mediaContainer.domain.AuthenticationProvider;
import ru.satird.mediaContainer.domain.User;
import ru.satird.mediaContainer.repository.UserRepository;
import ru.satird.mediaContainer.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private CustomOAuth2UserService customOAuth2UserService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();

        String email = oAuth2User.getEmail();
        String name = oAuth2User.getName();
        AuthenticationProvider provider = oAuth2User.getProvider();

        User user = userRepository.findByEmail(email);

        if (user == null) {
            userService.createNewUserAfterOAuthLoginSuccess(oAuth2User);
        } else {
            userService.updateUserAfterOAuthLoginSuccess(user, name, provider);
        }


        super.onAuthenticationSuccess(request, response, authentication);
    }
}
