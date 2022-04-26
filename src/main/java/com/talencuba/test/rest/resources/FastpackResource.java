package com.talencuba.test.rest.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talencuba.test.rest.model.LinePackedItems;
import com.talencuba.test.rest.service.FastpackService;

/**
 * @author Dalia Maria Berbes
 *
 */
@RestController
@RequestMapping("/fastpack")
public class FastpackResource {
	private static final Logger logger = LoggerFactory.getLogger(FastpackResource.class);
	
	@Autowired
	FastpackService service;
	
	@GetMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinePackedItems> getLinePackages(@RequestParam String items) {
		LinePackedItems obj = service.maximizeNumberItemsPerBox(items);
				
		return new ResponseEntity<LinePackedItems>(obj,HttpStatus.OK);
	}
	
}
