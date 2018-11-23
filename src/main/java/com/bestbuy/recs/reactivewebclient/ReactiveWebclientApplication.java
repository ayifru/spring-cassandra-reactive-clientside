package com.bestbuy.recs.reactivewebclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@SpringBootApplication
public class ReactiveWebclientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveWebclientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        WebClient.create("http://localhost:9090/annotation/das/batchdataset/find/flux")
                .method(HttpMethod.POST).contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject("[{\"driver\":\"d1\", \"name\":\"tstab\", " +
                        "\"version\":\"1.0\"},{\"driver\":\"d2\", " +
                        "\"name\":\"tstab\", \"version\":\"1.0\"},{\"driver\":\"d3\", " +
                        "\"name\":\"tstab\", \"version\":\"1.0\"}]"))
                .accept(MediaType.APPLICATION_STREAM_JSON).retrieve()
                .bodyToFlux(BatchDataset.class).map(String::valueOf).subscribe(System.out::println);
    }
}
