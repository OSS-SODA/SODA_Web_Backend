package com.soda.web.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HeaderTokenExtractorTest {

    private HeaderTokenExtractor extractor = new HeaderTokenExtractor();
    private String header;

    @BeforeEach
    public void setUP() {
        this.header = "Bearer 123.345.1237";
    }

    @Test
    public void jwtExtractTest() {
        assertThat(extractor.extract(this.header)).isEqualTo("123.345.1237");
    }

}