package com.domain.HostMonitor.controllers;

import com.domain.HostMonitor.models.ApiKey;
import com.domain.HostMonitor.models.Host;
import com.domain.HostMonitor.repositories.ApiKeyRepository;
import com.domain.HostMonitor.repositories.HostRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.codec.binary.Hex;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(path = "/host")
public class HostController {

    private final HostRepository repository;

    private final ApiKeyRepository repositoryApikey;

    public HostController(HostRepository repository, ApiKeyRepository repositoryApikey) {
        this.repository = repository;
        this.repositoryApikey = repositoryApikey;
    }

    @Operation(summary = "Add a new host", description = "Add a new host to monitor")
    @PostMapping("/{api_key}")
    Host addhost(@PathVariable String api_key, @RequestBody Host new_host) throws NoSuchAlgorithmException {

        MessageDigest salt = MessageDigest.getInstance("SHA-256");
        salt.update(api_key.concat("salt").getBytes(StandardCharsets.UTF_8));
        String digest = Hex.encodeHexString(salt.digest());

        ApiKey apikeyowner = repositoryApikey.findBykeyhash(digest);

        new_host.setApikey(apikeyowner);
        repository.save(new_host);
        return null;
    }
}
