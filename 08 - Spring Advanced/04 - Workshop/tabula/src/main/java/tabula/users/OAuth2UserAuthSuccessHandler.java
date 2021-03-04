package tabula.users;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import tabula.users.model.UserEntity;
import tabula.users.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2UserAuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

  private final UserService userService;
  private final UserDetailsService userDetailsService;

  public OAuth2UserAuthSuccessHandler(UserService userService,
                                      UserDetailsService userDetailsService) {
    this.userService = userService;
    this.userDetailsService = userDetailsService;

    // this might be configurable
    setDefaultTargetUrl("/home");
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws ServletException, IOException {

    if (authentication instanceof OAuth2AuthenticationToken) {
      OAuth2AuthenticationToken oAuth2AuthenticationToken =
          (OAuth2AuthenticationToken)authentication;

      String email =
          oAuth2AuthenticationToken.
              getPrincipal().
              getAttribute("email");

      UserEntity userEntity = userService.getOrCreateUser(email);
      //should not be null
      UserDetails userDetails = userDetailsService.loadUserByUsername(userEntity.getEmail());

      authentication = new
          UsernamePasswordAuthenticationToken(
              userDetails,
              null,
          userDetails.getAuthorities()
      );
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    super.onAuthenticationSuccess(request, response, authentication);
  }
}
