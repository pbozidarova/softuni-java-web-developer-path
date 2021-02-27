package advanced.spring.rest.web;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(AuthorNamespace.URI_AUTHORS)
public interface AuthorNamespace {
    String URI_AUTHORS="/authors";
}
