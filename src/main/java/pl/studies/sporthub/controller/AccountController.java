package pl.studies.sporthub.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.studies.sporthub.service.account.AccountDto;
import pl.studies.sporthub.service.account.AccountService;


@RestController
@RequestMapping("accounts")
public class AccountController extends BaseApiController {

    private final AccountService service;


    public AccountController(AccountService service) {
        this.service = service;
    }


    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id){
        try {
            AccountDto account = service.load(id);
            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDto> registerAccount(AccountDto dto){
        try{
            Long idRegisteredAccount = service.register(dto);
            AccountDto registeredAccount = service.load(idRegisteredAccount);
            return new ResponseEntity<>(registeredAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
