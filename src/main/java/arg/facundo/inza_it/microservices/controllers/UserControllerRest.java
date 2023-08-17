package arg.facundo.inza_it.microservices.controllers;

import arg.facundo.inza_it.microservices.model.AccountDTO;
import arg.facundo.inza_it.microservices.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserControllerRest {
    //Create
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO){

        System.out.println(userDTO.toString());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userDTO.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    //Read
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id){

        UserDTO userDTO = new UserDTO(id,"Facundo","Inza");
        userDTO.setAge(38);

        System.out.println(userDTO.toString());
        return ResponseEntity.ok(userDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> listAllUsers(){
         List<UserDTO> list = List.of(new UserDTO(1,"Facundo","Inza"),
                new UserDTO(2,"Facundo","Inza"),
                new UserDTO(3,"Facundo","Inza"));

         return ResponseEntity.ok(list);
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>>  listAllUsers2(@RequestParam(required = false) String name,
                                          @RequestParam(required = false) String lastName,
                                          @RequestParam(required = false) Integer age){

        List<UserDTO> userDTOList = List.of(new UserDTO(1, "Facundo", "Inza"),
                new UserDTO(2, "Facundo", "Inza"),
                new UserDTO(3, "Facundo", "Inza"));

        userDTOList = userDTOList.stream().filter( u -> u.getName().contains(name)).collect(Collectors.toList());

        return ResponseEntity.ok(userDTOList);
    }
    @GetMapping("/{id}/accounts")
    public ResponseEntity<List<AccountDTO>> getUserAccounts(@PathVariable Integer id) {

        List<AccountDTO> list = List.of(new AccountDTO("google"), new AccountDTO("facebook") , new AccountDTO("Twitter"));

        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}/accounts/{accountId}")
    public ResponseEntity<AccountDTO> getUserAccountById(@PathVariable Integer id, @PathVariable Integer accountId) {

        AccountDTO accountDTO = new AccountDTO("google");

        return ResponseEntity.ok(accountDTO);
    }
    //Update
    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userDTO);
    }

    //Delete
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        return "http://localhost:8080/api/v1/users/" + id;
    }

}
