package com.domain.HostMonitor.controllers;

import com.domain.HostMonitor.exceptions.ResourceNotFoundException;
import org.apache.commons.codec.binary.Hex;
import com.domain.HostMonitor.models.ApiKey;
import com.domain.HostMonitor.repositories.ApiKeyRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/apikey", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ApiKeyController {

    private final ApiKeyRepository repository;


    public ApiKeyController(ApiKeyRepository repository) {

        this.repository = repository;
    }

    @Operation(summary = "Generate API key", description = "Generate a new API Key")
    @PostMapping("/")
    UUID createApiKey(@Validated @RequestBody ApiKey new_apiKey) throws NoSuchAlgorithmException {
        ApiKey apikey = new ApiKey();
        UUID genkey = UUID.randomUUID();
        MessageDigest salt = MessageDigest.getInstance("SHA-256");
        salt.update(genkey.toString().concat("salt").getBytes(StandardCharsets.UTF_8));
        String digest = Hex.encodeHexString(salt.digest());
        apikey.setEmail(new_apiKey.getEmail());
        apikey.setKeyhash(digest);
        repository.save(apikey);
        return genkey;
    }

    @Operation(summary = "Get API key info", description = "Get detailed info about your API key")
    @GetMapping("/{api_key}")
    ApiKey one(@PathVariable String api_key) throws ResourceNotFoundException, NoSuchAlgorithmException {
        MessageDigest salt = MessageDigest.getInstance("SHA-256");
        salt.update(api_key.concat("salt").getBytes(StandardCharsets.UTF_8));
        String digest = Hex.encodeHexString(salt.digest());

        Optional<ApiKey> apikeyinfo = Optional.ofNullable(repository.findBykeyhash(digest));
        return apikeyinfo.orElseThrow(() -> new ResourceNotFoundException("Resource not found by this id"));
    }
}
