package pl.camp.it;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.camp.it.model.Address;
import pl.camp.it.model.User;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        String url = "http://localhost:8080/user/";

        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(url + "1", User.class, new HashMap<>());

        System.out.println(user);

        Address address1 = new Address();
        address1.setId(1);
        address1.setCity("Wadowice");
        address1.setStreet("Energetków");
        address1.setNo(7);

        User user1 = new User();
        user1.setId(1);
        user1.setLogin("piotrek");
        user1.setPass("123");
        user1.setAddress(address1);

        //------------------------NAGŁÓWKI-----------------------------
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("important-header", "costam");

        //------------------------ZAPYTANIE (REQUEST)-------------------
        HttpEntity<User> request = new HttpEntity<>(user1, httpHeaders);

        //------------------------WYKONANIE ZAPYTANIA--------------------
        User responseEntity = restTemplate.postForObject(url + "1", request, User.class, new HashMap<>());
        System.out.println(responseEntity);

    }
}
