package dev.greencashew.linkshortener.controller;

import dev.greencashew.linkshortener.link.LinkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
class RedirectController {

    private final LinkService linkService;

    RedirectController(final LinkService linkService){
        this.linkService = linkService;
    }


    @GetMapping(path = "/s/{id}")
    public void redirectLink(
            @PathVariable String id,
            HttpServletResponse httpServletResponse

            ) throws IOException {

                String targetUrl = linkService.gatherLinkAndIncrementVisits(id);
                httpServletResponse.sendRedirect(targetUrl);
    }
}
