package com.example;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class PageController {

	private static final Logger LOG = LoggerFactory.getLogger(PageController.class);

	@Get("/page")
	public Page<String> getPage(Pageable pageable) {
		LOG.info("Getting Page.");

		final List<String> content = new ArrayList<>();
		content.add("FOO");
		content.add("BAR");
		content.add("BERLIN");
		return Page.of(content, pageable, 100);
	}

}
