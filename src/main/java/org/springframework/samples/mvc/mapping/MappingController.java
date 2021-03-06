package org.springframework.samples.mvc.mapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MappingController {

	@RequestMapping("/mapping/path")
	public @ResponseBody String byPath() {
		return "Mapped by path!";
	}

	@RequestMapping(value="/mapping/path/*", method=RequestMethod.GET)
	public @ResponseBody String byPathPattern(HttpServletRequest request) {
		return "Mapped by path pattern ('" + request.getRequestURI() + "')";
	}

	@RequestMapping(value="/mapping/method", method=RequestMethod.GET)
	public @ResponseBody String byMethod() {
		return "Mapped by path + GET";
	}

	@RequestMapping(value="/mapping/parameter", method=RequestMethod.GET, params="foo")
	public @ResponseBody String byParameter() {
		return "Mapped by path + GET + presence of query parameter!";
	}

	@RequestMapping(value="/mapping/parameter", method=RequestMethod.GET, params="!foo")
	public @ResponseBody String byParameterNegation() {
		return "Mapped by path + GET + absence of query parameter!";
	}

	@RequestMapping(value="/mapping/header", method=RequestMethod.GET, headers="FooHeader=foo")
	public @ResponseBody String byHeader() {
		return "Mapped by path + GET + presence of header!";
	}

	@RequestMapping(value="/mapping/header", method=RequestMethod.GET, headers="!FooHeader")
	public @ResponseBody String byHeaderNegation() {
		return "Mapped by path + GET + absence of header!";
	}

	@RequestMapping(value="/mapping/consumes", method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody String byConsumes(@RequestBody JavaBean javaBean) {
		return "Mapped by path + POST + consumable " + javaBean;
	}

    @RequestMapping(value="/mapping/consumes2", method=RequestMethod.GET)
	public @ResponseBody String byConsumes2(JavaBean javaBean) {
		return "Mapped by path + GET + consumable " + javaBean;
	}

	@RequestMapping(value="/mapping/produces", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody JavaBean byProduces() {
		return new JavaBean();
	}
}
