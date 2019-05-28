package com.coop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coop.business.IGraphBusiness;

@RestController
@RequestMapping(Constantes.URL_GRAPH)
public class GraphRESTService {

	@Autowired
	private IGraphBusiness graphService;

	@GetMapping(value = { "/push" })
	public void push() {

		graphService.pushGraphData();

	}

}
