package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Entrada");
        String output = "Hello, Papa Noel!";
        System.out.println("Salida: " + output);
        return output;
    }

    @GetMapping("/reverse")
    public String reverseString(@RequestParam("input") String input) {
        System.out.println("Entrada: " + input);
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        String output = reversed.toString();
        System.out.println("Salida: " + output);
        return output;
    }

    // operación para eliminar las vocales de una cadena
    @GetMapping("/removeVowels")
    public String removeVowels(@RequestParam("input") String input) {
        System.out.println("Entrada: " + input);
        String output = input.replaceAll("[AEIOUaeiou]", "");
        System.out.println("Salida: " + output);
        return output;
    }

    @GetMapping("/isPalindrome")
    public boolean isPalindrome(@RequestParam("input") String input) {
        StringBuilder reversed = new StringBuilder(input).reverse();
        return input.equals(reversed.toString());
    }
}
