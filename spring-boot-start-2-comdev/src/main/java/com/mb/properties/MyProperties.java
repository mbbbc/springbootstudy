package com.mb.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Setter
@Getter
@NoArgsConstructor
public class MyProperties {
	@Value("${com.mb.name}")
	private String name;
	
	@Value("${com.mb.description}")
	private String description;
}
